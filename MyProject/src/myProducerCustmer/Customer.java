package myProducerCustmer;

public class Customer extends Thread {

	public Customer(Depot dep) {

		this.dep = dep;
	}

	Depot dep = null;

	// @Override
	public void run() {

		for (int i=0;i<10000;i++) {
			double radomDecimal = Math.random();

			try {

				//sleep((long) (radomDecimal * 5000));

				int getOutCnt = 1;//(int) (radomDecimal * 10);
				dep.getOut(-1);
				System.out.println(" - " + getOutCnt + " = " + dep.getCurrentCnt());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
