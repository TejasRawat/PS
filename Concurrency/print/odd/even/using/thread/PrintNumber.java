package print.odd.even.using.thread;

public class PrintNumber {

	private boolean isEven = true;
	private int counter = 0;
	private int limit;

	public PrintNumber(int limit) {
		this.limit = limit;
	}

	public void printEvenNumber() {
		if(counter>limit) {
			System.exit(0);
		}
		System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread()+counter++);
	}

	public void printOddNumber() {
		if(counter>limit) {
			System.exit(0);
		}
		System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread()+counter++);
		
	}

	public boolean isEven() {
		return isEven;
	}

	public void setEven(boolean isEven) {
		this.isEven = isEven;
	}

}
