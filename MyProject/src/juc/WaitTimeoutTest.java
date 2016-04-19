package juc;

public class WaitTimeoutTest {

	public static void main(String[] args) {

		// WaitTimeoutTest.java��Դ��
		class ThreadA extends Thread {

			public ThreadA(String name) {
				super(name);
			}

			public void run() {

				// ��ѭ�����������С�
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
				// �������߳�t1��
				System.out.println(Thread.currentThread().getName() + " start t1");
				t1.start();

				Thread.currentThread().sleep(5000);
				// ���̵߳ȴ�t1ͨ��notify()���� �� notifyAll()���ѣ��򳬹�3000ms��ʱ��Ȼ��ű����ѡ�
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
