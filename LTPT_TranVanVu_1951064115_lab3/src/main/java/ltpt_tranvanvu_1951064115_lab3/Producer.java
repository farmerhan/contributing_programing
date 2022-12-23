package _package;

import java.util.*;

class Producer implements Runnable {
    BoundedBuffer b = null;
    int min = 20;
    int max = 100;
    public Producer(BoundedBuffer initb) {
        b = initb;
        new Thread(this).start();
    }
    public void run() {
        int item;
        Random r = new Random();
        while (true) {
            item = r.ints(this.min, this.max).findFirst().getAsInt();
            System.out.println("produced item " + item);
            b.deposit(item);
            Util.mySleep(1000);
        }
    }
}

