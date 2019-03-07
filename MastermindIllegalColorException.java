package controller;

/**
 * 
 * @author Aaron Posey
 *This class throws an exception if the user's guess contains an invalid color or character.
 */
public class MastermindIllegalColorException extends Exception {
	
	public MastermindIllegalColorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "ERROR: You can only use the legal colors.  R = Red O = Orange Y = Yellow G = Green B = Blue P = Purple";
	}
	

}
