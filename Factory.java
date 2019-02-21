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
public class Factory implements CarbonFootprintInterface{

    private double kgCO2PerMachine;
    private int machinery;
    
    public Factory(int m, double co2)
    {
        machinery = m;
        kgCO2PerMachine = co2;
    }
    public void setAvgkgCO2PerMachine( double co2 ){
        kgCO2PerMachine = co2;
    }
    public double getAvgkgCO2PerMachine(){
        return kgCO2PerMachine;
    }
    public void setMachinery( int m ){
        machinery = m;
    }
    public double getMachinery(){
        return machinery;
    }
    @Override
    public double getCarbonFootprint() {
        return (getAvgkgCO2PerMachine() * machinery );
    }
    @Override 
    public String toString(){
        return String.format("%s: %.2f\n", 
        "the Co Produces is ", getAvgkgCO2PerMachine ());
    }
    
}
