package lambdaExpressions;

public class MethodReferenceToInstanceMethods {
	public static void main(String args[]) {
		boolean result;
		
		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);
		
		// use an instance method with a specific object of a given class
		IntPredicate2 ip = myNum::isFactor;
		result = ip.test(3);
		if(result) System.out.println("3 is a factor of " + myNum.getNum());
		
		ip = myNum2::isFactor;
		result = ip.test(5);
		if(!result) System.out.println("5 is not a factor of " + myNum2.getNum());
		System.out.println();
		
		// Use an instance method with any object of the given class MyIntNum 
		MyIntNumPredicate inp = MyIntNum::isFactor;
		
		result = inp.test(myNum, 4);
		if(result) System.out.println("4 is a factor of " + myNum.getNum());
		
		result = inp.test(myNum2,  6);
		if(!result) System.out.println("6 is not a factor of " + myNum2.getNum());
	}
}

interface MyIntNumPredicate {
	boolean test(MyIntNum mv, int n);
}

interface IntPredicate2 {
	boolean test(int n);
}

class MyIntNum {
	private int v;
	
	MyIntNum(int x) {
		v = x;
	}
	
	int getNum() {
		return v;
	}
	
	boolean isFactor(int n) {
		return (v % n) == 0;
	}
}

