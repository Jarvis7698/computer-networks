//Server Side

import java.net.*;
import java.io.*;

class ServerSide {

	public static int factorial(int a) {
		int f=1;
		for(int i=1;i<=a;i++) {
			f = f * i;
		}
		return f;
	}

	public static int fibonacci(int n) {
		int a=1,b=1,fibo=1;
		if(n==1) return 1;
		if(n==2) return 1;
		for(int i=2;i<n;i++) {
			fibo = a+b;
			a = b;
			b = fibo;
		}
		return b;
	}

	public static int binary(int n) {
		return (Integer.parseInt(Integer.toBinaryString(n)));
	}

	public static void main(String[] args) throws Exception {
		int choice,a,c=0;
		ServerSocket ss = new ServerSocket(1024);
		Socket s = ss.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		choice =Integer.parseInt(br.readLine());
		a =Integer.parseInt(br.readLine());

		switch(choice) {
			case 1 : c = factorial(a);
			break;
			case 2 : c = fibonacci(a);
			break;
			case 3 : c = binary(a);
			break;
		}
		PrintStream pr = new PrintStream(s.getOutputStream());
		pr.println(c);
		ss.close();
		s.close();
	}
}
