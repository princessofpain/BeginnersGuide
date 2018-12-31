package enum_generics;

import java.util.Arrays;

// Enumerations are constants that are an object of the defining enumeration class
public class Enumeration {
	public static void main(String args[]) {
		Transport tp;
		
		tp = Transport.AIRPLANE;
		
		System.out.println("Value of tp: " + tp);
		System.out.println();
		
		tp = Transport.TRAIN;
		
		if(tp == Transport.TRAIN) 
			System.out.println("tp contains the value " + Transport.valueOf("TRAIN") + ".");
		
		switch(tp) {
		case CAR: System.out.println("A car carries people.");
		          break;
		case TRUCK: System.out.println("A truck carries freight.");
		 			break;
		case AIRPLANE: System.out.println("An airplane flies.");
					   break;
		case TRAIN: System.out.println("A train runs on rails.");
		 			break;
		case BOAT: System.out.println("A boat sails on water.");
		 		   break;
		}
		
		System.out.println("This are all the values of the Enumeration: " + Arrays.toString(Transport.values()) + "\n");
		System.out.println(Transport.valueOf("BOAT"));
		
		System.out.print("\nThe " + Transport.valueOf("TRAIN") + " has a speed of " + tp.getSpeed() + " miles an hour.");
		System.out.println("\nThe " + Transport.valueOf("TRUCK") + " has a speed of " + Transport.TRUCK.getSpeed() + " miles an hour.");
		
		System.out.println("\nThe " + Transport.valueOf("BOAT") + " has position " + Transport.BOAT.ordinal() + " in the list, while the " + 
				Transport.valueOf("AIRPLANE") + " has position " + Transport.AIRPLANE.ordinal() + " in the list.");
		
		if(Transport.TRAIN.compareTo(Transport.CAR) < 0) {
			System.out.println("\nTRAIN has an earlier position in the list than CAR.");
		} else if(Transport.TRAIN.compareTo(Transport.CAR) == 0) {
			System.out.println("\nTRAIN has the same position in the list as CAR.");
		} else {
			System.out.println("\nTRAIN has a later position in the list than CAR.");
		}
	}
}

// enumerations are implemented as class types, therefore they can: constructors, instance variables + methods, implement interfaces 
// cannot be extended, enum can´t inherit another class
enum Transport {
	CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22); // uppercase is not required for enumerations but because of often replacing final variables it´s design related
	
	private int speed;
	
	Transport(int s) {
		speed = s;
	}
	
	int getSpeed() {
		return speed;
	}
}
