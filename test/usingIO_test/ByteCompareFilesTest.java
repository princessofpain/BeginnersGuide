package usingIO_test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import usingIO.ByteCompareFiles;

class ByteCompareFilesTest {
	
	private ByteCompareFiles comparison = new ByteCompareFiles();

	@Test
	void fileIsAdded() {
		String input1 = "src/usingIO/comparison1.txt";
		InputStream in1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(in1);

		String expectedOutput = input1;
		String[] actualOutput = comparison.addFiles();
		
		assertEquals(expectedOutput, actualOutput[0]);
	}
	
	@Test 
	void arrayHasTwoElements() {
		String input1 = "src/usingIO/comparison1.txt";
		InputStream in1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(in1);

		String[] actualOutput = comparison.addFiles();
		boolean hasTwoElements = false;
		
		if(actualOutput.length == 2)
			hasTwoElements = true;
		
		assertTrue(hasTwoElements);
	}
	
	@Test 
	void readsTheFilesAndReturnsResult() throws IOException {
		String[] files = {"src/usingIO/comparison1.txt", "src/usingIO/comparison2.txt"};
		
		FileInputStream contentFile1 = new FileInputStream(files[0]);
		FileInputStream contentFile2 = new FileInputStream(files[1]);
		
		String expectedResult = "Files are not the same";
		String actualResult = comparison.readFilesAndShowResult(contentFile1, contentFile2);
		
		assertEquals(expectedResult, actualResult);
	}
}
