package _package;

import java.util.*;

class Consumer implements Runnable {
    BoundedBuffer b = null;
    public Consumer(BoundedBuffer initb) {
        b = initb;
        new Thread(this).start();
    }
    public static boolean checkPrimeNumber(int number) {
        
    }
    public void run() {
        int item;
        while (true) {
            item = b.fetch();
            if(item <= 1) {
            	System.out.println(item + " is not prime number"); 
            } else {
            	boolean isPrimeNumber = true;
            	for(int i=2;i<item;i++) {
            	   if(item%i == 0) {
                	System.out.println(item + " is not prime number"); 
                	isPrimeNumber = false;
                	break;
                   }
           	}
           	if(isPrimeNumber) {
           	   System.out.println(item + " is prime number"); 
           	}
           	
            }
            Util.mySleep(1000);
        }
    }
}
