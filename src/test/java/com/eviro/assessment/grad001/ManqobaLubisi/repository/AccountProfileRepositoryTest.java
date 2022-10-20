package com.eviro.assessment.grad001.ManqobaLubisi.repository;

import com.eviro.assessment.grad001.ManqobaLubisi.entity.AccountProfile;
import com.eviro.assessment.grad001.ManqobaLubisi.serviceImpl.FileParserImple;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountProfileRepositoryTest {
    @Autowired
    private FileParserImple fileParserImple;

    @Autowired
    private AccountProfileRepository accountProfileRepository;

    @BeforeEach
    void setUp() {
        File file = new File("CSV File/1664806859027-GraduateDev_AssessmentCsv_v2.csv");
        fileParserImple.parseCSV(file);
    }

    @Test
    void getAccount() {
        //given
        String name = "Enviro365";
        String surname = "IT Solutions";

        List<AccountProfile> accountProfileList = accountProfileRepository.getAccount(name,surname);
        assertThat(accountProfileList).isNotNull();
        assertThat(accountProfileList).hasSizeGreaterThanOrEqualTo(1);

    }
}