/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.ManqobaLubisi.service;

import java.io.File;
import java.net.URL;

/**
 *
 * @author manqo
 */
public interface FileParser {
    void parseCSV(File file);
    File convertCSVDataToImage(String base64ImageData);
    URL createImageLink(File FileImage);
}
