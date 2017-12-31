package producer.consumer.inbuilt.javafunction;

public class PCThreadConsumer implements Runnable {

	private PC pc;

	public PCThreadConsumer(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		try {
			pc.consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
