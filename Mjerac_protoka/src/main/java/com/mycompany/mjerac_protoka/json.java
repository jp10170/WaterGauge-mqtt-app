/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mjerac_protoka;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Korisnik
 */
public class json{
    ObjectMapper mapper;
        
    public json(){
        mapper = new ObjectMapper();
    }
    
     public void serialize(Devices dev, String fileName) {
        try {
            mapper.writeValue(new File(fileName), dev);

        } catch (IOException e) {
        }
    }
}
