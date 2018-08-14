package usingIO;

import java.io.FileInputStream;
import java.io.IOException;

public class CompareFiles {
	
	private static CompareFiles comparison = new CompareFiles();
	
	public static void main(String[] args) {			
		String[] files = comparison.addFiles();
		
		try (FileInputStream contentFile1 = new FileInputStream(files[0]);
				FileInputStream contentFile2 = new FileInputStream(files[1])) {
			comparison.readFilesAndShowResult(contentFile1, contentFile2);			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] addFiles() {
		String[] files = new String[2];
		
		try {
			byte[] data = new byte[100];
			System.out.println("Enter the filepath of the first file.");
			System.in.read(data);
			String file1 = comparison.cleanArray(data);
			files[0] = file1;
			
			System.out.println("Enter the filepath of the second file.");
			System.in.read(data);
			String file2 = comparison.cleanArray(data);
			files[1] = file2;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return files;
	}
	
	private String cleanArray(byte[] input) {
		StringBuilder filepath = new StringBuilder();
		for(byte b: input) {
			char c = (char) b;
			if(c > 31) {
				filepath.append(c);
			}
		}
		
		return filepath.toString();
	}
	
	public String readFilesAndShowResult(FileInputStream contentFile1, FileInputStream contentFile2) throws IOException {
		System.out.println();
		int i = 0; 
		int j = 0;
		
		do {
			i = contentFile1.read();
			j = contentFile2.read();
		} while(i != -1 && j != -1 && i == j);
		
		if(i != j) {
			return "Files are not the same";
		} else {
			return "Files are the same";
		}
	}
}

