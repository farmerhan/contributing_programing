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
public class Dekker implements Lock {
    public static int turn = 0;
    public static boolean[] wantCS = {false, false};
    
    @Override
    @SuppressWarnings("empty-statement")
    public void requestCS(int threadId) {
        int theOther = 1 - threadId;
        wantCS[threadId] = true;
        while(wantCS[theOther]) {
            if(turn == theOther) {
                wantCS[threadId] = false;
                while(turn == theOther);
                wantCS[threadId] = true;
            }
        }
    }
    
    public void releaseCS(int threadId) {
        turn = 1 - threadId;
        wantCS[threadId] = false;
        System.out.println(SharedClass.count);       
    }
}
