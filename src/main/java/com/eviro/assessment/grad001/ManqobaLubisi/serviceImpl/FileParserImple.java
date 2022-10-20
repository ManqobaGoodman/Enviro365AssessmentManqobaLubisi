/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.ManqobaLubisi.serviceImpl;

import com.eviro.assessment.grad001.ManqobaLubisi.entity.AccountProfile;
;
import com.eviro.assessment.grad001.ManqobaLubisi.service.FileParser;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

/**
 *
 * @author manqo
 */


@Service
public class FileParserImple implements FileParser {

    @Autowired
    private AccountProfileServiceImpl accountProfileService;

    @Override
    public void parseCSV(File file) {

        if (file != null) {

            try (Reader inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8")) {

                List<AccountProfile> accountList = new ArrayList<>();

                CsvParserSettings settings = new CsvParserSettings();
                //remove the headers of the file
                settings.setHeaderExtractionEnabled(true);
                settings.setMaxCharsPerColumn(-1);
                CsvParser csvParser = new CsvParser(settings);
                List<Record> recordList = csvParser.parseAllRecords(inputReader);
                for (Record record : recordList) {
                    AccountProfile account = new AccountProfile();
                    String imageFormat = record.getString("imageFormat");
                    String imageData = record.getString("imageData");
                    String imageFormatData = imageFormat + " " + imageData;

                    File image = convertCSVDataToImage(imageFormatData);

                    URL url = createImageLink(image);

                    account.setName(record.getString("name"));
                    account.setSurname(record.getString("surname"));
                    account.setHttpImageLink(url.toString());

                    accountList.add(account);

                }

                accountProfileService.saveAllAccountProfile(accountList);
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        File file = null;

        if (base64ImageData != null) {

            String[] base64ImageDataArray = base64ImageData.split(" ");
            System.out.println("String: " + base64ImageDataArray[0]);

            if (base64ImageDataArray.length >= 2) {
                byte[] decodedBytes = Base64.getDecoder().decode(base64ImageDataArray[1]);
                String fileName = base64ImageDataArray[0].replace('/', '.');
                file = new File("images/" + fileName);
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(decodedBytes);
                } catch (Exception ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
        }

        return file;
    }

    @Override
    public URL createImageLink(File fileImage) {
        URL url = null;
        try {
            
            String protocol = "http";
            String host = "localhost";
            int port = 8080;
            String file = "/C:/Users/manqo/Downloads/ManqobaLubisi/images/"+fileImage.getName();
            //url = new URL(protocol, host, port, file);
            url = fileImage.toURI().toURL();
            
            return url;
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileParserImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return url;
    }

}
