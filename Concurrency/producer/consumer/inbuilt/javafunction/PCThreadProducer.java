package producer.consumer.inbuilt.javafunction;

public class PCThreadProducer implements Runnable	{

	private PC pc;

	public PCThreadProducer(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		try {
			pc.produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
