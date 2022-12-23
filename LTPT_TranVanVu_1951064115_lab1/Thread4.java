/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ltpt_tranvanvu_1951064115;
import java.util.*;
/**
 *
 * @author tranvanvu
 */
public class Thread4 extends Thread{
    protected Prime prime;
    private List<Integer> rawList;
    private List<Integer> primeList;
    private int startIndex;    
    private int endIndex;
    
    public Thread4(List<Integer> rawList, int startIndex, int endIndex) {
        this.rawList = rawList;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    
    public void run() {
        this.primeList = prime.getListPrimeNumberWithRange(this.rawList, this.startIndex, this.endIndex);
    }
    
    public List<Integer> getListPrimeNumber() {
        return this.primeList;
    }
}
