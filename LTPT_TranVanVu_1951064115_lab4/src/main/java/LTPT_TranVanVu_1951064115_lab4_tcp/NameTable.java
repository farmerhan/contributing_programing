/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LTPT_TranVanVu_1951064115_lab4_tcp;

/**
 *
 * @author tranvanvu
 */
import java.util.*;
public class NameTable {
    final int maxSize = 100;
    private String[] names = new String[maxSize];
    private String[] hosts = new String[maxSize];
    private int[] ports = new int[maxSize];
    private int dirsize = 0;
    int search(String s) {
        for (int i = 0; i < dirsize; i++)
            if (names[i].equals(s)) return i;
        return -1;
    }
    int insert(String s, String hostName, int portNumber) {
        int oldIndex = search(s); // is it already there
        if (oldIndex == -1) {
            names[dirsize] = s;
            hosts[dirsize] = hostName;
            ports[dirsize] = portNumber;
            dirsize++;
            return 1;
        } else
            return 0;
    }
    int getPort(int index) {
        return ports[index];
    }
    String getHostName(int index) {
        return hosts[index];
    }
}
