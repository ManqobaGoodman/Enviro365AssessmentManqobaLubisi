package com.eviro.assessment.grad001.ManqobaLubisi;

import com.eviro.assessment.grad001.ManqobaLubisi.entity.AccountProfile;
import com.eviro.assessment.grad001.ManqobaLubisi.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.ManqobaLubisi.service.FileParser;
import com.eviro.assessment.grad001.ManqobaLubisi.serviceImpl.FileParserImple;
import com.sun.jndi.toolkit.url.Uri;
import java.io.File;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManqobaLubisiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ManqobaLubisiApplication.class, args);
    }

    @Autowired
    private FileParserImple fileParserImple;
    
    @Autowired
    private AccountProfileRepository accountProfileRepository;
    
    @Override
    public void run(String... args) throws Exception {
        File file = new File("1664806859027-GraduateDev_AssessmentCsv_v2.csv"); 
        fileParserImple.parseCSV(file);
        
        AccountProfile accountProfile = accountProfileRepository.findByNameAndSurname("Enviro365", "IT Solutions");
        
        System.out.println(accountProfile.toString());
        
        File file2;
        file2 = fileParserImple.convertCSVDataToImage(accountProfile.getImageData());
        
        URL url = fileParserImple.createImageLink(file2);
        System.out.println("url: "+url);
    }

}
