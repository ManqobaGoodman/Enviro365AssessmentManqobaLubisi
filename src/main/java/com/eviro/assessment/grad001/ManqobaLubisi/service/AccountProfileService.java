/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.ManqobaLubisi.service;

import com.eviro.assessment.grad001.ManqobaLubisi.entity.AccountProfile;
import java.util.List;

/**
 *
 * @author manqo
 */
public interface AccountProfileService {
    public void saveAllAccountProfile(List<AccountProfile> list);
    public  AccountProfile findByNameAndSurname(String name, String surname);   
}
