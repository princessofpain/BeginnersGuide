package UsingIO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareFiles {
	
	private static CompareFiles comparison = new CompareFiles();
	
	private Byte[] readAllBytesOfInputStream(String path) {
		List<Byte> bytes = new ArrayList<Byte>();
		int inputLength = comparison.getLengthOfInputStream(path);
		
		try(FileInputStream testStream = new FileInputStream(path)) {
			byte[] allBytes = comparison.readBytes(testStream, inputLength);
			
			for(byte b: allBytes) {
				bytes.add(b);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
		Byte[] allBytes = bytes.toArray(new Byte[bytes.size()]);
		return allBytes;
	}
	
	private byte[] readBytes(InputStream testStream, int inputLength) {
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
	
	private int getLengthOfInputStream(String path) {
		int length = 0;
		
		try(FileInputStream testStream = new FileInputStream(path)) {
			length = testStream.available();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return length;
	}
	
	private String compareTwoFiles(Byte[] fileA, Byte[] fileB) {
		if(Arrays.deepEquals(fileA, fileB)) {
			return "Files are the same";
		} else {
			return "Files are not the same";
		}
	}
	
	public static void main(String[] args) {		
		String file1 = "src/UsingIO/comparison1.txt";
		String file2 = "src/UsingIO/comparison2.txt";
		String file3 = "src/UsingIO/comparison3.txt";
		
		Byte[] contentFile1 = comparison.readAllBytesOfInputStream(file1);
		Byte[] contentFile2 = comparison.readAllBytesOfInputStream(file2);
		Byte[] contentFile3 = comparison.readAllBytesOfInputStream(file3);
		
		String comparison1 = comparison.compareTwoFiles(contentFile1, contentFile2);
		String comparison2 = comparison.compareTwoFiles(contentFile1, contentFile3);
		String comparison3 = comparison.compareTwoFiles(contentFile2, contentFile3);
		
		System.out.println(comparison1 + "\n" + comparison2 + "\n" + comparison3);
	}
}
