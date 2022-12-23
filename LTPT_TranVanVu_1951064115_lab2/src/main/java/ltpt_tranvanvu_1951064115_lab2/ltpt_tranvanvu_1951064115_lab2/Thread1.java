/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltpt_tranvanvu_1951064115_lab2.ltpt_tranvanvu_1951064115_lab2;

/**
 *
 * @author Sinhvien
 */
public class Thread1 extends Thread implements Counter {
    private final Dekker dekker;
    private final int threadId;
    
    public Thread1() {
        this.dekker = new Dekker();
        this.threadId = 0;
    }
    
    @Override
    public void increaseCS() {
        SharedClass.count += 2;
    }
    
    @Override
    public void decreaseCS() {
        SharedClass.count -= 2;
    }
    
    @Override
    public void increase() {
        for(int i=0;i<50;i++) {
            this.dekker.requestCS(this.threadId);
            this.increaseCS();
            this.dekker.releaseCS(this.threadId);
        }
    }
    
    @Override
    public void decrease() {
        for(int i=0;i<50;i++) {
            this.dekker.requestCS(this.threadId);
            this.decreaseCS();
            this.dekker.releaseCS(this.threadId);
        }
    }
    
    @Override
    public void run() {
        this.increase();
    }
}
