package enum_generics;

// Use Raw Types to make code work that was written before generics were part of Java (Java 5)

public class GenericsRawTypes {
	public static void main(String args[]) {
		Generic<Integer> iObject = new Generic<Integer>(88);
		Generic<String> strObject = new Generic<String>("Generics Test");
		// if there is no type argument a raw type is created
		Generic rawType = new Generic(98.6);
		
		double castRawTypeToDouble = (Double) rawType.getObject();
		System.out.println("Value: " + castRawTypeToDouble);
		
		// this will not work:
		//int i = (Integer) rawType.getObject(); //this will compile but throw an error at runtime, it compiles because the type is not known
		
		strObject = rawType; // this is correct BUT it overrides the type safety
		rawType = iObject; // same issue as above
		//castRawTypeToDouble = (Double) rawType.getObject(); // this will throw an error at runtime
	}
}

class Generic<T> {
	T object;
	
	Generic(T object) {
		this.object = object;
	}
	
	T getObject() {
		return object;
	}
}