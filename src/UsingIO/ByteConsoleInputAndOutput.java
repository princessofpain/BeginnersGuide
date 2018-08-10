package UsingIO;

import java.io.IOException;

public class ByteConsoleInputAndOutput {
	
	private static ByteConsoleInputAndOutput input = new ByteConsoleInputAndOutput();
	
	private void readOneChar() throws IOException {
		System.out.println("Type a character:");
		char singleInput = (char) System.in.read();
		System.out.println("You typed a " + singleInput + ".");
	}
	
	private void readASequence() throws IOException {
		System.out.println("Type a sequence of 10 characters");
		byte data[] = new byte[10];
		System.in.read(data);
		System.out.println("You typed: " + input.buildStringOf(data) + ".");
	}
	
	private void readASnippetOfTheSequence() throws IOException {
		System.out.println("Type a squence of 20 characters. Just character 5 - 15 will be safed.");
		byte[] dataSnippet = new byte[20];
		System.in.read(dataSnippet, 4, 10);
		System.out.println(input.buildStringOf(dataSnippet));
	}
	
	private String buildStringOf(byte[] data) {
		StringBuilder build = new StringBuilder();
		
		for(int i = 0; i < data.length; i++) {
			char letter = (char) data[i];
			build.append(letter);
		}
		
		String convertedString = build.toString();
		return convertedString;
	}
	
	public static void main(String[] args) throws IOException {	
		// Use one method at a time. Undo the comments to change the active method.
		input.readOneChar();
		//input.readASequence();
		//input.readASnippetOfTheSequence();
	}

}