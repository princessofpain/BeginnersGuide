package usingIO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Simple test application for the first steps with I/O
 * Test some methods of the classes InputStream and OutputStream
 */

public class ByteInput {
	InputStream testStream = null;
	private static ByteInput test2 = new ByteInput();
	
	public static void main(String[] args) {
		ByteInput test = new ByteInput();
		
		int fileLength = test.getLengthOfInputStream();		
		System.out.println("The file has " + fileLength + " Bytes.");
		
		int nextAvailableByte = test.readOneByteOfInputStream();
		char byteToLetter = (char) nextAvailableByte;
		System.out.println("The next available byte is " + nextAvailableByte + ". This is the letter " + byteToLetter + ".");
		
		Byte[] allBytes = test.readAllBytesOfInputStream();	
		char[] allBytesToLetters = test.convertBytesToChars(allBytes);
		String message = test.display(allBytes, allBytesToLetters);
		System.out.println(message);
	}
	
	public int getLengthOfInputStream() {
		int length = 0;
		
		try(FileInputStream testStream = new FileInputStream("src/UsingIO/file.txt")) {
			length = testStream.available();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return length;
	}
	
	public int readOneByteOfInputStream() {
		int nextAvailableByte = 0;
		try(FileInputStream testStream = new FileInputStream("src/UsingIO/file.txt")) {
			nextAvailableByte = testStream.read();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return nextAvailableByte;
	}
	
	public Byte[] readAllBytesOfInputStream() {
		List<Byte> bytes = new ArrayList<Byte>();
		
		try(FileInputStream testStream = new FileInputStream("src/UsingIO/file.txt")) {
			byte[] allBytes = test2.readBytes(testStream);
			
			for(byte b: allBytes) {
				bytes.add(b);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
		Byte[] allBytes = bytes.toArray(new Byte[bytes.size()]);
		return allBytes;
	}
	
	private byte[] readBytes(InputStream testStream) {
		int inputLength = test2.getLengthOfInputStream();
		byte[] allBytes = new byte[inputLength];
		
		for(int i = 0; i < inputLength; i++) {
			try {
				testStream.read(allBytes);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		}
		
		return allBytes;
	}
	
	public char[] convertBytesToChars(Byte allBytes[]) {
		int inputLength = test2.getLengthOfInputStream();
		char singleChar = ' ';
		char[] allChars = new char[inputLength];
		
		for(int i = 0; i < inputLength; i++) {
			byte b = allBytes[i];
			singleChar = (char) b;
			allChars[i] = singleChar;
		}
		
		return allChars;
	}
	
	public String display(Byte[] allBytes, char[] allLetters) {
		StringBuilder chars = new StringBuilder();
		for(char letter: allLetters) {
			chars.append(letter);
		}
		
		String message = "\nThis are all Bytes of the input: " + Arrays.toString(allBytes) + ".\n\nAnd this is the whole content of the file build with the single chars:\n" + chars.toString();
		
		return message;
	}
}
