import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
		Socket socket = new Socket(args[0], Integer.parseInt(args[1]));

		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		System.out.println("Client is connected to server");

		String s = args[2];

		if (s.equals("isPalindrome")) {
			dataOutputStream.writeUTF(args[2]+":"+args[3]);
		}
		else if (s.equals("findSum")) {
			dataOutputStream.writeUTF(args[2]+":"+args[3]+":"+args[4]);
		}

		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		String message = dataInputStream.readUTF();
		System.out.println(message);
		socket.close();

	}
}
