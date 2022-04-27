import java.net.*;
import java.io.*;

public class SimpleServer extends Thread {

	@Override
	public void run() throws NullPointerException {
		try {
			ServerSocket server = new ServerSocket(6010);
			System.out.println("[Server] Online");

			Socket connection = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			boolean Efirsttimecheck = false;
			boolean UEfirsttimecheck = false;

			String line = "";
			while (!line.equals("<end>")) {
				line = reader.readLine();

				int number = 0;

				if (!line.equals("<end>")) {
					number = Integer.parseInt(line);
				}

				if (number % 2 == 0) {
					if (Efirsttimecheck == false) {
						System.out.println("[Server] Nummeret er lige tal");
						Efirsttimecheck = true;
					} else {
						System.out.println("[Server] Nummeret er igen et lige tal");
					}
				}

				else {
					if (UEfirsttimecheck == false) {
						System.out.println("[Server] Nummeret er ulige tal");
						UEfirsttimecheck = true;
					} else {
						System.out.println("[Server] Nummeret er igen et ulige tal");
					}
				}
			}
			reader.close();
			System.out.println("[Server] Offline");
			
		} 
		
		catch (IOException e) {
			System.out.println("[Server] I/O error");
		}
	}
}