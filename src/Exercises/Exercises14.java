package Exercises;

public class Exercises14 {
	public static void main(String args[]) {
		// exercise 5 + 6
		BlockLambda bl = (n) -> {
			if(n >= 10 && n <= 20) {
				return true;
			}
			return false;
		};
		
		int number = 39;
		
		if(bl.test(number)) {
			System.out.println(number + " is a number between 10 and 20.");
		} else {
			System.out.println(number + " is out of the range 10 - 20.");
		}
		
		// exercise 7
		NumericFunc nf = (n) -> {
			int result = 0;
			
			for(int i = n; i > 0; i--) {
				result = result + i;
			}
			
			return result;
		};
		
		System.out.println();
		int number2 = 55;
		System.out.println("The factorial of " + number2 + " is " + nf.func(number2) + ".");
		
		number2 = 32;
		System.out.println("The factorial of " + number2 + " is " + nf.func(number2) + ".");
		
		// exercise 8
		MyFunc<Integer> mf = (n) -> {
			int result = 0;
			
			for(int i = n; i > 0; i--) {
				result = result + i;
			}
			
			return result;
		};
		
		System.out.println();
		System.out.println("Use the generic interface:");
		number2 = 55;
		System.out.println("The factorial of " + number2 + " is " + mf.func(number2) + ".");
		
		number2 = 32;
		System.out.println("The factorial of " + number2 + " is " + mf.func(number2) + ".");
		
		// exercise 9
		MyString ms = (n) -> {
			StringBuilder result = new StringBuilder();
			
			for(int i = 0; i < n.length(); i++) {
				char letter = n.charAt(i);
				if(letter != ' ') {
					result.append(letter);
				}
			}
			return result.toString();
		};
		
		String str = "This is a String with a lot of spaces to remove.";
		System.out.println();
		System.out.println("This is the original String: " + str);
		System.out.println("This is the String without spaces: " + ms.changeStr(str));
		
		// exercise 14
		number2 = 18;
		boolean result = numTest(MyClass2::isEven, number2); 
		System.out.println();
		
		if(result) {
			System.out.println("The number " + number2 + " is even.");	
		} else {
			System.out.println("The number " + number2 + " is odd.");
		}
		
		// exercise 17, reference to a constructor
		MyString2 mStr = MyClass2::new;
		MyClass2 mC = mStr.func("I was put by a constructor reference.");
		System.out.println();
		System.out.println(mC.getString());
	}
	
	static boolean numTest(CheckNumber cn, int a) {
		return cn.check(a);
	}
}

interface BlockLambda {
	abstract boolean test(int n);
}

interface NumericFunc {
	abstract int func(int a);
}

interface MyFunc<T> {
	abstract T func(T n);
}

interface MyString {
	abstract String changeStr(String a);
}

interface MyString2 {
	MyClass2 func(String a);
}

class MyClass2 {
	String str;
	
	MyClass2(String str) {
		this.str = str;
	}
	
	static boolean isEven(int a) {
		return a % 2 == 0;
	};
	
	String getString() {
		return str;
	}
}

interface CheckNumber {
	boolean check(int a);
}