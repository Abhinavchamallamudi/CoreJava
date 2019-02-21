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
public class Bus implements CarbonFootprintInterface{
    private int maxPassengers;
    private double averageYearlyMiles;
    private final int kgCO2PerMile = 9;
    
    public Bus(int p, double am)
    {
        maxPassengers = p;
        averageYearlyMiles = am;
    }
    
    public void setPassengers(int np)
    {
        maxPassengers = np;
    }
    public int getPassengers()
    {
        return maxPassengers;
    }
    public void setAverageYearlyMiles( double miles ){
        averageYearlyMiles = miles;
    }
    
    public double getAverageYearlyMiles(){
        return averageYearlyMiles;
    }
    @Override
    public String toString(){
        return String.format("%s: %.2f",
            "Yearly miles are ", getAverageYearlyMiles() );
    }
    @Override
    public double getCarbonFootprint() {
        return (( getAverageYearlyMiles() * maxPassengers ) * kgCO2PerMile ); //To change body of generated methods, choose Tools | Templates.
    }
}
