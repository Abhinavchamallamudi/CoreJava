/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rethrowexp;

/**
 *
 * @author Ashfaq
 */
public class RethrowExp {

    /**
     * @param args the command line arguments
     */
    public static void someMethod()
    {
        try
        { 
            someMethod2();
        } 
        catch(Exception e) 
        { 
            throw e; // rethrowing the exception 
        } 
        
    }
    public static void someMethod2()
    {
        try
        { 
            throw new NullPointerException("Just an Excption"); 
        } 
        catch(NullPointerException e) 
        { 
            throw e; // rethrowing the exception 
        } 
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        try
        {
            someMethod();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
