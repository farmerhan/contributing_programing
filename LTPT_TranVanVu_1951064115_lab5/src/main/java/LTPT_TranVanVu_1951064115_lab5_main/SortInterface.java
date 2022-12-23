import java.rmi.Remote;
import java.util.*;

public interface SortInterface extends Remote
{
    public ArrayList<Integer> sort(ArrayList<Integer> rawList) throws Exception;
}
