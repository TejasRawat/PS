package producer.consumer.non.inbuilt.javafunction;

import java.util.Vector;

public class PCKafkaProducer implements Runnable {

	private final Vector<Integer> sharedQueue;
	private final int size;

	public PCKafkaProducer(Vector<Integer> sharedQueue, int size) {
		this.sharedQueue = sharedQueue;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("Produced: " + i);
			try {
				produce(i);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {

		// wait if queue is full
		while (sharedQueue.size() == size) {
			synchronized (sharedQueue) {
				System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: "
						+ sharedQueue.size());

				sharedQueue.wait();
			}
		}

		// producing element and notify consumers
		synchronized (sharedQueue) {
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
	}
}
