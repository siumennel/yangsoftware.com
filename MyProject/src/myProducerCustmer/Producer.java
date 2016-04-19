package myProducerCustmer;

public class Producer extends Thread {

	public Producer(Depot dep) {

		this.dep = dep;
	}

	Depot dep = null;

	//@Override
	public void run() {
	
		for (int i=0;i<1;i++) {
			double radomDecimal = Math.random();
			
			try {
				//sleep((long) (radomDecimal*50));
				
				int inputCnt = 1;//(int) (radomDecimal*10);
				dep.putIn(inputCnt);
				System.out.println(" + " + inputCnt + " = " + dep.getCurrentCnt());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
