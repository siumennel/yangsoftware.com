package myPackage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

public class MyCollection {
	public static void main(String[] args) {
		HashMap<Integer, Double> map = new HashMap<Integer , Double>();   		
	     System.out.println("aaa".hashCode());
	     
	     ArrayBlockingQueue fairQueue = new  ArrayBlockingQueue(1000,true); 


	}
	
	private Set visitorSet = Collections.synchronizedSet(new HashSet());
}
