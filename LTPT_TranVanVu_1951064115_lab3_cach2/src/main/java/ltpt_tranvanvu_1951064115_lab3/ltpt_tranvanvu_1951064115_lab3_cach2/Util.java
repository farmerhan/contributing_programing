/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltpt_tranvanvu_1951064115_lab3.ltpt_tranvanvu_1951064115_lab3_cach2;

/**
 *
 * @author tranvanvu
 */
public class Util {
    public static void mySleep(int time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException e) {}
    }
    
    public static void myWait(Object obj) {
        System.out.println("waiting");
        try {
            obj.wait();
        } catch(InterruptedException e) {}
    }
}
