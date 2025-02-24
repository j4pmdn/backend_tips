package com.hdoan;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.utils.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendMailTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    void sendTextEmail(){
        String to = "tipsjavamember@gmail.com";
        String subject = "Test OTP Simple";
        String content = "This is a test 1234";

        emailSenderUtil.sendTextEmail(to, subject, content);
    }

    @Test
    void sendHTMLEmail() throws IOException {
        String to = "tipsjavamember@gmail.com";
        String subject = "Test OTP HTML";
        String content = "OTP is 123";

        Resource resource = new ClassPathResource("/templates/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());

        emailSenderUtil.setHtmlEmail(to, subject, htmlContent);
    }

}
