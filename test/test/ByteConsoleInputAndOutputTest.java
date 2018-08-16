package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import usingIO.ByteConsoleInputAndOutput;

class ByteConsoleInputAndOutputTest {
	
	private ByteConsoleInputAndOutput inOut = new ByteConsoleInputAndOutput();

	@Test
	void readsAChar() throws IOException {
		String input = "t";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		String expectedOutput = "You typed a " + input + ".";
		String actualOutput = inOut.readOneChar();

		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test 
	void readsASequence() throws IOException {
		String input = "Hello test";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		String expectedOutput = "You typed: " + input + ".";
		String actualOutput = inOut.readASequence();
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void readsASnippetOfTheSequence() throws IOException {
		String input = "abcdefghijklmnopqrst";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		String expectedOutput = "abcde";
		String actualOutput = inOut.readASnippetOfTheSequence();
		
		assertEquals(expectedOutput, actualOutput);
	}
}
