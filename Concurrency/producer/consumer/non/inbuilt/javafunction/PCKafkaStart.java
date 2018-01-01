package producer.consumer.non.inbuilt.javafunction;

import java.util.Vector;

public class PCKafkaStart {
	public static void main(String args[]) {

		Vector<Integer> sharedQueue = new Vector<Integer>();
		int size = 4;

		Thread prodThread = new Thread(new PCKafkaProducer(sharedQueue, size), "Producer");
		Thread consThread = new Thread(new PCKafkaConsumer(sharedQueue, size), "Consumer");

		prodThread.start();
		consThread.start();

	}
}
