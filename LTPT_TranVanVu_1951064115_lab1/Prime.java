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
public class Prime {
    public static boolean checkPrimeNumber(int number) {
        if(number == 1) {
            return false;
        }
        
        for(int i=2;i<number;i++) {
            if(number%i==0) {
                return false;
            }
        }
        return true;
    }
    
    public static List<Integer> getListPrimeNumber (List<Integer> rawList, boolean isHalfTop) {
        int N = rawList.size();
        int middleIndex = (int)N/2;
        int initIndex = isHalfTop ? middleIndex+1 : 0;
        int endIndex = isHalfTop ? N-1 : middleIndex;
        
        List<Integer> listPrimeNumber = new ArrayList<Integer>();
        for(int i=initIndex; i<=endIndex; i++) {
            if(checkPrimeNumber(rawList.get(i))) {
                listPrimeNumber.add(rawList.get(i));
            }
        }
        
        return listPrimeNumber;
    }
    
    public static List<Integer> getListPrimeNumberWithRange (List<Integer> rawList, int startIndex, int endIndex) {
        List<Integer> listPrimeNumber = new ArrayList<Integer>();
        for(int i=startIndex; i<=endIndex; i++) {
            if(checkPrimeNumber(rawList.get(i))) {
                listPrimeNumber.add(rawList.get(i));
            }
        }
        
        return listPrimeNumber;
    }
}
