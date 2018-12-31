package genericQueueRealWorldApp;

public class QueueEmptyException extends Throwable {
	public String toString() {
		return " \nQueue is empty.";
	}
}
