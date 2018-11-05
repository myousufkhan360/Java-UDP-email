/*
This program shows a SIMPLE EXAMPLE of how communication
between TWO SEPARATE APPLICATIOS can TAKE PLACE by TRANSFER
of MESSAGES(DATA) from ONE APPLICATION TO ANOTHER APPLICATION.
The COMMUNICATING APPLICATIONS are IMPLEMENTED as SEPATE 
Java PROJECTS that are OPENNED SIMULTANEOUSLY in the
NetBeans IDE.  
Each MESSAGE SENT by ONE APPLICATION is RECEIVED by the OTHER 
APPLICATION which continuously waits for SUCCESSIVE MESAGES from 
the SENDING AQPPLICATION.
The USER DATAGRAM PROTOCOL (UDP) is USED for TRANSFERRING 
each message. UDP transfers DATA in the form of PACKETS.
UDP does NOT GURANTEE TRANSFER of DATA to be RELIABLE. 
However, UDP CAUSES the TRANSFER of DATA to be QUICKER than
other protocols that ENSURE RELIABILE TRANSFER of 
DATA. 
When the receiving application gets (receives) the message sent
by the other application, the receving application DISPLAYS the MESSAGE
on the SCREEN. The transfer of data is performed through an
Object of the Java class DatagramSocket. For the tranfer of 
data, it is necessary to specify a (virtual) port number
which is linked to the socket. 
*/
package oop_swe_lab5_a;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class cl_app_a {
    public int port;
    public int buf_size = 1024;
    public DatagramSocket dg_sk;
    public byte buf[] = new byte[buf_size];
    public Scanner input = new Scanner(System.in);
    
    cl_app_a(DatagramSocket sk, int pt) {
        
        dg_sk = sk;
        port = pt;
                
    }
   
   public void do_app_a() throws Exception  {
        int msg_len;
        char init_a, init_b;
        String msg;
        DatagramPacket s_packet;
        boolean b;
        
        while (true) {

            System.out.print("Enter next message to send. Enter qq to quit. ");
            System.out.println();
            msg = input.nextLine();
            
            msg_len = msg.length();
            buf = msg.getBytes();
            
            s_packet = new DatagramPacket(buf, buf.length,
                    InetAddress.getLocalHost(), port);
            dg_sk.send(s_packet);
            
            System.out.println("APP_A: Message has been Sent " );
            if (msg.trim().equals("qq")) {
                System.out.println("APP_A Stopped");
                return;
                
            }
                                    
	}

    }

}



public class Oop_swe_lab5_a {

    
    public static void main(String[] args) {
        DatagramSocket sk;
        int com_port = 998;
        
        try {
                sk = new DatagramSocket();
                cl_app_a   com_a = new cl_app_a(sk,com_port);
                com_a.do_app_a();
                
               
            
        }
        catch (Exception e) {
                System.out.println(e);
        }
    }
    
}
