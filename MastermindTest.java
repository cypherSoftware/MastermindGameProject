package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MastermindController;
import model.MastermindModel;

/**
 * This class collects all of the test methods for our controller.
 * 
 * In eclipse, running it should run it under JUnit. Running the Mastermind class (since
 * it is our main class) will actually run the program. If you're not using eclipse,
 * you'll need to run this under JUnit 5. 
 * 
 * @author Aaron Posey
 *
 */
class MastermindTest {

	/**
	 * Test method for {@link MastermindController#isCorrect(java.lang.String)}.
	 */
	@Test
	void testIsCorrect() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return true
		assertTrue(controllerUnderTest.isCorrect("rrrr", answer));
		//For a properly working controller, this should be false
		assertFalse(controllerUnderTest.isCorrect("oooo", answer));
		
		//Make as many more assertions as you feel you need to test the MastermindController.isCorrect method
	}

	/**
	 * Test method for {@link MastermindController#getRightColorRightPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorRightPlace() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrrr", answer), 4);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo", answer), 0);
		
		//You'll need lots more of these to convince yourself your implementation is right
	}

	/**
	 * Test method for {@link MastermindController#getRightColorWrongPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorWrongPlace() {
		//TODO this one you're all on your own 
		MastermindModel answer = new MastermindModel("RGBO");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		assertEquals(controllerUnderTest.getRightColorWrongPlace("GRYY", answer), 2);
		
	
	}

}
