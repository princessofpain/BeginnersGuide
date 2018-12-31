package lambdaExpressions;

// a lambda expression can transfer a code segment into an object (functional interface = 
// one abstract method, this method can be filled with initializing an instance of this interface with a lambda (see below))
// --> this is called a lambda expression used in a target type context, the type of the target type context and of the lambda have to be compatible

public class ThisIsALambda {
	public static void main(String args[]) {
		// the interface is initialized with the lambda
		MyValue myVal = () -> 98.6; // a lambda with a single expression is called "expression lambdas" and the bodies are called "expression bodies" 
		System.out.println("A constant value: " + myVal.getValue());
		
		// the type of n doesn´t have to be specified, its inferred of the methods
		MyParamValue myPVal = (n) -> 1 / n;
		System.out.println("Reciprocal of 4 is " + myPVal.getValue(4));
		
		// use a functional interface with different implementations through Lambdas
		System.out.println();
		NumericTest test = (a,b) -> (a % b) == 0;
		System.out.println(test.test(4, 2));
		test = (a,b) -> a < b;
		System.out.println(test.test(11, 5));
		test = (a,b) -> Math.abs(a) == Math.abs(b);
		System.out.println(test.test(5, -5));
		
		// contains is fine to check if a string is contained, to find the starting index of the substring use indexOf()
		StringTest strTest = (a,b) -> a.contains(b);
		System.out.println("Contains other String: " + strTest.test("Hallo ich bin...", "ich"));
		
		// replace the tests by using a generic interface, String and int can be tested with the same interface though (generics can not be used in lambdas!)
		System.out.println();
		GenericTest<Integer> testNew = (a,b) -> (a % b) == 0;
		System.out.println(testNew.test(4, 2));
		testNew = (a,b) -> a < b;;
		System.out.println(testNew.test(11, 5));
		testNew = (a,b) -> Math.abs(a) == Math.abs(b);
		System.out.println(testNew.test(5, -5));
		GenericTest<String> testNewStr = (a,b) -> a.contains(b);
		System.out.println("Contains other String: " + testNewStr.test("Hallo ich bin...", "ich"));
		
		// use block lambdas
		System.out.println();
		NumericFunc nf = (a) -> { // the block lambda / block expression has to be enclosed by curly braces
			int result = 100;
			
			for(int i = 0; i < 3; i++) {				
				result = (result - Math.abs(a)) / 2;
				if(result <= 0) return 0;
			}
			
			return result;
		};
		System.out.println(nf.func(30));
	}
}

// this is a functional interface that holds one abstract method
interface MyValue {
	abstract double getValue(); // the abstract identifier is optional
}

// functional interface which abstract method takes an argument
interface MyParamValue {
	double getValue(double v);
}

// this two interfaces could be replaced with a generic interface 
interface NumericTest {
	boolean test(int a, int b);
}

interface StringTest {
	boolean test(String a, String b);
}

interface GenericTest<T> {
	boolean test(T n, T m);
}

interface NumericFunc {
	int func(int a);
}