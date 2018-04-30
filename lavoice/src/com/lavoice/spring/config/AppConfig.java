package com.lavoice.spring.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableMongoRepositories(basePackages = "com.lavoice")
@ComponentScan(basePackages = "com.lavoice")
@Import({MongoConfig.class, EmailTemplate.class, SpringHttpSessionConfig.class})
public class AppConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        
        //Using gmail
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("alokeshghosh94@gmail.com");
        mailSender.setPassword("Alokesh1994");
         
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
		
		//Using workspace email
		/*mailSender.setUsername("admin@webscte.co.in");
        mailSender.setPassword("Scte@1998");
        
        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.transport.protocol", "smtp");
        javaMailProperties.setProperty("mail.host", "smtpout.asia.secureserver.net");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.port", "465");
        javaMailProperties.put("mail.smtp.starttls.enable","true" );
        javaMailProperties.put("mail.smtp.ssl.enable", "true");
        javaMailProperties.put("mail.debug", "true");*/
        
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
	}
}