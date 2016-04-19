package juc;

public class WaitTimeoutTest {

	public static void main(String[] args) {

		// WaitTimeoutTest.java的源码
		class ThreadA extends Thread {

			public ThreadA(String name) {
				super(name);
			}

			public void run() {

				// 死循环，不断运行。
				for (int i = 0; i < 10000; i++) {
					try {
						Thread.currentThread().sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (this) {
						System.out.println(Thread.currentThread().getName() + " run ");
					}
				}

			}
		}

		ThreadA t1 = new ThreadA("t1");

		synchronized (t1) {
			try {
				// 启动“线程t1”
				System.out.println(Thread.currentThread().getName() + " start t1");
				t1.start();

				Thread.currentThread().sleep(5000);
				// 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
				System.out.println(Thread.currentThread().getName() + " call wait ");
				t1.wait(10000);

				System.out.println(Thread.currentThread().getName() + " continue");
				
				Thread.currentThread().sleep(5000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
