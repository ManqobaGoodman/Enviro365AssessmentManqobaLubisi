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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
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
                    account.setName(record.getString("name"));
                    account.setSurname(record.getString("surname"));
                    account.setImageData(imageFormat+" "+record.getString("imageData"));
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
            System.out.println("String: "+base64ImageDataArray[0]);

            byte[] decodedBytes = Base64.getDecoder().decode(base64ImageDataArray[1]);
            String fileName = base64ImageDataArray[0].replace('/', '.');
            file = new File(fileName);
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(decodedBytes);
            } catch (Exception ex) {
                System.out.println("error: " + ex.getMessage());
            }
        }

        return file;
    }

    @Override
    public URL createImageLink(File fileImage) {
        URL url = null;

        if (fileImage != null) {
            FileSystemResource fileSystemResource = new FileSystemResource(fileImage);
            try {
                url = fileSystemResource.getURL();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return url;
    }

}
