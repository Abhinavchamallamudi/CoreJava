/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carbonfootprint;

/**
 *
 * @author Ashfaq
 */
public class Hotel implements CarbonFootprintInterface{
    private double averageMonthlyKwh;
    private final int months = 12;
    
    public Hotel( double monthlyConsumption ){
        averageMonthlyKwh = monthlyConsumption;
    }//end of constructor
    
    public void setAverageMonthlyKwh( double monthlyConsumption ){
        averageMonthlyKwh = monthlyConsumption;
    }
    public double getAverageMonthlyKwh(){
        return averageMonthlyKwh;
    }
    @Override 
    public String toString(){
        return String.format("%s: %.2f\n", 
        "the monthly consumption is ", getAverageMonthlyKwh() );
    }
    @Override
    public double getCarbonFootprint(){
        return getAverageMonthlyKwh() * months;
    }
}
