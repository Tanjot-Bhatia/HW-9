import java.util.*;

/**
 * CountingGame is a program that will simulate a children's counting game used to select
 * someone.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
    
public class CountingGame
{

    public static void main(String args[])
    {
        ListInterface<Integer> players = null;
        ListInterface<String> rhyme = null;
        
        int max;
        int position = 1;       // always start with the first player
        
        System.out.println("Please enter the number of players.");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        System.out.println("Constructing list of players");
        
        // creating the list of players
        players=new AList<Integer>(max);
        for(int i=1;i<=max;i++)
        {
        	players.add(i);
        }
        
        System.out.println("The players list is " + players);
        
        rhyme = getRhyme();

        //run the loop until a single player is left
        while(players.getLength()>1)
        {
        	position=doRhyme(players,rhyme,position);
        }
        
        
        
        //printing the winner
        System.out.println("The winner is " + players.getEntry(1));
    }
    
    
    /**
     * Do the rhyme with the players in the list and remove the selected
     * player.
     *
     * @param  players   A list holding the players.
     * @param  rhyme   A list holding the words of the rhyme.
     * @param  startAt A position to start the rhyme at.
     * 
     * @return The position of the player eliminated.
     */
   public static int doRhyme(ListInterface<Integer> players, ListInterface<String> rhyme, int startAt)
    {
        
	   	int i=0,j=startAt,size=rhyme.getLength();
	   	
	   	
	   	//run the loop till the rhyme is over
	   	for(i=1;i<=size;i++)
	   	{
	   			if(j<=players.getLength())
	   			{
	   				System.out.println("Player "+players.getEntry(j)+":"+ rhyme.getEntry(i));
	   				j++;
	   			}
	   			if(j>players.getLength())
	   			{
	   				j=1;
	   			}
	   	}
	   	j--;
	   	if(j<1)
	   		j=players.getLength();
	   	
	   	//removing the player
	   System.out.println("Removing player "+players.getEntry(j));
	   players.remove(j);
	   
	   //setting the position for next round
	   if(j==(players.getLength()+1))
	   {
		   return 1;
	   }
        return j;

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
    
    /**
     * getRhyme - Get the rhyme.
     *
     * @return    A list of words that is the rhyme.
     */
    private static ListInterface<String> getRhyme()
    {
        Scanner input;
        String inString = "";
        ListInterface<String> rhyme = new AList<String>();
        
        try
        {
            input = new Scanner( System.in );
            
            System.out.println("Please enter a rhyme");
            inString = input.nextLine().trim();
            
            Scanner rhymeWords = new Scanner(inString);
            while(rhymeWords.hasNext())
            {
                rhyme.add(rhymeWords.next());
            }
            rhymeWords.close();
            
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use a rhyme of size one");
        }

        // Make sure there is at least one word in the rhyme
        if(rhyme.getLength() < 1)
            rhyme.add("Default");
        
            
        return (ListInterface<String>)rhyme;
                                    
    }
    
}
