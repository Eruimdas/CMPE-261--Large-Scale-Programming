import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Server {

	// creating global variables

	static Random rnd = new Random();
	// max value is to determine the maximum value for the randomization.
	static int max = 100;
	// boolean controls the while loop to control the client guess until number is
	// found.
	static boolean flag = true;

	public static void main(String[] args) throws IOException {

		// initializing server at port 11501
		ServerSocket serverSocket = new ServerSocket(11501);
		Server server = new Server();
		System.out.println("Server is ready");

		// initializing guess number as random
		int guess = rnd.nextInt(max);
		System.out.println("Guess number is : " + guess);

		// printing a feedback when client has connected.
		Socket socket = serverSocket.accept();
		System.out.println("Server got a client");

		// creating input and output streams
		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);

		OutputStream output = socket.getOutputStream();
		DataOutputStream dot = new DataOutputStream(output);

		// controlling the game to continue until found.
		while (flag) {
			try {
				// taking the input from client, and splitting from the ":" to take the guessed
				// number.
				String[] data = dataInputStream.readUTF().split(":");
				// clearing the message from unnecessary spaces and type casting value to an
				// integer.
				int clientguess = Integer.parseInt(data[1].replaceAll(" ", ""));
				checkGuess(guess, clientguess, dot);
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				dot.writeUTF("Server couldn't read anything.");
			}
		}

		dot.close();
		output.close();
		socket.close();

	}
	// this methods checks if the guessed number taken from client is correct, greater or smaller
	// then prints the output.
	private static void checkGuess(int guess, int clientguess, DataOutputStream dot) {

		if (guess == clientguess) {

			try {
				dot.writeUTF("The guess is: Correct");
				System.out.println("The guess is: Correct");
			} catch (IOException e) {
			}

			flag = false;

		} else if (clientguess < guess) {

			try {
				dot.writeUTF("Try to guess: Greater");
				System.out.println("Try to guess: Greater");
			} catch (IOException e) {
			}

		} else if (clientguess > guess) {

			try {
				dot.writeUTF("Try to guess: Smaller");
				System.out.println("Try to guess: Smaller");
			} catch (IOException e) {
			}

		}
	}

}
