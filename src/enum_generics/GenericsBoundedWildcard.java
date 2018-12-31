package enum_generics;

public class GenericsBoundedWildcard {
	// This method does sth with any Obj of a class that extends A
	static void test(Gen2<? extends A> o) {}
	
	public static void main(String args[]) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		Gen2<A> w = new Gen2<A>(a);
		Gen2<B> w2 = new Gen2<B>(b);
		Gen2<C> w3 = new Gen2<C>(c);
		Gen2<D> w4 = new Gen2<D>(d);
		
		test(w);
		test(w2);
		test(w3);
		// this object can´t be tested because the class doesn´t inherit from A
		//test(w4);
	}
}

class Gen2<T> {
	T ob;
	
	Gen2(T o) {
		ob = o;
	}
}

class A {}
class B extends A {}
class C extends A {}
class D {}
