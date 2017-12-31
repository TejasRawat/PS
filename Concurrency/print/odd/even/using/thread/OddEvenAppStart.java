package print.odd.even.using.thread;

public class OddEvenAppStart {
	public static void main(String[] args) {

		PrintNumber printNumber = new PrintNumber(100);
		
		PrintEvenThread printEvenThread = new PrintEvenThread(printNumber);
		PrintOddThread printOddThread   = new PrintOddThread(printNumber);

		Thread evenThread = new Thread(printEvenThread,"even");
		Thread oddThread  = new Thread(printOddThread,"odd");

		evenThread.start();
		oddThread.start();
	
	}
}
