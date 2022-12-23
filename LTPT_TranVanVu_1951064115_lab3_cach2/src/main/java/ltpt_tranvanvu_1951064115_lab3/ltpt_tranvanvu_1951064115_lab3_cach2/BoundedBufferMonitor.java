/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltpt_tranvanvu_1951064115_lab3.ltpt_tranvanvu_1951064115_lab3_cach2;

/**
 *
 * @author tranvanvu
 */
class BoundedBufferMonitor {
    final int sizeBuf = 10;
    double[] buffer = new double[sizeBuf];
    int inBuf = 0, outBuf = 0, count = 0;
    public synchronized void deposit(double value) {
        while (count == sizeBuf) // buffer full
            Util.myWait(this);
        buffer[inBuf] = value;
        inBuf = (inBuf + 1) % sizeBuf;
        count++;
        if (count == 1) // items available for fetch
            notify();
    }
    public synchronized double fetch() {
        double value;
        while (count == 0) // buffer empty
            Util.myWait(this);
        value = buffer[outBuf];
        outBuf = (outBuf + 1) % sizeBuf;
        count--;
        if (count == sizeBuf - 1) // empty slots available
            notify();
        return value;
    }
}
