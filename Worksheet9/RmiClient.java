import java.lang.invoke.MethodHandles.Lookup;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {

	public static void main(String[] args) {
		try {


						Registry reg = LocateRegistry.getRegistry(args[0]);
						RmiInterface rmi = (RmiInterface) reg.lookup(args[1]);
						String s = args[2];
						if(s.equals("findAverage")){
							int average = rmi.findAverage(Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]));
							System.out.println("average: " + average);
						}
						else if(s.equals("isPrime")){

							boolean isPrime = rmi.isPrime(Integer.parseInt(args[3]));
							System.out.println("isPrime: "+ args[3]+ " "  + isPrime);
						}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
