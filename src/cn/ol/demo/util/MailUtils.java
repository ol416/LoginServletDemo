package cn.ol.demo.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    private Session session;
    private String SMTPHost;
    private String MailUsername;
    private String MailPassword;



    public MailUtils(String SMTPHost, String Port, String MailUsername, String MailPassword){
        AuthUtils auth = new AuthUtils(MailUsername, MailPassword);
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTPHost);
        prop.put("mail.smtp.port", Port);
        prop.put("mail.smtp.auth", "true");// 同时通过验证
        // 获得邮件会话对象
        session = Session.getInstance(prop, auth);
        this.SMTPHost = SMTPHost;
        this.MailUsername = MailUsername;
        this.MailPassword = MailPassword;
    }
    public boolean sendingMimeMail(String MailFrom, String MailTo,
                                   String MailCopyTo, String MailBCopyTo, String MailSubject,
                                   String MailBody) {
        System.out.println(MailFrom);
        try {
            // 创建MIME邮件对象
            MimeMessage mimeMsg = new MimeMessage(session);
            // 设置发信人
            mimeMsg.setFrom(new InternetAddress(MailFrom));
            // 设置收信人
            if (MailTo != null) {
                mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress
                        .parse(MailTo));
            }
            // 设置抄送人
            if (MailCopyTo != null) {
                mimeMsg.setRecipients(javax.mail.Message.RecipientType.CC,
                        InternetAddress.parse(MailCopyTo));
            }
            // 设置暗送人
            if (MailBCopyTo != null) {
                mimeMsg.setRecipients(javax.mail.Message.RecipientType.BCC,
                        InternetAddress.parse(MailBCopyTo));
            }
            // 设置邮件主题
            mimeMsg.setSubject(MailSubject, "GBK");
            // 设置邮件内容，将邮件body部分转化为HTML格式
            mimeMsg.setContent(MailBody, "text/html;charset=GBK");
            //mimeMsg.setDataHandler(new javax.activation.DataHandler(
            //  new StringDataSource(MailBody, "text/html")));
            // 发送邮件
            Transport transport = session.getTransport("smtp");
            transport.connect(SMTPHost, MailUsername, MailPassword);
            transport.sendMessage(mimeMsg, mimeMsg.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
