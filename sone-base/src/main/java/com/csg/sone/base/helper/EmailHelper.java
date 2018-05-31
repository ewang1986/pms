package com.csg.sone.base.helper;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
/**
 * <p> Description:  EmailHelper </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public final class EmailHelper {


    /**
     * <p>发送邮件.
     * </p>
     *
     * @param htmlemail
     */
    public static void send(HtmlEmail htmlemail) {
        try {
            htmlemail.setCharset("UTF-8");
            htmlemail.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }


}
