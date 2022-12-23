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
public interface Lock {
    void requestCS(int threadId);
    void releaseCS(int threadId);
}
