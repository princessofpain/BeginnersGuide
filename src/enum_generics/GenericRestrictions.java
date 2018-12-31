package enum_generics;

public class GenericRestrictions {
	public static void main(String args[]) {
		Integer n[] = { 1, 2, 3, 4, 5 };
		ArrayRestrictions<Integer> iObject = new ArrayRestrictions<Integer>(50, n); // this is okay
		ArrayRestrictions<?> gens[] = new ArrayRestrictions<?>[10]; // this is okay
		//ArrayRestrictions<Integer> gens[] = new ArrayRestrictions<Integer>[10]; // can´t create an array of type-specific generic references
	}
}

class ArrayRestrictions<T extends Number> {
	T object;
	T vals[]; // This is okay
	
	ArrayRestrictions(T object, T[] nums) {
		this.object = object;
		//vals = new T[10]; // can´t create an array of T
		vals = nums;   // This is okay
	}
}

class TypeParametersCantBeInstantiated<T> {
	T object;
	TypeParametersCantBeInstantiated() {
		//object = hew T();
	}
}

/*class NoStaticMembers<T> {
	static T object;
	
	static T getObject() {
		return object;
	}
}*/