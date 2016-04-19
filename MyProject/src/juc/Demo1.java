package juc;

//Demo1.java��Դ��
class MyThread extends Thread {
 
 public MyThread(String name) {
     super(name);
 }

 @Override
 public void run() {
     int i=0;
	 while (true) {
	     //Thread.sleep(100); // ����100ms
	     i++;
	     System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);  
	 }
 }
}

public class Demo1 {

 public static void main(String[] args) {  
     try {  
         Thread t1 = new MyThread("t1");  // �½����߳�t1��
         System.out.println(t1.getName() +" ("+t1.getState()+") is new.");  

         t1.start();                      // �������߳�t1��
         System.out.println(t1.getName() +" ("+t1.getState()+") is started.");  

         // ���߳�����300ms��Ȼ�����̸߳�t1�����жϡ�ָ�
         Thread.sleep(300);
         t1.interrupt();
         System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

         // ���߳�����300ms��Ȼ��鿴t1��״̬��
         Thread.sleep(300);
         System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
     } catch (InterruptedException e) {  
         e.printStackTrace();
     }
 } 
}