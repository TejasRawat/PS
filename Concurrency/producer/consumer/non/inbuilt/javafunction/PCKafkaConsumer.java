package producer.consumer.non.inbuilt.javafunction;

import java.util.Vector;

public class PCKafkaConsumer implements Runnable {

	private final Vector<Integer> sharedQueue;

	public PCKafkaConsumer(Vector<Integer> sharedQueue, int size) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed: " + consume());
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}
	}

	private int consume() throws InterruptedException {
		// wait if queue is empty
		while (sharedQueue.isEmpty()) {
			synchronized (sharedQueue) {
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: "
						+ sharedQueue.size());

				sharedQueue.wait();
			}
		}

		// Otherwise consume element and notify waiting producer
		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			return (Integer) sharedQueue.remove(0);
		}
	}

}
