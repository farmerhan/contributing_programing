package _package;
import java.net.*;
import java.io.*;
public class DatagramServer {
    public static void main(String[] args) {
        DatagramPacket datapacket, returnpacket;
        int port = 2018;
        int len = 1024;
        try {
            DatagramSocket datasocket = new DatagramSocket(port);
            byte[] buf = new byte[len];
            datapacket = new DatagramPacket(buf, buf.length);
            while (true) {
                try {
                    Util.mySleep(1000);
                    datasocket.receive(datapacket);
                    String rs = new String(datapacket.getData(), 0, datapacket.getLength());
                    MyThread thandler = new MyThread(rs);
                    thandler.start();
                    try {
                        thandler.join();                        
                    } catch(Exception e) {
                        System.out.print(e.getMessage());
                    }
                    String responseData = thandler.getResultStr();
                    returnpacket = new DatagramPacket(
                            responseData.getBytes(), 
                            datapacket.getLength(), 
                            datapacket.getAddress(), 
                            datapacket.getPort());
                    datasocket.send(returnpacket);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (SocketException se) {
            System.err.println(se);
        }
    }
}

