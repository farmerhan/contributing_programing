import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.*;

public class SortImplement extends UnicastRemoteObject implements SortInterface {
    private ArrayList<Integer> evenArr;
    private ArrayList<Integer> oddArr;
    
    public SortImplement() throws RemoteException {
        super();
        this.evenArr = new ArrayList<Integer>();        
        this.oddArr = new ArrayList<Integer>();
    }
    
    public void splitToOddAndEvenArr(ArrayList<Integer> integersList) {
        for(Integer integer : integersList) {
            if(integer%2==0) {
                this.evenArr.add(integer);
                continue;
            }
            this.oddArr.add(integer);
        }
    }
    
    public ArrayList<Integer> getResult() {
        Collections.sort(this.evenArr);
        Collections.sort(this.oddArr);        
        int lengthE = this.evenArr.size();
        int lengthO = this.oddArr.size();
        int k = 1;
        int m = 0;
        
        ArrayList<Integer> resultArr = new ArrayList<Integer>();
        resultArr.add(this.evenArr.get(0));
        while(k < lengthE || m < lengthO) {
            if(m < lengthO) {
                resultArr.add(this.oddArr.get(m));
                m++;
            }
            if(k < lengthE) {
                resultArr.add(this.evenArr.get(k));
                k++;
            }
        }
        return resultArr;
    }
    
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> rawList) throws Exception {
        this.splitToOddAndEvenArr(rawList);
        return this.getResult();
    }
}
