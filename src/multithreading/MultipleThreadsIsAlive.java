package multithreading;

public class MultipleThreadsIsAlive {
	public static void main(String args[]) {
		System.out.println("Main thread starting");
		
		MyThread2 mt1 = MyThread2.createAndStart("Child #1");
		MyThread2 mt2 = MyThread2.createAndStart("Child #2");
		MyThread2 mt3 = MyThread2.createAndStart("Child #3");
		
		do {
			System.out.println(".");
			try {
				Thread.sleep(100);
			} catch(InterruptedException exc) {
				System.out.println("Main thread interrupted.");
			}
		} while(mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());
		
		System.out.println("Main thread ending.");
	}
}
