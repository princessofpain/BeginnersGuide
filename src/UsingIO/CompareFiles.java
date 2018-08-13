package UsingIO;

import java.io.FileInputStream;
import java.io.IOException;

public class CompareFiles {
	
	private static CompareFiles comparison = new CompareFiles();
	private int i = 0; 
	private int j = 0;
	
	public static void main(String[] args) {			
		String[] files = comparison.addFiles();
		
		try (FileInputStream contentFile1 = new FileInputStream(files[0]);
				FileInputStream contentFile2 = new FileInputStream(files[1])) {
			comparison.readFiles(contentFile1, contentFile2);			
			comparison.showResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String[] addFiles() {
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
	
	private void readFiles(FileInputStream contentFile1, FileInputStream contentFile2) throws IOException {
		System.out.println();
		do {
			i = contentFile1.read();
			j = contentFile2.read();
		} while(i != -1 && j != -1 && i == j);
	}
	
	private void showResult() {
		if(i != j) {
			System.out.println("Files are not the same");
		} else {
			System.out.println("Files are the same");
		}
	}
}

