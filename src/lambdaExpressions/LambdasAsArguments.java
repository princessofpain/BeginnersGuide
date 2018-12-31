package lambdaExpressions;

public class LambdasAsArguments {

	public static void main(String[] args) {
		String input = "Lambda Expressions Expand Java.";
		String output;
		System.out.println("Here is the input String: " + input);
		
		// use lambdas to change to output
		output = changeString((str) -> {
			StringBuilder result = new StringBuilder(str);
			result.reverse();
			return result.toString();
		}, input);
		System.out.println("This is the reversed String: " + output);
		
		output = changeString((str) -> {
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < str.length(); i++) {
				char letter = str.charAt(i);
				
				if(Character.isLowerCase(letter)) {
					letter = Character.toUpperCase(letter);
				} else if(Character.isUpperCase(letter)){
					letter = Character.toLowerCase(letter);
				}
				result.append(letter);
			}
			return result.toString();
		}, input);
		System.out.println("This is the String with reversed Cases: " + output);
		
		output = changeString((str) -> str.replace(' ', '-'), input);
		System.out.println("This is the String with all spaces replaced with hyphens: " + output);
	}
	
	static String changeString(StringFunc sf, String s) {
		return sf.func(s);
	}
}

interface StringFunc {
	String func(String str);
}