/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mjerac_protoka;

import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Korisnik
 */
public class WaterGauge {
    double value;
    public double min;
    public double max;
    public String unit;
    public String gaugeName;
    
    public WaterGauge()
    {
        
    }
    
    public WaterGauge(double min, double max, String unit, String gaugeName) {
        this.min = min;
        this.max = max;
        this.unit = unit;
        this.gaugeName = gaugeName;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void generateValue() {
        this.value = ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGaugeName() {
        return gaugeName;
    }

    public void setSensorName(String gaugeName) {
        this.gaugeName = gaugeName;
    }
}
