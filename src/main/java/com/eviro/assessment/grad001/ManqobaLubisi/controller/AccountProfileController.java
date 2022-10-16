/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.ManqobaLubisi.controller;

import com.eviro.assessment.grad001.ManqobaLubisi.entity.AccountProfile;
import com.eviro.assessment.grad001.ManqobaLubisi.service.FileParser;
import com.eviro.assessment.grad001.ManqobaLubisi.serviceImpl.AccountProfileServiceImpl;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manqo
 */
@Controller
@RestController
public class AccountProfileController {

    @Autowired
    private FileParser fileParser;

    @Autowired
    private AccountProfileServiceImpl accountProfileServiceImpl;

    @GetMapping(value = "getImage/{name}/{surname}")
    public String gethttpImageLink(@PathVariable String name, @PathVariable String surname) throws IOException {
        String link = null;
            AccountProfile accountProfile = accountProfileServiceImpl.findByNameAndSurname(name, surname);

            if (accountProfile != null) {
                File file = fileParser.convertCSVDataToImage(accountProfile.getImageData());
                URL url = fileParser.createImageLink(file);
                
                System.out.println("URL: "+ url);

                FileSystemResource fileSystemResource = new FileSystemResource(url.getFile());
                link = fileSystemResource.getURL().toString();
            }
            
        return link;
    }
}
