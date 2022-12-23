package _package;
import java.net.*;
import java.io.*;
import java.util.*;
public class DatagramClient {
    public static int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
    public static String genStr() {
        String integersString = Integer.toString(getRandomNumber());
        String separate = " ";
        for(int i=0;i<100-1;i++) {
            integersString = integersString + separate + getRandomNumber();
        }
        return integersString;
    }
    public static void main(String[] args) {
        String hostname;
        int port = 2018;
        int len = 1024;
        DatagramPacket sPacket, rPacket;
        if (args.length > 0)
            hostname = args[0];
        else
            hostname = "localhost";
        try {
            InetAddress ia = InetAddress.getByName(hostname);
            DatagramSocket datasocket = new DatagramSocket();
            
            while (true) {
                try {
                    Util.mySleep(1000);
                    String integersString = genStr();
                    byte[] buffer = integersString.getBytes();
                    sPacket = new DatagramPacket(buffer, buffer.length, ia, port);
                    datasocket.send(sPacket);
                    byte[] rbuffer = new byte[len];
                    rPacket = new DatagramPacket(rbuffer, rbuffer.length);
                    datasocket.receive(rPacket);
                    String restring = new String(rPacket.getData(), 0, rPacket.getLength());
                    System.out.println("Response string: " + restring);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (SocketException se) {
            System.err.println(se);
        }
    }
}
