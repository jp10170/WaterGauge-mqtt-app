/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mjerac_protoka;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;


/**
 *
 * @author Korisnik
 */
public class main {
    public static void main(String[] args) throws IOException{
        
        /*Devices d = new Devices();
        d.addWatergauge(-3266.8, 3266.8, "Celzius", "Water temperature");
        d.addWatergauge(0, 66.356, "Bar", "Water pressure");
        d.addWatergauge(0, 65336, "liter/s", "Last minute");
        d.addWatergauge(0, 65336, "liter/s", "Last 10 minutes");
        d.addWatergauge(0, 65336, "liter/s", "Last day");
        d.addWatergauge(0, 6533.6, "m3", "1 week");
        d.addWatergauge(0, 6533.6, "m3", "1 month");
        d.addWatergauge(0, 6533.6, "m3", "1 year");*/
        
        //json test = new json();
        //test.serialize(d, "novi.json");
        ObjectMapper mapper = new ObjectMapper();
        Devices device = mapper.readValue(Paths.get("novi.json").toFile(), Devices.class);
        device.publish(device);
    }   
}
