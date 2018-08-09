package UsingIO;

import UsingIO.ByteInput;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ByteOutput {
	OutputStream testStream = null;
	
	private void replaceWithOneByte(int newByte) {
		try {
			testStream = new FileOutputStream("src/UsingIO/file.txt");
			testStream.write(newByte);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void replaceWith(byte[] newBytes) {
		try {
			testStream = new FileOutputStream("src/UsingIO/file.txt");
			testStream.write(newBytes);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		ByteOutput test = new ByteOutput();
		
		String[] arguments = {};
		ByteInput.main(arguments);
		
		byte newBytes[] = {10, 84, 104, 105, 115, 32, 119, 97, 115, 32, 119, 114, 105, 116, 116, 101, 110, 32, 98, 121, 32, 74, 97, 118, 97, 46};
		int newByte = 118;
		
		test.replaceWith(newBytes);
		
		System.out.println();
		ByteInput.main(arguments);
		
		test.replaceWithOneByte(newByte);
		
		System.out.println();
		ByteInput.main(arguments);
	}
}
