package Exercises;

public class Exercises12 {
	public static void main(String args[]) {
		FlightSheds<Integer, String> fs = new FlightSheds<>(2475, "Sao Paulo");
		int a = fs.getObj1();
		String b = fs.getObj2();
		System.out.println("Flight number \"" + a + "\" to " + b);
		
		FlightShedsExtendsFirstParameter<Number, Double> fss = new FlightShedsExtendsFirstParameter<>(2475, 11.5);
		Number c = fss.getObj1();
		Double d = fss.getObj2();
		System.out.println("The Flight number \"" + c + "\" takes " + d + " hours to reach its destination " + b + ".");
		
		MyThread thrd = new MyThread("ThisThread");
		FlightShedsExtendsThread<Integer, Thread> fset = new FlightShedsExtendsThread<>(5, thrd); 
		thrd.run(fset.getObj1());
		System.out.println("Thread is closed");
		
		// Create a raw type
		Counter rawType = new Counter(5);
		int rawTypeInt = (Integer) rawType.getObject();
		System.out.println();
		System.out.println(rawTypeInt);
	}
}

class FlightSheds<T, V> {
	T obj1;
	V obj2;
	
	public FlightSheds(T obj1, V obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	T getObj1() {
		return obj1;
	}
	
	V getObj2() {
		return obj2;
	}
}

class FlightShedsExtendsFirstParameter<T, V extends T> {
	T obj1;
	V obj2;
	
	FlightShedsExtendsFirstParameter(T obj1, V obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	T getObj1() {
		return obj1;
	}
	
	V getObj2() {
		return obj2;
	}
}

class FlightShedsExtendsThread<T, V extends Thread> {
	T obj1;
	V obj2;
	
	FlightShedsExtendsThread(T obj1, V obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	T getObj1() {
		return obj1;
	}
	
	V getObj2() {
		return obj2;
	}
	
	// A method that has one type parameter, one parameter that has the type of the type parameter and returns an object of that type parameter
	T myGen(T obj) {
		T para = obj;
		return para;
	}
}

class MyThread extends Thread {
	MyThread(String name) {
		super(name); // name thread
	}
	
	public void run(int times) {
		System.out.println();
		System.out.println("I am a thread.");
		for(int i = times; i > 0; i--) {
			System.out.println("I run " + i + " more times.");
		}
		System.out.println("I close now.");
	}
}

// given this interface show the declaration of MyClass that implements the interface
interface IGenIF<T, V extends T> {}

class MyClass<T, V extends T> implements IGenIF<T, V> {
	T o;
	V a;
	
	MyClass(T o, V a) {
		this.o = o;
		this.a = a;
	}
}

//Dummy class to create a raw type
class Counter<T> {
	T object;
	
	Counter(T object) {
		this.object = object;
	}
	
	T getObject() {
		return object;
	}
}