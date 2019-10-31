import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Socket {
	
	private int myPortNumber;
	private InetAddress myAddress;
	private DatagramSocket mySocket;
	
	public Socket(int myPortNumber) {
		
		this.myPortNumber = myPortNumber;
		
		try {
			this.myAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
			System.exit(-1);
		}
		
		System.out.println("My IP Address is " + this.myAddress.getHostAddress());
		System.out.println("My Port Number is " + this.myPortNumber);
		
		try {
			this.mySocket = new DatagramSocket(myPortNumber, myAddress);
		} catch (SocketException se) {
			se.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	public void send(String message, InetAddress destinationAddress, int destinationPort) {
		
		byte[] outBuffer;
		outBuffer = message.getBytes();
		
		DatagramPacket outPacket = new DatagramPacket(outBuffer, outBuffer.length, destinationAddress, destinationPort);
		
		try {
			this.mySocket.send(outPacket);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	public int getMyPortNumber() {
		
		return this.myPortNumber;
		
	}
	
	public InetAddress getMyAddress() {
		
		return this.myAddress;
		
	}

}
