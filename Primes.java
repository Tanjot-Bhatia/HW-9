import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        
        //creating a list of candidates
        
        ListInterface<Integer> candidates =new AList<Integer>();
        for(int i=2;i<=max;i++)
        {
        	candidates.add(i);
        }
        
        //printing the candidates
        System.out.println(candidates);
        
        
        //creating separate list for composites and primes
        ListInterface<Integer> primes =new AList<Integer>();
        ListInterface<Integer> composites =new AList<Integer>();
        
        //run the loop till we have a candidate
        while(!candidates.isEmpty())
        {
        	int prime=candidates.getEntry(1);
        	candidates.remove(1);//removing a prime and adding to primes list
        	getComposites(candidates, composites, prime);
        	primes.add(prime);
        	
        }
        
        //printing all the lists
        System.out.println("Candidates:"+candidates);
        System.out.println("Primes:"+primes);
        System.out.println("Composites:"+composites);
        
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        
    	for(int i=1;i<=candidates.getLength();i++)
    	{
    		int y=candidates.getEntry(i);
    		
    		//checking if the entry is a multiple of prime
    		if(y%prime==0)
    		{
    			composites.add(y);
    			candidates.remove(i);
    			//if it a multiple,remove it from candidate and add to composites
    		}
    	}
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}
