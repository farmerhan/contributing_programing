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
public class LTPT_TranVanVu_1951064115_lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
        
        try {
            thread2.join();            
            thread1.join();
            
            System.out.println("Counter value is: " + SharedClass.count);
        } catch(InterruptedException e){} 
        
    }
    
}
