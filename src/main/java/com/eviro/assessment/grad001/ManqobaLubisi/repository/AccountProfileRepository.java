/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.ManqobaLubisi.repository;

import com.eviro.assessment.grad001.ManqobaLubisi.entity.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author manqo
 */
@Repository
public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long>{
    
    public AccountProfile findByNameAndSurname(String name,String surname);

    
}