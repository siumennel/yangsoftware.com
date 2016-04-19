package myProducerCustmer;

public class Depot{
	volatile private int currentCnt = 0;
 	final int Max_Cnt = 10;
	
 	public Depot(int defaultCnt) {
 		this.currentCnt = this.currentCnt + defaultCnt;
	}

	synchronized public int  getCurrentCnt() {
		return currentCnt;
	}
	
	 public void putIn(int putInCnt) {
		this.currentCnt = this.currentCnt + putInCnt;
	}
 	
	 public void getOut(int getOutCnt) {
		this.currentCnt = this.currentCnt - getOutCnt;
	}	 	
}
