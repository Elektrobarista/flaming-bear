import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple server program that sends a message to its clients.
 * 
 * @author Thomas Kemmer
 * @version 1.0 (2015-05-21)
 */
public class Server {

	/**
	 * Main program. Serves at a specific port and sends messages to its
	 * clients.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String... args) {

		ServerSocket server = null;

		try {
			// Listen on port 3145 for client connections
			server = new ServerSocket(3145);

			//while (true) {
				Socket client = null;

				try {
					// WAIT until client tries to connect (blocking call)
					client = server.accept();
					/*
					// Grab client's output stream in order to send a message
					PrintWriter out = new PrintWriter(client.getOutputStream());
					// If we need to read messages from the client:
					// InputStream in = client.getInputStream();
					*/
					PrintWriter out = new PrintWriter(
						new SecureOutputStream(client.getOutputStream(), client.getInputStream())
					);
					
					// Send the message
					out.println("Lorem ipsum dolor sit amet,\nconsectetur adipiscii elit.");
					out.close(); // implies flush()
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (client != null)
							client.close();
					} catch (IOException e) {

					}
				}
			//}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException e1) {

			}
		}
	}
}
