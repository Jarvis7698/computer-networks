import java.io.*;
import java.net.*;
import java.util.Scanner;
class stopwaitsender {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Number Of Frames:");
		int n = sc.nextInt();
		Socket skt = new Socket("localhost",9999);
		PrintStream ps = new PrintStream(skt.getOutputStream());
		for(int i=0; i<=n; ) {
			if( i==n ) {
				ps.println("Exit");
				break;
			}
			System.out.println("\nFrame "+i+" Sent...");
			ps.println(i);

			BufferedReader bf = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			String ack = bf.readLine();
			if(ack!=null) {
				System.out.println("\nAcknowledgement Received");
				i++;
				Thread.sleep(1500);
			}
			else {
				ps.println(i);
			}
		}
	}
	//class ends here
}
