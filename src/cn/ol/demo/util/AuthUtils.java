package cn.ol.demo.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class AuthUtils extends Authenticator{
    private String username = "";
    private String passwd = "";

    public AuthUtils(String mailUsername, String mailPassword) {
    }

    public void Auth(String username, String passwd){
        this.username = username;
        this.passwd = passwd;
    }
    public PasswordAuthentication	 getPasswordAuthentication(){
        return new PasswordAuthentication(username, passwd);
    }
}
