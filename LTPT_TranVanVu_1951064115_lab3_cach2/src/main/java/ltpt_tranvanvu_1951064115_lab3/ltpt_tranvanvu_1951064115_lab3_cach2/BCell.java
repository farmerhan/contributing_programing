/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltpt_tranvanvu_1951064115_lab3.ltpt_tranvanvu_1951064115_lab3_cach2;

/**
 *
 * @author tranvanvu
 */
class BCell { // can result in deadlocks
    int value;
    public synchronized int getValue() {
        return value;
    }
    public synchronized void setValue(int i) {
        value = i;
    }
    public synchronized void swap(BCell x) {
        int temp = getValue();
        setValue(x.getValue());
        x.setValue(temp);
    }
}
