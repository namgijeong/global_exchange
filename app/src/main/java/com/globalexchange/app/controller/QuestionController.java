package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.EmailVO;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


import java.io.UnsupportedEncodingException;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("/question/*")
@Slf4j
public class QuestionController {

    // 문의사항 작성 페이지 이동
    @GetMapping("/question")
    public void question(){

    }

    // 문의사항 작성 완료
    @GetMapping("/questionWriteOk")
    public RedirectView questionWriteOk(EmailVO emailVO){
       /* Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);*/
        String clientEmail=emailVO.getClientEmail();
        String adminEmail="kjnam2009@naver.com";
        String emailContent=emailVO.getEmailContent();
        String emailTitle=emailVO.getEmailTitle();
        log.info(clientEmail);
        log.info(adminEmail);
        log.info(emailContent);

       /* try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(clientEmail, "MR.USER"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(adminEmail, "ADMIN"));
            msg.setSubject(emailTitle);
            msg.setText(emailContent);
            Transport.send(msg);
        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
            // ...
        }*/

        Properties props = new Properties();
     /*   props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");*/

        /*Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dreaming1817@gmail.com", "rhdeotod2018!");
            }
        });*/

        props.put("mail.smtp.starttls.enable", "true");     // gmail은 true 고정
        props.put("mail.smtp.host", "smtp.naver.com");      // smtp 서버 주소
        props.put("mail.smtp.auth","true");                 // gmail은 true 고정
        props.put("mail.smtp.port", "587");                 // 네이버 포트
        props.put("mail.smtp.port", "587");                 // 네이버 포트
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        /*Authenticator auth = new MyAuthentication();*/
        //session 생성 및  MimeMessage생성
       /* Session session = Session.getDefaultInstance(props, null);*/
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kjnam2009@naver.com", "promisedgo2018!");
            }
        });

        String receiver = adminEmail; // 메일 받을 주소
        String title = emailTitle;
        String content = "클라이언트 이메일:"+clientEmail+emailContent;


        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(receiver, "사용자", "utf-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setContent(content, "text/html; charset=utf-8");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new RedirectView("/main/main");
    }

}
