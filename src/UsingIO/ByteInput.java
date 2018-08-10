package UsingIO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* Simple test application for the first steps with I/O
 * Test some methods of the classes InputStream and OutputStream
 */

public class ByteInput {
	InputStream testStream = null;
	private static ByteInput test2 = new ByteInput();
	
	private int getLengthOfInputStream() {
		int length = 0;
		
		try {
			testStream = new FileInputStream("src/UsingIO/file.txt");
			length = testStream.available();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				testStream.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return length;
	}
	
	private int readOneByteOfInputStream() {
		int nextAvailableByte = 0;
		try {
			testStream = new FileInputStream("src/UsingIO/file.txt");
			nextAvailableByte = testStream.read();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				testStream.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return nextAvailableByte;
	}
	
	private byte[] readAllBytesOfInputStream() {
		
		try {
			testStream = new FileInputStream("src/UsingIO/file.txt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				testStream.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		byte allBytes[] = test2.readBytes(testStream);
		return allBytes;
	}
	
	private byte[] readBytes(InputStream testStream) {
		int inputLength = test2.getLengthOfInputStream();
		byte[] allBytes = new byte[inputLength];
		
		for(int i = 0; i < inputLength; i++) {
			try {
				testStream = new FileInputStream("src/UsingIO/file.txt");
				testStream.read(allBytes);
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					testStream.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return allBytes;
	}
	
	private char[] convertBytesToChars(byte allBytes[]) {
		int inputLength = test2.getLengthOfInputStream();
		char singleChar = ' ';
		char[] allChars = new char[inputLength];
		
		for(int i = 0; i < inputLength; i++) {
			singleChar = (char) allBytes[i];
			allChars[i] = singleChar;
		}
		
		return allChars;
	}
	
	private String display(byte[] allBytes, char[] allLetters) {
		StringBuilder chars = new StringBuilder();
		for(char letter: allLetters) {
			chars.append(letter);
		}
		
		String message = "\nThis are all Bytes of the input: " + Arrays.toString(allBytes) + ".\n\nAnd this is the whole content of the file build with the single chars:\n" + chars.toString();
		
		return message;
	}
	
	public static void main(String[] args) {
		ByteInput test = new ByteInput();
		
		int fileLength = test.getLengthOfInputStream();		
		System.out.println("The file has " + fileLength + " Bytes.");
		
		int nextAvailableByte = test.readOneByteOfInputStream();
		char byteToLetter = (char) nextAvailableByte;
		System.out.println("The next available byte is " + nextAvailableByte + ". This is the letter " + byteToLetter + ".");
		
		byte[] allBytes = test.readAllBytesOfInputStream();	
		char[] allBytesToLetters = test.convertBytesToChars(allBytes);
		String message = test.display(allBytes, allBytesToLetters);
		System.out.println(message);
	}
}
