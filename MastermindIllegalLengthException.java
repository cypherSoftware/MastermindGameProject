package controller;

/**
 * 
 * @author Aaron Posey
 *This class throws an exception if the user guess is an invalid length.
 */
public class MastermindIllegalLengthException extends Exception {
	
	public MastermindIllegalLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "ERROR: You have to guess exactly 4 colors";
	}
	

}
