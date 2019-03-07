package controller;
import model.MastermindModel;

/**
 * 
 * @author Aaron Posey
 *This class links the view and the model.  It allows the view to validate or check for a win, get feedback for user. 
 */
public class MastermindController {
	
	//Controller
	/**
	 * This creates a MastermindController to be used in the view.
	 * @param model A model for the controller to access.
	 */
	public MastermindController(MastermindModel model) {
	
	}
 
	//Checks for win
	/**
	 * This checks for a win.  It makes sure the user guess matches the solution.
	 * @param guess This is the users guess passed in.
	 * @param model This is the model to check against.
	 * @return Returns a boolean variable that dictates whether a win happened or not.
	 */
    public boolean isCorrect(String guess, MastermindModel model) {
    
    	char tempChar;
    	
   
    		for(int i = 0; i< 4; i++)
    		{
    			tempChar = guess.charAt(i);   //grabs char at current index for comparison
    				if(tempChar != model.getColorAt(i)) //compares to answer
    				{
    					return false;
    				}
    			
    		}
    	//all comparisons matched so answer is correct
    	return true; 
    }
    


    //gets number of exact matches from user guess
    /**
     * This method gets the number of exact matches from the user's guess.
     * @param guess This is the users guess
     * @param model This is the model to check against.
     * @return int This is returned to the view to be used as feedback.
     */
    public int getRightColorRightPlace(String guess, MastermindModel model) { 
    	
    	char tempChar;
    	int exactMatchCount = 0;
    	
    		for(int i = 0; i < 4; i++)
    			{	
    			tempChar = guess.charAt(i);
    				if (tempChar == model.getColorAt(i))
    				{
    					exactMatchCount ++;
    				}
    			}
    	return exactMatchCount; 
    	
    }

    //gets number of correctly guessed colors but in wrong position.
    /**
     * This method let's the user know how many colors were correct but in the wrong position.
     * @param guess The user's guess
     * @param model The model to check against.
     * @return int This is returned to the view to be used as feedback.
     */
    public int getRightColorWrongPlace(String guess, MastermindModel model) {
    	
    	char [] tempSolution = new char [4];
    	int rightColorCount = 0;
    	int rightColorWrongPlCount = 0;
    	char tempChar;
    	int exactMatchCount = getRightColorRightPlace(guess, model);
    	
    	// first loop moves solution into a temporary array so it can be mutated
    		for (int j = 0; j < 4; j++)
    		{
    			tempSolution[j] = model.getColorAt(j);
    		}
    	
    		
    		for(int j = 0; j < 4; j++)
    		{
    			
    			tempChar = guess.charAt(j);
    	//second loop checks for colors guessed correctly but gets rid of the color after its counted so it doesn't get counted twice
    			for(int i = 0; i < 4; i++ )
    			{
    					if (tempChar == tempSolution [i])
    					{
    						rightColorCount ++;
    						tempSolution [i] = '*';
    					}
    			}
    		}
    	
    	rightColorWrongPlCount = rightColorCount - exactMatchCount;
    	
    	return rightColorWrongPlCount;
    }

    	/**
    	 * This method validates the user input before proceeding with other checks.
    	 * @param input This is the user's guess
    	 * @return input A string that has been trimmed, converted to caps and validated
    	 * @throws MastermindIllegalLengthException This is thrown if the user has to many or to few colors in their guess. 
    	 * @throws MastermindIllegalColorException This is thrown if the user tries to use an invalid color or character.
    	 */
    public String validateInput(String input) throws MastermindIllegalLengthException, MastermindIllegalColorException {
    	
    String temp;
	String availableColors = "ROYGBP";
	
    //checks length make sure there is only 4 colors
	 if (input.length() != 4) 
	 {
		 throw new MastermindIllegalLengthException("");
       //  System.out.println("ERROR: You have to guess 4 colors no more no less.");
         //System.out.println("Try again.");
                         
	 }
	 
	 //checks for characters that don't make sense i.e. numbers, spaces, or special characters
	   for (int i = 0; i < input.length(); i++)
	   {
             if (!Character.isLetter(input.charAt(i))) 
             {
            	 throw new MastermindIllegalColorException("and no spaces \n");
           	 // System.out.printf("ERROR: You can only use letters.  No numbers, spaces or special characters.");
           	  //System.out.printf("Try again.");
	           
             }

	   }
	   
	   // checks that colors guessed are legal colors.
	   input = input.toUpperCase();
	   for(int j = 0; j < input.length(); j++)
	   {
		   temp = Character.toString(input.charAt(j));
		   
		   if (availableColors.contains(temp) != true)
		   {
			   throw new MastermindIllegalColorException("and no spaces \n");
			   //System.out.println("ERROR: You can only use the legal colors.  R = Red O = Orange Y = Yellow G = Green B = Blue P = Purple");
			   // j = input.length(); // kills for loop if illegal color is found.
			  
		   }
	   }
	   
    
    return input;
    
    }
    
    
    /**
     * This method gets the correct solution for the view to display to user.
     * @param model The model to retrieve the answer from
     * @return solution This is the solution in string form to be displayed.
     */
    public String getCorrectAnswer(MastermindModel model)
    {
    	String solution = "";
    	
    	for (int j = 0; j < 4; j++)
		{
			solution = solution + model.getColorAt(j);
			
		}
    	return solution;
    }
    
}
