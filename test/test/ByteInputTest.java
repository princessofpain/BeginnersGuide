package test;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import usingIO.ByteInput;

class ByteInputTest {
	
	private static ByteInput input = new ByteInput();

	@Test
	void lengthIsReturned() {
		int expectedResult = 51;
		int actualResult = input.getLengthOfInputStream();
		
		assertEquals(expectedResult, actualResult);
	}

	@Test 
	void readsOneByte() {
		int expectedResult = 73;
		int actualResult = input.readOneByteOfInputStream();
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test 
	void readsAllBytes() {
		Byte[] actualResult = input.readAllBytesOfInputStream();
		Byte[] expectedResult = {73, 32, 97, 109, 32, 97, 32, 116, 101, 115, 116, 32, 102, 105, 108, 101, 46, 32, 13, 10, 85, 115, 101, 32, 109, 101, 32, 116, 111, 32, 116, 101, 115, 116, 32, 116, 104, 101, 32, 73, 47, 79, 32, 111, 102, 32, 74, 97, 118, 97, 46};

		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void convertsBytesToChars() {	
		
		Byte[] byteInput = input.readAllBytesOfInputStream();
		
		String expectedResult = "I am a test file. Use me to test the I/O of Java.";

		char[] allChars = input.convertBytesToChars(byteInput);
		String actualResult = ByteInputTest.convertCharsToString(allChars); 
		
		assertEquals(expectedResult, actualResult);
	}
	
	private static String convertCharsToString(char[] allChars) {
		StringBuilder str = new StringBuilder();
		
		for(char c: allChars) {
			if(c > 31) {
				str.append(c);
			}
		}
		
		return str.toString();
	}
}	

