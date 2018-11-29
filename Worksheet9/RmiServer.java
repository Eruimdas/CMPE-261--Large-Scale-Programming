import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {
	public static void main(String[] args) {
		try {

			RmiServerImplement server= new RmiServerImplement();
			RmiInterface share= (RmiInterface) UnicastRemoteObject.
					exportObject(server, 0);
			Registry reg= LocateRegistry.getRegistry();
			reg.bind("bilgi", share);
			RmiServerImplement s= new RmiServerImplement();
			System.out.println("RMI server is running...");

		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
