import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient
{
	public String Send(String data, String host, int port) throws UnknownHostException, IOException
	{
		String serverResponse = "";
		Socket clientSocket = new Socket(host,port);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromSever = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		outToServer.writeBytes(data + '\n');

		serverResponse = inFromSever.readLine();
		System.out.println(serverResponse);
		
		clientSocket.close();
		
		return serverResponse;
	}
}
