import java.rmi.Naming;

public class Server {
    public static void main(String[] args) throws Exception {
        SortImplement obj = new SortImplement();
        Naming.rebind("sort", obj);
        System.out.println("Server started");
    }
}
