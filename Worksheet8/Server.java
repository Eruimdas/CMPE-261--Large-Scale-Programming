
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
	public static void main(String[] args) throws IOException {
		int portNumber = Integer.parseInt(args[0]);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		int result = 0;

		Server server = new Server();
		System.out.println("Server is ready");
		Socket socket = serverSocket.accept();
		System.out.println("Server got a client");

		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		String[] data = dataInputStream.readUTF().split(":");

		if (data[0].equals("isPalindrome")) {
			System.out.println(data[1]);
			result = isPalindrome(data[1]);
		} else if (data[0].equals("findSum")) {
			result = findSum(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
		}

		OutputStream output = socket.getOutputStream();
		DataOutputStream dot = new DataOutputStream(output);
		dot.writeUTF("Result is: " + result);

		dot.close();
		output.close();
		socket.close();

	}

	private static int isPalindrome(String s) {
		int x = 0;
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) == s.charAt(s.length() - i-1)) {
				x = 1;
			} else {
				x = 0;
			}
		}
		return x;
	}

	private static int findSum(int a, int b) {
		return a + b;
	}
}
