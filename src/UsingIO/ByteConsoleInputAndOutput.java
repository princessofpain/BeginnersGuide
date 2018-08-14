package usingIO;

import java.io.IOException;

public class ByteConsoleInputAndOutput {
	
	private static ByteConsoleInputAndOutput input = new ByteConsoleInputAndOutput();
	
	public static void main(String[] args) throws IOException {	
		// Use one method at a time. Undo the comments to change the active method.
		System.out.println(input.readOneChar());
		//System.out.println(input.readASequence());
		//System.out.println(input.readASnippetOfTheSequence());
	}
	
	public String readOneChar() throws IOException {
		System.out.println("Type a character:");
		char singleInput = (char) System.in.read();
		String result =  "You typed a " + singleInput + ".";
		return result;
	}
	
	public String readASequence() throws IOException {
		System.out.println("Type a sequence of 10 characters");
		byte data[] = new byte[10];
		System.in.read(data);
		String result = "You typed: " + input.buildStringOf(data) + ".";
		return result;
	}
	
	public String readASnippetOfTheSequence() throws IOException {
		System.out.println("Type a squence of 20 characters. Just character 5 - 15 will be safed.");
		byte[] dataSnippet = new byte[20];
		System.in.read(dataSnippet, 4, 10);
		String result = input.buildStringOf(dataSnippet);
		return result;
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
}