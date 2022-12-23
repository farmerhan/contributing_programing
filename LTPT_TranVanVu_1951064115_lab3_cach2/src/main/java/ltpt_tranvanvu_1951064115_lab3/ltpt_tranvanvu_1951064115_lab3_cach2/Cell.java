/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltpt_tranvanvu_1951064115_lab3.ltpt_tranvanvu_1951064115_lab3_cach2;

/**
 *
 * @author tranvanvu
 */
class Cell {
    int value;
    public synchronized int getValue() {
        return value;
    }
    public synchronized void setValue(int i) {
        value = i;
    }
    protected synchronized void doSwap(Cell x) {
        int temp = getValue();
        setValue(x.getValue());
        x.setValue(temp);
    }
    public void swap(Cell x) {
        if (this == x)
            return;
        else if (System.identityHashCode(this)
                < System.identityHashCode(x))
            doSwap(x);
        else
            x.doSwap(this);
    }
}
