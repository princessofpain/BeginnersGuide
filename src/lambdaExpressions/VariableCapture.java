package lambdaExpressions;

// variable Capture = a lambda expression uses a local variable from it´s enclosing scope
public class VariableCapture {
	public static void main(String[] args) {
		int num = 10; // a variable that´s used by a lambda has to be treated like a final variable
		
		MyFunc myLambda = (n) -> {
			int a = num +n;
			//num++; // --> this is illegal because a local variable cannot be changed when used in a lambda, it´s final
			return a;
		};
		
		System.out.println(myLambda.func(8));
		//num = 9; // this is illegal because of the same reason as above
	}
}

interface MyFunc {
	int func(int n);
}
