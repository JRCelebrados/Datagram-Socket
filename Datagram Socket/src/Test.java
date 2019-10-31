import java.net.DatagramPacket;
import java.net.InetAddress;

public class Test {
	
	private static Socket mySocket;
	
	public static void main(String[] args) {
		
		mySocket = new Socket(64000);
		mySocket.send("Hello Communication World!!",
					mySocket.getMyAddress(),
					mySocket.getMyPortNumber());
		
	}

}
