/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ltpt_tranvanvu_1951064115;
import static com.mycompany.ltpt_tranvanvu_1951064115.Prime.checkPrimeNumber;
import java.util.*;
/**
 *
 * @author tranvanvu
 */
public class LTPT_TranVanVu_1951064115 {
    public static List<Integer> listPrime1;    
    public static List<Integer> listPrime2;
    
    public static void showInterleavingListPrime() {
        int list2Size = listPrime2.size()-1;
                
        System.out.println("Danh sach xen ke cac so nguyen to");
        for(int i=0;i<listPrime1.size();i++) {
            System.out.println(listPrime1.get(i));
            if(i <= list2Size) {
                System.out.println(listPrime2.get(i));
            }
        }
        System.out.println("\n");
    } 
    
    public static void assignForTwoList(List<Integer> tempList1, List<Integer> tempList2) {
        if(tempList1.size() != tempList2.size()) {
            listPrime1 = tempList1.size() > tempList2.size() ? tempList1 : tempList2;
            listPrime2 = tempList2.size() < tempList1.size() ? tempList2 : tempList1;
        } else {
            listPrime1 = tempList1;
            listPrime2 = tempList2;
        }
    }
    
    public static void showListPrimeNumber(List<Integer> primeList) {
        for(int i=0;i<primeList.size();i++) {
            System.out.println(primeList.get(i));
        }
    }
    
    public static void main(String[] args) {
        List<Integer> rawList = new ArrayList<Integer>(
            Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21)
        );
        
        Thread1 t1 = new Thread1(rawList);        
        Thread2 t2 = new Thread2(rawList);
        
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            long endTime = System.currentTimeMillis();
            
            List<Integer> tempList1 = t1.getListPrimeNumber();            
            List<Integer> tempList2 = t2.getListPrimeNumber();
            assignForTwoList(tempList1, tempList2);
            // Hien thi ket qua dan xen nhau
            showInterleavingListPrime();   
            
            // Hien thi tong so nguyen to
            int amountPrimeNumbers = listPrime1.size() + listPrime2.size();
            System.out.println("Tong so nguyen to " + amountPrimeNumbers);    
            
            // So sanh thoi gian chay hai luong
            long timeForRunTwoThread = endTime-startTime;
            Thread t3 = new Thread3(rawList);
            startTime = System.currentTimeMillis();
            t3.start();
            t3.join();
            endTime = System.currentTimeMillis();
            long timeForRunOneThread = endTime-startTime;
            System.out.println("Thoi gian chay 2 luong: " + timeForRunTwoThread + "\n");
            System.out.println("Thoi gian chay 1 luong: " + timeForRunOneThread);
           
            // Mo rong voi k luong
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap vao so luong luong: [k>2, k<=21]");
            int k = sc.nextInt();
            
            int lengthRawList = rawList.size();
            int range = lengthRawList / k;
            int startIndex = 0;
            int endIndex = range;
            Thread4 thread;
            List<Thread4> threads = new ArrayList<Thread4>();
            
            for(int i=1;i<=k;i++) {
                thread = new Thread4(rawList, startIndex, endIndex);
                thread.start();
                threads.add(thread);
                                
                startIndex = endIndex + 1;
                endIndex = endIndex + range;
                if(endIndex > lengthRawList-1) {
                    endIndex = lengthRawList-1;
                }
            }
            
            List<Integer> tempList;
            for(int i=0;i<threads.size();i++) {
                thread = threads.get(i);
                thread.join();
                tempList = thread.getListPrimeNumber();
                showListPrimeNumber(tempList);
            }
            
        } catch(InterruptedException e) {}
    }
}
