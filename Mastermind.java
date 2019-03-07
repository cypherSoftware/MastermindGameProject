import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.MastermindController;
import controller.MastermindIllegalColorException;
import controller.MastermindIllegalLengthException;
import model.MastermindModel;

/**
 * 
 * @author Aaron Posey
 * This class is the driver and view of the Mastermind Program 
 */
public class Mastermind {
	
	
	/**
	 * This is the main class. It creates two while loops.  The first is a want to play loop and the second is a is playing loop that gets input and checks for win.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		boolean didWin = false;
		boolean stillPlaying = true;
		boolean goodInput;
		int properlyPlaced = 0;
		int colorsGuessed = 0;
		int numTurns = 1;
		String userInput = "";
		String userAnswer = "";
		String placedMessage = "Colors in the correct Place:";
		String gotRightMessage = "Colors correct but in wrong position:";
		 
		
		// This class represents the view, it should be how user play the game
		System.out.println("Welcome to Mastermind! \n Directions:  I selected a random combination of 4 colors \n Your job would be to guess what they are. \n");
		System.out.println("You have six colors to choose from.  R = Red, O = Orange, Y = Yellow, G = Green, B = Blue, P = Purple \n \n");
		System.out.println("Would you like to play? \n y/n?");
		 //Enter data using BufferReader 
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	
	   // Reading data using readLine 
		try {
			userAnswer = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
			if(userAnswer.equals("n") || userAnswer.equalsIgnoreCase("N")) //if user doesn't wish to play anymore this kills the game
			{
				stillPlaying = false;
			}
			
		// while the user wants to play:
		while(stillPlaying)
		{
			// Construct the model (whose constructor builds the secret answer)
			MastermindModel  game = new MastermindModel();
			
			// Construct the controller, passing in the model
			MastermindController gameController = new MastermindController(game);
		
		//  Read up to ten user inputs
		while(didWin == false && numTurns < 11)
		{
			goodInput = false;		// sets goodInput to false to force do while loop until input has been properly validated.
			do
			{
			//get user guess
					//Scanner sc = new Scanner(System.in); *** why is the scanner not working the second time through the loop?***
			System.out.println("Enter guess number" + numTurns);
				try {
					userInput =  reader.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//sc.nextLine();
			
			// Validate input before proceeding.
			try {
							userInput = gameController.validateInput(userInput);
							goodInput = true;
			} catch (MastermindIllegalLengthException e) {
					// TODO Auto-generated catch block
					System.out.println("Try again Please.");
					e.printStackTrace();
			} catch (MastermindIllegalColorException e) {
				// TODO Auto-generated catch block
				System.out.println("Try again Please.");
				e.printStackTrace();
			}finally {
				
			//sc.close();
			}
			
			
			} while(goodInput == false);
		
		didWin = gameController.isCorrect(userInput, game);  //check for win
		
			if (didWin)
			{
				System.out.println("CONGRATULATION!!!  YOU GOT IT!  YOU'RE ONE FART SMUCKER!");
				didWin = true;
			}
			else //gets feedback on user guess
			{
				properlyPlaced = gameController.getRightColorRightPlace(userInput, game);
				colorsGuessed = gameController.getRightColorWrongPlace(userInput, game);
				System.out.println(placedMessage + " " + properlyPlaced);
				System.out.println(gotRightMessage + " " + colorsGuessed);
				numTurns ++;
			}
		}
			String correctSolution = gameController.getCorrectAnswer(game);
			System.out.println(" \n \nThe Correct answer was:" + correctSolution);
			System.out.println("Game over. \n Would you like to play again?");
			
			if(userAnswer.equals("n") || userAnswer.equalsIgnoreCase("N")) //if user doesn't wish to play anymore this kills the game
			{
				stillPlaying = false;
			}
			numTurns = 0;  //reset number of turns in case user wants to play again 
		}
	}
}
