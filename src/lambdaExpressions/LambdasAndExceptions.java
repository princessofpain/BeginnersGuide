package lambdaExpressions;

import java.io.*;

public class LambdasAndExceptions {
	public static void main(String args[]) {
		MyIOAction myIO = (rdr) -> {
			int ch = rdr.read();
			return true;
		};	
	}
}

interface MyIOAction {
	boolean isWorking(Reader rdr) throws IOException; // because of having an i/o action the possible exception has to be handled by the interface
}
