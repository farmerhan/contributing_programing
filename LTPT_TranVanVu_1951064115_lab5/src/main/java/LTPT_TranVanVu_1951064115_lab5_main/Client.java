import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Client {
    static int maxSize = 100;
    
    public static void printArr(ArrayList<Integer> integers) {
        for(int integer : integers) {
            System.out.print(integer + " ");
        }
    }
    
    public static int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
    
    public static ArrayList<Integer> genRawList() {
        ArrayList<Integer> rawList = new ArrayList<Integer>();
        for(int i=0;i<maxSize;i++) {
            rawList.add(getRandomNumber());
        }
        return rawList;
    } 
    
    public static void main(String[] args) throws Exception {
        SortInterface obj = (SortInterface)Naming.lookup("sort");
        ArrayList<Integer> resultArr = obj.sort(genRawList());
        printArr(resultArr);
    }
}
