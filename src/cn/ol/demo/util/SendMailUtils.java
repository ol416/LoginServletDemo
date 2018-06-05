package cn.ol.demo.util;

import cn.ol.demo.util.MailUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static cn.ol.demo.util.ActiveUserCodeUtil.createActiveUserCode;

//@WebServlet(urlPatterns = {"/testReg.do"})

//, initParams = {
//@WebInitParam(name = "smtphost", value = "smtp.sina.com"),
//@WebInitParam(name= "mailusername" ,value = "yan1136515352@sina.com"),
//@WebInitParam(name = "mailpassword", value = "ullk89mXXyan"),
//@WebInitParam(name = "mailfrom", value = "yan1136515352@sina.com"),
//@WebInitParam(name = "port", value = "25")
//}


public class SendMailUtils extends HttpServlet {
    private ServletConfig Servletconf;
    private String username;
    private String email;
    private String msg;
    private String smtphost;
    private String mailusername;
    private String mailpassword;
    private String mailfrom;
    private String port;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.Servletconf=config;
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        username=request.getParameter("username");
        email=request.getParameter("email");
        /*
         * ……
         *
         * 省略注册并写入数据库部分
         * ……
         *
         */

        /*
         *
         * 注册成功，发送欢迎邮件
         *
         */
        System.out.println(username+"|"+email);
        if(sendmail(email,username))
        {
            msg="邮件发送成功";
        }
        else
        {
            msg="邮件发送失败";

        }
        toResponse(response,msg);
    }

    private boolean sendmail(String mailto,String username){
        //设置邮件发送时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(currentDate);
        Properties properties = new Properties();
        try{
            String configurationFile = URLDecoder.decode(this.getClass().getResource("/").getPath(), "UTF-8") + "mail.properties";
            InputStream in = new BufferedInputStream(new FileInputStream(configurationFile));
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "GBK"));
            properties.load(bf);     ///加载属性列表
            smtphost = properties.getProperty("smtphost");
            mailusername = properties.getProperty("mailusername");
            mailpassword = properties.getProperty("mailpassword");
            mailfrom = properties.getProperty("mailfrom");
            port = properties.getProperty("port", "25");
//            Enumeration enumeration = properties.propertyNames();
//            while(enumeration.hasMoreElements()){
//                String Key = (String) enumeration.nextElement();
//                String Value = properties.getProperty(Key);
//                System.out.println(Key + Value);
//            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        String MailTo=mailto;
        String MailSubject = properties.getProperty("MailSubject", "HelloWorld");
        System.out.println(MailSubject);
        String MailBCopyTo="";
        String MailCopyTo="";
        String MailBody="<p><img alt=\"expertsonchina\" src=\"http://www.expertsonchina.com/images/top.gif\" border=\"0\" /></p>"
                +"<p>亲爱的 "+username+",您好：<br />" +
                "<br />" +
                "   您于"+ currentDate + "成功注册起线网账号。</p>" +"<p>您的激活码是：" + createActiveUserCode() + "</p><br>";
//        String SMTPHost = Servletconf.getInitParameter("smtphost");
//        String Port=Servletconf.getInitParameter("port");
//        String MailUsername = Servletconf.getInitParameter("mailusername");
//        String MailPassword = Servletconf.getInitParameter("mailpassword");
//        String MailFrom = Servletconf.getInitParameter("mailfrom");
        if(smtphost==null||smtphost==""||mailusername==null||mailusername==""||mailpassword==null||mailpassword==""||mailfrom==null||mailfrom=="")
        {
            System.out.println("Servlet parameter Wrongs");
        }
        MailUtils send=new MailUtils(smtphost,port,mailusername,mailpassword);
        if(send.sendingMimeMail(mailfrom, MailTo, MailCopyTo, MailBCopyTo, MailSubject, MailBody)){
            return true;
        }
        else
        {
            return false;
        }
    }
    private void toResponse(HttpServletResponse response,String toString) throws IOException
    {
        response.setCharacterEncoding("gb2312");
        PrintWriter out=response.getWriter();
        out.println(toString);
    }

}
