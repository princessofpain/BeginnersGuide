package multithreading;

public class SynchronizedBlock {
	public static void main(String args[]) {
		int a[] = {1, 2, 3, 4, 5};
		
		ThisThread2 tthread1 = ThisThread2.createAndStart("Child #1", a);
		ThisThread2 tthread2 = ThisThread2.createAndStart("Child #2", a);
		
		try {
			tthread1.thrd.join();
			tthread2.thrd.join();
		} catch(InterruptedException exc) {
			System.out.println("Main thread interrupted.");
		}
	}
}

class ThisThread2 implements Runnable {
	Thread thrd;
	static SumArray2 sa = new SumArray2();
	int a[];
	int answer;
	
	ThisThread2(String name, int nums[]) {
		thrd = new Thread(this, name);
		a = nums;
	}
	
	public static ThisThread2 createAndStart(String name, int nums[]) {
		ThisThread2 tthread = new ThisThread2(name, nums);
		tthread.thrd.start();
		return tthread;
	}
	
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		synchronized(sa) {
			answer= sa.sumArray2(a);
		}
		System.out.println("Sum for " + thrd.getName() + " is " + answer);
		System.out.println(thrd.getName() + " terminating.");
	}
}

class SumArray2 {
	private int sum;
	
	int sumArray2(int nums[]) {
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
