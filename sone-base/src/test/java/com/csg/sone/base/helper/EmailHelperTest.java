package com.csg.sone.base.helper;


import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Before;
import org.junit.Test;

/**
 * <p> Description:  ArrayUtilTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class EmailHelperTest {

    String userName;
    String password;
    String hostName;
    String from;
    int prot;
    HtmlEmail htmlemail;


    @Before
    public void setUp() throws Exception {
        userName = "sudansd02";
        password = "s123456s";
        hostName = "smtp.163.com";
        from = "sudansd02@163.com";
        prot = 25;

        htmlemail = new HtmlEmail();

    }

    @Test
    public void send() {
        htmlemail.setHostName(hostName);
        htmlemail.setSmtpPort(prot);
        htmlemail.setAuthentication(userName, password);
        htmlemail.setSubject("163邮件标题4");
        try {
            htmlemail.setMsg("这是邮件内容，无乱码");
            htmlemail.setFrom(from);
            htmlemail.addTo("sudansd01@163.com");
            htmlemail.addBcc("290573413@qq.com");
            htmlemail.addCc("dan.su@hand-china.com");
        } catch (EmailException e) {
            e.printStackTrace();
        }

        EmailHelper.send(htmlemail);



    }

    @Test
    public void sendAttach() {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("微笑图书馆");
        attachment.setName("微笑图书馆.jpg");
        attachment.setPath("E:\\test.jpg");

        htmlemail.setHostName(hostName);
        htmlemail.setSmtpPort(prot);
        htmlemail.setAuthentication(userName, password);
        htmlemail.setSubject("附件邮件工具类测试2");
        try {
            htmlemail.setMsg("这是邮件内容，无乱码");
            htmlemail.setFrom(from);
            htmlemail.addTo("290573413@qq.com");
            htmlemail.attach(attachment);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        EmailHelper.send(htmlemail);

    }
}

