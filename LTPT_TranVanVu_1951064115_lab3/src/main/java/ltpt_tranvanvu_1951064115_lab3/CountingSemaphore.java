package _package;

public class CountingSemaphore {
    int value;
    public CountingSemaphore(int initValue) {
        value = initValue;
    }
    public synchronized void P() {
        value--;
        if (value < 0) Util.myWait(this); // in queue of blocked processes                
    }
    public synchronized void V() {
        value++;
        if (value <= 0) notify();
    }
}
