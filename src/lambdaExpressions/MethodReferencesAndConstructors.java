package lambdaExpressions;

import java.lang.reflect.Array;

public class MethodReferencesAndConstructors {
	public static void main(String args[]) {
		// assign the interface to an instance (the constructor) of MyClass2
		MyFunc2 myClassCons = MyClass2::new;
		// instanciate MyClass2 by using a constructor reference
		MyClass2 mc = myClassCons.func("Testing");
		System.out.println("str in mc is \"" + mc.getStr() + "\".");
		
		// create an array by using the constructor reference
		MyClassArrayCreator mcArrayCons = MyClass2[]::new;
		MyClass2[] a = mcArrayCons.func(3);
		
		for(int i = 0; i < 3; i++) {
			a[i] = new MyClass2(i + "");
			System.out.println(a[i].getStr());
		}
		
		// create an array by using the generic constructor reference
		MyArrayCreator<Thread> mcArrayCons2 = Thread[]::new;
		Thread[] thrds = mcArrayCons2.func(5);
	}
}

interface MyFunc2 {
	// the interface has to match the class with the constructor as return type
	// to use the default constructor this method shouldn´t have a parameter
	MyClass2 func(String s);
}

// interface for creating an array
interface MyClassArrayCreator {
	MyClass2[] func(int n);
}

// generic interface to create a type flexible array
interface MyArrayCreator<T> {
	T[] func(int n);
}

class MyClass2 {
	private String str;
	
	// this is the individual constructor
	MyClass2(String s) {
		str = s;
	}
	
	// this is the default constructor
	MyClass2() {
		str = "";
	}
	
	String getStr() {
		return str;
	}
}