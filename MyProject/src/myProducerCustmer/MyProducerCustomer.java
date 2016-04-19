package myProducerCustmer;

public class MyProducerCustomer {
	
	public static void main(String[] args) {
	    
		Depot d = new Depot(0);
		
		for(int i=0;i<10000;i++){
			Producer p = new Producer(d);
			p.start();
		}
		
		//Customer c1 = new Customer(d);
				
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d.getCurrentCnt());
		
	}
	
	
	
}
