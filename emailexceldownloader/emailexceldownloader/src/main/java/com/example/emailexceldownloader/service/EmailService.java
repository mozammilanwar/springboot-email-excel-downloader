package com.example.emailexceldownloader.service;

import jakarta.mail.*;
import jakarta.mail.internet.MimeBodyPart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

    private final Store store;

    @Value("${file.save-dir}")
    private String saveDir;

    public EmailService(Store store) {
        this.store = store;
    }

    public String downloadLatestExcel() {
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] messages = inbox.getMessages();

            // Loop from latest to oldest
            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];

                if (message.getContentType().contains("multipart")) {
                    Multipart multipart = (Multipart) message.getContent();

                    for (int j = 0; j < multipart.getCount(); j++) {
                        BodyPart part = multipart.getBodyPart(j);

                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition()) &&
                                part.getFileName().endsWith(".xlsx")) {

                            // Create directory if it doesn't exist
                            File dir = new File(saveDir);
                            if (!dir.exists()) dir.mkdirs();

                            // Save the Excel attachment
                            File file = new File(dir, part.getFileName());
                            ((MimeBodyPart) part).saveFile(file);

                            return "File saved: " + file.getAbsolutePath();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return "No Excel attachment found.";
    }
}
