//Client Side

import java.net.*;
import java.io.*;

class ClientSide {
	public static void main(String[] args) throws Exception {
		int ch=0,a,c;
		Socket s = new Socket("localhost",1024);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(s.getOutputStream());

		System.out.println("\n1.Factorial \n2.Fibonacci \n3.BinaryEquivalent \n0.Exit"); 
		System.out.print("\nEnter Choice: ");
		ch = Integer.parseInt(br.readLine());

		System.out.print("\nEnter Number:");
		a = Integer.parseInt(br.readLine());

		ps.println(ch);
		ps.println(a);

		BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
		c = Integer.parseInt(br1.readLine());
		System.out.println("\nAnswer: "+c);
		s.close();
	}
}