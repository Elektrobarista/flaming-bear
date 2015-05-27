import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Simple client program that reads a message from the server.
 * 
 * Note: 
 * Server has to be running!
 * 
 * @author Thomas Kemmer
 * @version 1.0 (2015-05-21)
 */
public class Client {

	/**
	 * Main program. Attempts to connect to the server and read its message.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String... args) {

		Socket server = null;

		try {
			// Connect to server on local machine ("localhost") and port 3145.
			server = new Socket("localhost", 3145);
			/*
			// Get input steam from server and read its message
			Scanner in = new Scanner(server.getInputStream());
			// If we need to send messages to the server:
			// OutputStream out = server.getOutputStream();
			*/
			Scanner in = new Scanner(
				new SecureInputStream(server.getInputStream(), server.getOutputStream())
			);
			while(in.hasNext())
				System.out.println(in.nextLine());
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException e) {

			}
		}
	}
}
