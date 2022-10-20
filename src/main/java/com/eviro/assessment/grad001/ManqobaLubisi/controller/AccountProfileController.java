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
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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
    private AccountProfileServiceImpl accountProfileServiceImpl;

    @GetMapping(value = "getImage/{name}/{surname}")
    public URL getHttpImageLink(@PathVariable String name, @PathVariable String surname) throws IOException {
        URL url = null;
        AccountProfile accountProfile = accountProfileServiceImpl.findByNameAndSurname(name, surname);
        if (accountProfile != null) {
            url = new URL(accountProfile.getHttpImageLink());
        }

        return url;
    }
}
