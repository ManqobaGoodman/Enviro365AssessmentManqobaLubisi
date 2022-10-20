/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.ManqobaLubisi.serviceImpl;

import com.eviro.assessment.grad001.ManqobaLubisi.entity.AccountProfile;
import com.eviro.assessment.grad001.ManqobaLubisi.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.ManqobaLubisi.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manqo
 */

@Service
public class AccountProfileServiceImpl implements AccountProfileService{


    @Autowired
    private AccountProfileRepository accountProfileRepository;
    
    @Override
    public void saveAllAccountProfile(List<AccountProfile> list) {
        accountProfileRepository.saveAll(list);
    }

    @Override
    public AccountProfile findByNameAndSurname(String name, String surname) {
        AccountProfile accountProfile = null;
        List<AccountProfile> listAccounts = accountProfileRepository.getAccounts(name, surname);

        if(listAccounts != null && listAccounts.size() == 1){
            accountProfile = listAccounts.get(0);
        }
        return accountProfile;
    }

    
}
