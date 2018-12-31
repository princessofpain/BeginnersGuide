package multithreading;

public class SynchronizedMethods {
	public static void main(String args[]) {
		int a[] = {1, 2, 3, 4, 5};
		
		ThisThread tthread1 = ThisThread.createAndStart("Child #1", a);
		ThisThread tthread2 = ThisThread.createAndStart("Child #2", a);
		
		try {
			tthread1.thrd.join();
			tthread2.thrd.join();
		} catch(InterruptedException exc) {
			System.out.println("Main thread interrupted.");
		}
	}
}

class ThisThread implements Runnable {
	Thread thrd;
	static SumArray sa = new SumArray();
	int a[];
	int answer;
	
	ThisThread(String name, int nums[]) {
		thrd = new Thread(this, name);
		a = nums;
	}
	
	public static ThisThread createAndStart(String name, int nums[]) {
		ThisThread tthread = new ThisThread(name, nums);
		tthread.thrd.start();
		return tthread;
	}
	
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		answer= sa.sumArray(a);
		System.out.println("Sum for " + thrd.getName() + " is " + answer);
		System.out.println(thrd.getName() + " terminating.");
	}
}

class SumArray {
	private int sum;
	
	synchronized int sumArray(int nums[]) {
		sum = 0; // reset sum
		
		for(int num: nums) {
			sum += num;
			System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
			try {
				Thread.sleep(10); // allows task switch
			} catch(InterruptedException exc) {
				System.out.println("Thread interrupted.");
			}
		}
		return sum;
	}
}
