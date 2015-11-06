import java.io.IOException;

public class mainTest {

	public static void main(String[] args) {
		TCPClient client = new TCPClient();
		
		try {
			client.Send("SENSOR Test", "localhost", 11000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}