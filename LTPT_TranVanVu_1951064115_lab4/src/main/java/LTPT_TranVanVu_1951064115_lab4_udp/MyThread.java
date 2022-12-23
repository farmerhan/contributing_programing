package _package;
import java.util.*;
public class MyThread extends Thread {
    private String rawStr = null;
    private ArrayList<Integer> oddArr = null;    
    private ArrayList<Integer> eArr = null;
    private String resStr;
    public MyThread(String integersString) {
        this.rawStr = integersString;
        this.oddArr = new ArrayList<Integer>();
        this.eArr = new ArrayList<Integer>();
        this.resStr = "";
    }
    public void split() {
        String[] items = this.rawStr.split("\\s");
        for(String item : items) {
            int number = Integer.parseInt(item);
            if(number%2==0) {
                eArr.add(number);
                continue;
            }
            oddArr.add(number);
        }
    }
    public String getResult() {
        Collections.sort(this.eArr);
        Collections.sort(this.oddArr);        
        int lengthE = this.eArr.size();
        int lengthO = this.oddArr.size();
        int k = 1;
        int m = 0;
        String resStr = Integer.toString(this.eArr.get(0));
        String separate = " ";
        
        while(k < lengthE || m < lengthO) {
            if(m < lengthO) {
                resStr += separate + this.oddArr.get(m);
                m++;
            }
            if(k < lengthE) {
                resStr += separate + this.eArr.get(k);
                k++;
            }
        }
        return resStr;
    }
    public void run() {
        this.split();
        this.resStr = this.getResult();
    }
    public String getResultStr() {
        return this.resStr;
    }
}
