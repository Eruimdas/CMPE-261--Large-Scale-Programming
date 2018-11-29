import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  RmiInterface extends Remote {
	public boolean isPrime(int a) throws RemoteException;
  public int findAverage(int a, int b, int c) throws RemoteException;
}
