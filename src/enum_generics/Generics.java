package enum_generics;

public class Generics {
	public static void main(String args[]) {
		// class Gen
		Gen<Integer> iOb;
		iOb = new Gen<Integer>(88);	
		iOb.showType();
		int v = iOb.getObject();
		System.out.println("Value: " + v);
		System.out.println();
		
		Gen<String> strObject = new Gen<String>("Generic Test");
		strObject.showType();
		String str = strObject.getObject();
		System.out.println("Value: " + str);
		
		// Class TwoGen
		System.out.println();
		TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Generics"); // <> is called diamond operator and is an empty type argument list, there is no need to put the types there again
		tgObj.showTypes();
		int a = tgObj.getOb1();
		System.out.println("Value of T: " + a);
		String b = tgObj.getOb2();
		System.out.println("Value of V: " + b);
		System.out.println();
		
		// Class Bounded Types
		NumericFNS<Integer> iOb2 = new NumericFNS<Integer>(5);
		System.out.println("Reciprocal of iOb2 is " + iOb2.reciprocal());
		System.out.println("Fractional Component of iOb2 is " + iOb2.fraction());
		System.out.println();
		NumericFNS<Double> dOb = new NumericFNS<Double>(5.25);
		System.out.println("Reciporcal of dOb is " + dOb.reciprocal());
		System.out.println("Fractional Component of iOb2 is " + dOb.fraction());
		// The declaration of a String will throw an error because of the generic class being bounded to Numbers
		//NumericFNS<String> strOb = new NumericFNS<String>("Error");
		
		// Class Bounded Types, demonstration of the wildcard (?)
		System.out.println();
		NumericFNS<Integer> iOb3 = new NumericFNS<Integer>(6);
		NumericFNS<Double> dOb2 = new NumericFNS<Double>(-6.0);
		NumericFNS<Long> lOb = new NumericFNS<Long>(5L);
		System.out.println("Testing Integer and Double.");
		if(iOb3.absEqual(dOb2))
			System.out.println("Absolute values are equal.");
		else
			System.out.println("Absolute values differ.");
		System.out.println();
		System.out.println("Testing Integer and Long.");
		if(iOb3.absEqual(lOb))
			System.out.println("Absolute values are equal.");
		else
			System.out.println("Absolute values differ.");
	}
}

// classic generic
class Gen<T> {
	T object;
	
	Gen(T o) {
		object = o;
	}
	
	T getObject() {
		return object;
	}
	
	void showType() {
		System.out.println("Type of T is " + object.getClass().getName());
	}
}

// Two Generics
class TwoGen<T, V> {
	T ob1;
	V ob2;
	
	TwoGen(T o1, V o2) {
		ob1 = o1;
		ob2 = o2;
	}
	
	T getOb1() {
		return ob1;
	}
	
	V getOb2() {
		return ob2;
	}
	
	void showTypes() {
		System.out.println("Type of T is " + ob1.getClass().getName());
		System.out.println("Type of V is " + ob2.getClass().getName());
	}
}

// Bounded Types (bounded to the class Number)
class NumericFNS<T extends Number> {
	T num;
	
	NumericFNS(T n) {
		num = n;
	}
	
	double reciprocal() {
		return 1 / num.doubleValue();
	}
	
	double fraction() {
		return num.doubleValue() - num.intValue();
	}
	
	// The wildcard (?) matches / compares any valid objects of this class
	boolean absEqual(NumericFNS<?> ob) {
		if(Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue()))
			return true;
		
		return false;
	}
 }
