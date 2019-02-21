/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carbonfootprint;

import java.util.ArrayList;

/**
 *
 * @author Ashfaq
 */
public class CarbonFootprint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList< CarbonFootprintInterface > categories = new ArrayList< CarbonFootprintInterface >();//creates array of objects of type CarbonFootprint
        categories.add(new Bus( 72, 1000.00 ));
        categories.add(new Hotel( 4000.52 ));
        categories.add(new Factory( 182, 20.5 ));
        System.out.println(" Data of each object:\n ");
        for( CarbonFootprintInterface currentObject : categories ){
            System.out.println("%s \n%s: %.2f\n",
                categories.toString(),
                "Carbon footprint is ", categories.getCarbonFootprint());
        }//end for loop   
    }
    
    
}
