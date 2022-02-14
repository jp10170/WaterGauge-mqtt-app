/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mjerac_protoka;
import java.util.ArrayList;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.util.List;


/**
 *
 * @author Korisnik
 */
public class Devices {
    
    public List<WaterGauge> watergauges;
    
    public Devices()
    {
        
    }
    
    public Devices(List<WaterGauge> watergauges){
        watergauges = new ArrayList<>();
        this.watergauges = watergauges;
    }
    
    public List<WaterGauge> getWaterGauges() {
        return watergauges;
    }
    
    public void setWaterGauges(List<WaterGauge> watergauges) {
        this.watergauges = watergauges;
    }
    
    public void addWatergauge(double min, double max, String unit, String gaugeName) {
        WaterGauge watergauge = new WaterGauge(min, max, unit, gaugeName);
        watergauges.add(watergauge);
    }
    
    public void publish(Devices d)
    {
        try {
            MqttClient client = new MqttClient("tcp://localhost:1883", "watergauge");
            client.connect();
            for(WaterGauge watergauge : this.watergauges)
            {
                watergauge.generateValue();
                String unit = watergauge.getUnit();
                String name = watergauge.getGaugeName();
                String content =name + " = " + Double.toString(watergauge.value) + " " + unit;
                System.out.println(content);
                MqttMessage message = new MqttMessage(content.getBytes());
                client.publish("gauge", message);
            }
            client.disconnect();
            }catch(MqttException exception) {
                System.out.println("reason " + exception.getReasonCode());
                System.out.println("msg " + exception.getMessage());
                System.out.println("loc " + exception.getLocalizedMessage());
                System.out.println("cause " + exception.getCause());
                System.out.println("excep "+ exception);
                exception.printStackTrace();
            }
            
    }
}
        
  
