package myPackage;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 *   ConcurrentLinkedQueue�ǡ��̰߳�ȫ���Ķ��У���LinkedList�Ƿ��̰߳�ȫ�ġ�
 *
 *   �����ǡ�����߳�ͬʱ�������ұ���queue����ʾ��
 *   (01) ��queue��ConcurrentLinkedQueue����ʱ���������������С�
 *   (02) ��queue��LinkedList����ʱ����������ConcurrentModificationException�쳣��
 *
 * @author skywang
 */
public class ConcurrentLinkedQueueDemo1 {

    // TODO: queue��LinkedList����ʱ����������
    //private static Queue<String> queue = new LinkedList<String>();
    private static Queue<String> queue = new ConcurrentLinkedQueue<String>();
    public static void main(String[] args) {
    
        // ͬʱ���������̶߳�queue���в�����
        new MyThread("ta").start();
        new MyThread("tb").start();
        new MyThread("tc").start();
        new MyThread("td").start();
    }

    private static void printAll() {
        String value;
        Iterator iter = queue.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
        
        System.out.print("````````");
        
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
                int i = 0;
            while (i++ < 4) {
                // ���߳����� + "-" + "���"
                String val = Thread.currentThread().getName()+i;
                queue.add(val);
                // ͨ����Iterator������queue��
                printAll();
            }
        }
    }
}