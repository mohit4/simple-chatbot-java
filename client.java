import java.io.*;
import java.net.*;

public class client {
	public static void main(String[] args) throws Exception {
		Socket sock = new Socket("127.0.0.1",10007);
		//input to client from server
		BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		//output stream from client to server
		PrintStream output = new PrintStream(sock.getOutputStream());
		//user side input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while (true) {
			System.out.print("User : ");
			line = br.readLine();
			output.println(line);
			line = input.readLine();
			System.out.println("Bot : "+line);
			if(line.equals("bye"))
				break;
		}
		sock.close();
		input.close();
		output.close();
		br.close();
	}
}