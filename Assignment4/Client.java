import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
		// initializing the client for the server at port 11501
		Socket socket = new Socket("localhost", 11501);
		// creating random object.
		Random rnd = new Random();
		// creating the random boundaries with the guess number and control statement
		int min = 0, max = 100, guess;
		boolean flag = true;

		// creating input and output streams for data and giving a feedback when connected to a server.
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		System.out.println("Client is connected to server");
		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		OutputStream output = socket.getOutputStream();
		DataOutputStream dot = new DataOutputStream(output);
		
		
		// starting the game for client, which it starts to guess and sends it's guess to the server.
		// commented sout lines are for double checking the value
		while (flag) {

			try {
				guess = rnd.nextInt(max - min) + min;
				dot.writeUTF("Client guesses: " + guess);
				System.out.println("Client guesses: " + guess);
				String[] message = dataInputStream.readUTF().split(":");
				if (message[1].equals(" Correct"))
					flag = false;
				else if (message[1].equals(" Smaller")) {
					max = guess;
					//System.out.println("max = " + max);
				} else if (message[1].equals(" Greater")) {
					min = guess;
					//System.out.println("min = " + min);
				}
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				dot.writeUTF("Client couldn't write");
			}
		}

		socket.close();

	}
}
