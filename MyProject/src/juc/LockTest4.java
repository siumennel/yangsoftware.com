package juc;

/*
 * 
 * 
 * 
 */


//LockTest4.java��Դ��
class Something {
 public synchronized void isSyncA(){
     try {  
         for (int i = 0; i < 5; i++) {
             Thread.sleep(100); // ����100ms
             System.out.println(Thread.currentThread().getName()+" : isSyncA");
         }
     }catch (InterruptedException ie) {  
     }  
 }
 public synchronized void isSyncB(){
     try {  
         for (int i = 0; i < 5; i++) {
             Thread.sleep(100); // ����100ms
             System.out.println(Thread.currentThread().getName()+" : isSyncB");
         }
     }catch (InterruptedException ie) {  
     }  
 }
 public static synchronized void cSyncA(){
     try {  
         for (int i = 0; i < 5; i++) {
             Thread.sleep(100); // ����100ms
             System.out.println(Thread.currentThread().getName()+" : cSyncA");
         } 
     }catch (InterruptedException ie) {  
     }  
 }
 public static synchronized void cSyncB(){
     try {  
         for (int i = 0; i < 5; i++) {
             Thread.sleep(100); // ����100ms
             System.out.println(Thread.currentThread().getName()+" : cSyncB");
         } 
     }catch (InterruptedException ie) {  
     }  
 }
}

public class LockTest4 {

 Something x = new Something();
 Something y = new Something();

 // �Ƚ�(04) x.isSyncA()��Something.cSyncA()
 private void test4() {
     // �½�t41, t41����� x.isSyncA()
     Thread t41 = new Thread(
             new Runnable() {
                 @Override
                 public void run() {
                     x.isSyncA();
                 }
             }, "t41");

     // �½�t42, t42����� x.isSyncB()
     Thread t42 = new Thread(
             new Runnable() {
                 @Override
                 public void run() {
                     Something.cSyncA();
                 }
             }, "t42");  


     t41.start();  // ����t41
     t42.start();  // ����t42
 }

 public static void main(String[] args) {
     LockTest4 demo = new LockTest4();

     demo.test4();
 }
}