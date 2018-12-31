package multithreading;

public class Multithreading {

}

class OneThread implements Runnable {
	Thread thrd;
	
	OneThread(String name) {
		thrd = new Thread(this, name);
	}
	
	public static OneThread createAndStart(String name) {
		OneThread mythrd = new OneThread(name);
		
		mythrd.thrd.start();
		return mythrd;
	}
	
	public void run() {
		
	}
}