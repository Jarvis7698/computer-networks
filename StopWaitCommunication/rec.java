import java.io.*;
import java.net.*;
class stopwaitreceiver {

	public static void main(String args[])throws Exception {

		String temp=" ",str="Exit";
		ServerSocket ss=new ServerSocket(9999);
		Socket ss_accept = ss.accept();
		BufferedReader ss_bf=new BufferedReader(new InputStreamReader(ss_accept.getInputStream()));
		PrintStream ps=new PrintStream(ss_accept.getOutputStream());
		while(temp.compareTo(str)!=0) {
			Thread.sleep(1000);
			temp=ss_bf.readLine();
			if(temp.compareTo(str)==0)
				break;
			System.out.println("\nFrame "+temp+" Received...");
			Thread.sleep(1000);
			ps.println("\nReceived");
		}
		System.out.println("\nAll Frames Received Correctly!");
	}
}
