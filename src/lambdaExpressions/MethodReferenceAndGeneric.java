package lambdaExpressions;

public class MethodReferenceAndGeneric {
	public static void main(String args[]) {
		boolean result;
		int a = 8;
		int b = 6;
		
		SomeTest<Integer> myRef = MyClass::<Integer>myGenMeth;	
		result = myRef.test(a, b);
		if(result) {
			System.out.println(a + " is smaller than " + b + ".");
		} else {
			System.out.println(a + " is bigger than " + b + ".");
		}
	}
}

interface SomeTest<T> {
	boolean test(T n, T m);
}

class MyClass {
	static<T> boolean myGenMeth(T x, T y) {
		boolean result = false;
		
		if((Integer) x < (Integer) y) {
			result = true;
		}
		
		return result;
	}
}