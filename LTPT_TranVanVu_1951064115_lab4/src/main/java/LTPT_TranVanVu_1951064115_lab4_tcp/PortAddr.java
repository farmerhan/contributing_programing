/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LTPT_TranVanVu_1951064115_lab4_tcp;

/**
 *
 * @author tranvanvu
 */
public class PortAddr {
    String hostname;
    int portnum;
    public PortAddr(String s, int i) {
        hostname = new String(s);
        portnum = i;
    }
    public String gethostname() {
        return hostname;
    }
    public int getportnum() {
        return portnum;
    }
}

