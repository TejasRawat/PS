package threadpoolexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class StandAloneTest {
	public static void main(String[] args) {
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 10, 1000, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2));

		List<Future<String>> futureList = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++) {
			LocalWoker LocalWoker = new LocalWoker(String.valueOf(i));
			Future<String> future = poolExecutor.submit(LocalWoker);
			futureList.add(future);
		}
		
		for(Future<String> future :futureList) {
			try {
				System.out.println(future.get(1, TimeUnit.SECONDS));
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		}

	}
}

class LocalWoker implements Callable<String> {

	private String thId;

	public LocalWoker(String thId) {
		this.thId = thId;
	}

	public String call() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Thread.currentThread() + ":" + thId);
	}
}
