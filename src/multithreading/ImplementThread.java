package multithreading;

public class ImplementThread {
	public static void main(String args[]) {
		System.out.println("Main thread starting.");
		
		MyThread2 mt = MyThread2.createAndStart("Child #1");
		
		for(int i = 0; i < 50; i++) {
			System.out.println(".");
			try {
				Thread.sleep(100);
			} catch(InterruptedException exc) {
				System.out.println("Main thread interrupted.");
			}
		}
		
		System.out.println("Main thread ending.");
	}
}

class MyThread2 implements Runnable {
	Thread thrd;
	
	MyThread2(String name) {
		thrd = new Thread(this, name);
	}
	
	public static MyThread2 createAndStart(String name) {
		MyThread2 myThrd = new MyThread2(name);
		
		myThrd.thrd.start();
		return myThrd;
	}
	
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			for(int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + thrd.getName() + ", count is " + count);
			}
		} catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " terminating.");
	}
}