/*
This program shows a SIMPLE EXAMPLE of how communication
between TWO SEPARATE APPLICATIOS can TAKE PLACE by TRANSFER
of MESSAGES(DATA) from ONE APPLICATION TO ANOTHER APPLICATION.
The COMMUNICATING APPLICATIONS are IMPLEMENTED as SEPATE 
Java PROJECTS that are OPENNED SIMULTANEOUSLY in the
NetBeans IDE.  
Each MESSAGE SENT by ONE APPLICATION is RECEIVED by the OTHER 
APPLICATION which continuously waits for SUCCESSIVE MESAGES from 
the SENDING APPLICATION.
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
which is linked to the socket. */
package oop_swe_lab5_b;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class cl_app_b  {
    public int port;
    public int buf_size = 1024;
    public byte buf[] = new byte[buf_size];
    public DatagramSocket dg_sk;
    
    cl_app_b(DatagramSocket sk, int pt)  {
        dg_sk = sk;
        port = pt;
        
    }
    public void do_app_b() throws Exception {
        String recv_str;
        DatagramPacket r_packet = new DatagramPacket(buf, buf.length);
                  
                
	while (true) {
                       
            
            dg_sk.receive(r_packet);
            
            recv_str = new String(r_packet.getData(), 0, r_packet.getLength());
            System.out.print("APP_B: Received:   ");
            System.out.println(recv_str);
            if (recv_str.trim().equals("qq")) {
		System.out.println("APP_B Stopped...");
		break;
            }
           
        }
		
    }
}
public class Oop_swe_lab5_b {

    public static void main(String[] args) {
        DatagramSocket sk;
        int com_port = 998;
        
        try {
                sk = new DatagramSocket(com_port);
                cl_app_b   com_b = new cl_app_b(sk,com_port);
                com_b.do_app_b();
               
            
        }
        catch (Exception e) {
                System.out.println(e);
        }
    }
    
}
// khur