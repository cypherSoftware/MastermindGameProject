package model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Aaron Posey
 * This class is the model.  It holds the solution and allows the caller to access one color at a time via accessors.
 */
public class MastermindModel {
	//private variable(s) to store the answer
	private int randColor;
	private int numOfColors = 6;
	private char[] solutionArray = new char[4];
	public char[] colorArray = new char[] {'R','O','Y','G','B','P'};
	
	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
	/**
	 * Creates a model which holds the solution. 
	 */
    public MastermindModel() { 
    	// creates an array of possible colors to choose from and an array that contains the solution.
    	Random rand = new Random();
    for (int i = 0 ; i < solutionArray.length; i++)
    {
    	 
			randColor = rand.nextInt((5 - 0) + 1);
			solutionArray[i] = colorArray [randColor];
    			
    }
    	
    }
    
	/**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	
    	char oneColor;
    	//get next color from at specified index
    	for (int i = 0; i< answer.length(); i++)
    	{
    		oneColor = answer.charAt(i);
    		solutionArray [i] = oneColor;  //populates array with selected solution for debugging
    	}
    	
    }

/**
 * 
 * @param index An integer that gets the char at that index
 * @return aColor Returns a char that represents one color.
 */
    public char getColorAt(int index) {
          // Returns color at position index as a char
         
    		char aColor = solutionArray [index];
    	
    	return aColor; 
    }
    
   

}
