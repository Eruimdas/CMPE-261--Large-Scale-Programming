import java.rmi.RemoteException;

public class RmiServerImplement implements RmiInterface{

	@Override
public boolean isPrime(int a) throws RemoteException {
	boolean flag = true;

	for (int i = 2; i < a; i++) {
		if (a % i == 0) {
			flag = false;
		}
	}

	return flag;
}

@Override
public int findAverage(int a, int b, int c) throws RemoteException {
	int[] arr = { a, b, c };
	int sum = 0;
	for (int i = 0; i < arr.length; i++) {
		sum += arr[i];
	}
	return (sum / arr.length);
}

}
