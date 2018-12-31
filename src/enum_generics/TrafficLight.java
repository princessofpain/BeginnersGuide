package enum_generics;

public class TrafficLight implements Runnable {
	private TrafficLightColor color;
	private boolean stop = false;
	private boolean changed = false;
	
	public static void main(String args[]) {
		TrafficLight thisLight = new TrafficLight(TrafficLightColor.GREEN);
		Thread thrd = new Thread(thisLight);
		thrd.start();
		
		for(int i = 0; i < 9; i++) {
			System.out.println(thisLight.getColor());
			thisLight.waitForChange();
		}
		
		thisLight.cancel();
	}
	
	TrafficLight(TrafficLightColor initColor) {
		color = initColor;
	}
	
	public TrafficLight() {
		color = TrafficLightColor.RED;
	}
	
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(color.getDelay());
			} catch(InterruptedException e) {
				System.out.println(e);
			}

			changeColor();
		}
	}
	
	synchronized void changeColor() {
		if(color.ordinal() == 0) {
			color = TrafficLightColor.GREEN;
		} else if (color.ordinal() == 1) {
			color = TrafficLightColor.RED;
		} else if(color.ordinal() == 2) {
			color = TrafficLightColor.YELLOW;
		}
		
		changed = true;
		notify();
	}
	
	synchronized void waitForChange() {
		try {
			while(!changed) 
				wait();
			changed = false;
		} catch(InterruptedException e) {
			System.out.println(e);
		}
	}
	
	synchronized TrafficLightColor getColor() {
		return color;
	}
	
	synchronized void cancel() {
		stop = true;
	}
}

enum TrafficLightColor {
	RED(10000), YELLOW(2500), GREEN(12000);
	private int duration;
	
	TrafficLightColor(int d) {
		duration = d;
	}
	
	int getDelay() {
		return duration;
	}
}
