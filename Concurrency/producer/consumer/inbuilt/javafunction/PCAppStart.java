package producer.consumer.inbuilt.javafunction;

public class PCAppStart {
	public static void main(String[] args) throws InterruptedException {
		PC pc = new PC();

		PCThreadProducer producer = new PCThreadProducer(pc);
		PCThreadConsumer consumer = new PCThreadConsumer(pc);

		Thread thread1 = new Thread(producer);
		Thread thread2 = new Thread(consumer);

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

	}
}
