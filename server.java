import java.io.*;
import java.net.*;

public class server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSock = new ServerSocket(10007);
		Socket sock = serverSock.accept();
		//input stream for server from client side
		BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		//output stream from server
		PrintStream output = new PrintStream(sock.getOutputStream());
		String line;
		System.out.println("Bot is listening...");
		while(true) {
			line = input.readLine();
			//some outputs for the chat bot
			System.out.println("Response read : "+line);
			if(line.equals("quit"))
			{
				output.println("bye");
				break;
			}
			else if(line.equals("hi"))
				line = "Hello, client.";
			else if(line.equals("tell me a joke"))
				line = "I'm not a joker.";
			else 
				line = "I don't know about it.";
			output.println(line);
		}
		input.close();
		output.close();
		serverSock.close();
		sock.close();
	}		
}