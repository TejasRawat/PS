package threadpoolexecutor;

import java.util.concurrent.ThreadPoolExecutor;

public class MyMonitorThread implements Runnable {

	private ThreadPoolExecutor executor;
	private int delay;
	private boolean run = true;

	public MyMonitorThread(ThreadPoolExecutor executorPool, int i) {
		this.executor = executorPool;
		this.delay = i;
	}

	public void shutdown() {
		this.run = false;
	}

	@Override
	public void run() {

		 while(run){
             System.out.println(
                 String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                     this.executor.getPoolSize(),
                     this.executor.getCorePoolSize(),
                     this.executor.getActiveCount(),
                     this.executor.getCompletedTaskCount(),
                     this.executor.getTaskCount(),
                     this.executor.isShutdown(),
                     this.executor.isTerminated()));
             try {
                 Thread.sleep(delay*1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
     }
		
	}

}
