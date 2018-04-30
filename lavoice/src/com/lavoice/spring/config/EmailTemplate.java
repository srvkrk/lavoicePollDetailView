package com.lavoice.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailTemplate {

	@Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"max-width:650px;margin:0 auto;border:2px solid #3c4f93;\"><tbody><tr><td style=\"padding:10px;text-align:right;\"><a target=\"_blank\" href=\"http://welfare.890m.com/lavoicenew/\"><img src=\"http://welfare.890m.com/assets/frontend_assets/images/logo-blog.png\" width=\"200\" height=\"36\"></td>\r\n" + 
        		"</tr><tr><td>\r\n" + 
        		"<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"max-width:610px;margin:0 auto;\"><tbody><tr><td style=\"font:16px Arial, Helvetica, sans-serif;color:#000;padding:10px 15px 0;\">Hi ${customer_name}</td>\r\n" + 
        		"</tr><tr><td style=\"text-align:center;padding:0 15px 10px;\">\r\n" + 
        		"<p style=\"color:#000;font:16px/22px Arial, Helvetica, sans-serif;margin:0;padding:5px 0 0px;\">You are just one step away from accessing your LAVOICE account.<br>All you have to do now is Click the button below and verify your email address.</p>\r\n" + 
        		"<p style=\"text-align:center;padding:10px 0;\"><a rel=\"nofollow\" target=\"_blank\" href=\"http://localhost:8080/verifyEmail?str=${verify_mailLink}\" style=\"text-decoration:none;color:#fff;background-color:#3a4d96;padding:11px 25px;font:18px Arial, Helvetica, sans-serif;text-transform:uppercase;border-radius:10px;\">Verify my Email</a></p>\r\n" + 
        		"<p style=\"color:#000;font:16px/22px Georgia;margin:0;padding:5px 0 0px;\">Verify your Email and get access to all tools</p>\r\n" + 
        		"</td>\r\n" + 
        		"</tr></tbody></table></td>\r\n" + 
        		"</tr></tbody></table>");
        return message;
    }
}
