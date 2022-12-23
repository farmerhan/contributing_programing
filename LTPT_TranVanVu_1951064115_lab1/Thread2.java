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
public class Thread2 extends Thread{
    protected Prime prime;
    private List<Integer> rawList;
    private List<Integer> primeList;
    
    public Thread2(List<Integer> rawList) {
        this.rawList = rawList;
    }
    
    public void run() {
        this.primeList = prime.getListPrimeNumber(this.rawList, true);
    }
    
    public List<Integer> getListPrimeNumber() {
        return this.primeList;
    }
}
