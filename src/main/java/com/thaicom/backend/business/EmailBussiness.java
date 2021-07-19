package com.thaicom.backend.business;

import com.thaicom.backend.exception.BaseException;
import com.thaicom.backend.exception.EmailException;
import com.thaicom.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class EmailBussiness {

    @Autowired
    private EmailService emailService;

    public void sendActivateUserEmail(String email, String name, String token) throws BaseException {
        // prepare temlplate
        String html;
        try {
            html = readEmailTemplate("email-activate-user.html");
        } catch (IOException e){
            throw EmailException.templateNotFound();
        }

        String finalLink = "http://localhost:8080/activate"+token;
        html = html.replace("${P_NAME}", name);
        html = html.replace("${LINK}", finalLink);
        String subject = "Please activate your email";
        emailService.send(email, subject, html);
    }

    private String readEmailTemplate(String filename) throws IOException {

        File file = ResourceUtils.getFile("classpath:email/"+filename);
        return FileCopyUtils.copyToString(new FileReader(file));
    }
}
