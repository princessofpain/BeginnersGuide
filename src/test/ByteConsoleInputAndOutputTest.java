package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

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

}
