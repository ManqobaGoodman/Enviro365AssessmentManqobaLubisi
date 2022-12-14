/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.ManqobaLubisi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author manqo
 */
@Entity
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 225)
    private String name;
    @Column(length = 255)
    private String surname;
    @Column(length = 500)
    private String httpImageLink;

    public AccountProfile() {
    }

    public AccountProfile(String name, String surname, String httpImageLink) {
        this.name = name;
        this.surname = surname;
        this.httpImageLink = httpImageLink;
    }
    
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHttpImageLink() {
        return httpImageLink;
    }

    public void setHttpImageLink(String httpImageLink) {
        this.httpImageLink = httpImageLink;
    }

    @Override
    public String toString() {
        return "AccountProfile{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", httpImageLink=" + httpImageLink + '}';
    }
    
    

    
}
