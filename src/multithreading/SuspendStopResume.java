package multithreading;

public class SuspendStopResume {
	public static void main(String args[]) {
		MyThread4 mt1 = MyThread4.createAndStart("My Thread");
		
		try {
			Thread.sleep(1000);
			
			mt1.mySuspend();
			System.out.println("Suspending Thread.");
			Thread.sleep(1000);
			
			mt1.myresume();
			System.out.println("Resuming thread.");
			Thread.sleep(1000);
			
			mt1.mySuspend();
			System.out.println("Suspending Thread.");
			Thread.sleep(1000);
			
			mt1.myresume();
			System.out.println("Resuming thread.");
			Thread.sleep(1000);
			
			mt1.mySuspend();
			mt1.myStop();
			System.out.println("Stopping Thread.");
		} catch(InterruptedException exc) {
			System.out.println("Main thread interrupted");
		}
		
		try {
			mt1.thrd.join();
		} catch(InterruptedException exc) {
			System.out.println("Main thread interrupted");
		}
		
		System.out.println("Main thread exciting.");
	}
}

class MyThread4 implements Runnable {
	Thread thrd;
	boolean suspended;
	boolean stopped;
	
	MyThread4(String name) {
		thrd = new Thread(this, name);
		suspended = false;
		stopped = false;
	}
	
	public static MyThread4 createAndStart(String name) {
		MyThread4 myThrd = new MyThread4(name);
		myThrd.thrd.start();
		return myThrd;
	}
	
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			
			for(int i = 1; i < 1000; i++) {
								
				System.out.print(i + " ");
				if((i%10) == 0) {
					System.out.println();
					Thread.sleep(250);
				}
				
				synchronized(this) {
					while(suspended) {
						wait();
					}
					if(stopped) break;
				}
			}
		} catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted,");
		}
		System.out.println(thrd.getName() + " exciting.");
	}
	
	synchronized void myStop() {
		stopped = true;
		suspended = false;
		notify();
	}
	
	synchronized void mySuspend() {
		suspended = true;
	}
	
	synchronized void myresume() {
		suspended = false;
		notify();
	}
}