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
public class Thread3 extends Thread{
    protected Prime prime;
    private List<Integer> rawList;
    private List<Integer> primeList;
    
    public Thread3(List<Integer> rawList) {
        this.rawList = rawList;
    }
    
    public void run() {
        this.primeList = this.getListPrimeNumber();
    }
    
    public List<Integer> getListPrimeNumber() {
        List<Integer> primeList = new ArrayList<Integer>();
        for(int i=0;i<this.rawList.size();i++) {
            if(prime.checkPrimeNumber(this.rawList.get(i))) {
                primeList.add(this.rawList.get(i));
            }
        }
        return primeList;
    }
}
