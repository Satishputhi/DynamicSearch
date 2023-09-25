package com.spring.email;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


import javax.mail.*;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


@Component

public class EmailUtil {


    @Autowired

    private JavaMailSender mailSender;
    
    public boolean sendEmail(File file) {
    	boolean status = false;
    	try {
    		MimeMessage msg= mailSender.createMimeMessage();
    		MimeMessageHelper helper= new MimeMessageHelper(msg,true);
    		
    		helper.setTo("satishpooti03@gmail.com");
    		helper.setSubject("Your Report");
    		helper.setText("<h2>Please download your report</h2>", true);
    		
    		helper.addAttachment(file.getName(), file);
    		
    		mailSender.send(msg);
    		
    		status = true;
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    
    
    
    public boolean sendPdfAsEmailAttachment(byte[] pdfContent) {
        boolean status = false;
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            helper.setTo("satishpooti03@gmail.com"); // Replace with the recipient's email address
            helper.setSubject("Your Citizen Report");
            helper.setText("<h2>Please find your Citizen Report attached.</h2>", true);

            // Attach the PDF with the provided byte array
            helper.addAttachment("Citizen Report.pdf", new ByteArrayResource(pdfContent));

            mailSender.send(msg);

            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}














