import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Supermarket {
	static Timer timer = new Timer();
	private static ArrayList<Cashier> mycash = new ArrayList<Cashier>();

	// In Supermarket class, the program is initialized, the product list is
	// created,
	// CustomerProducer and 3 cashiers are initialized and given the proper time
	// After that, the method is waiting until time is 9, for necessary preparation
	// has done after that the supermarket is opened and cashiers starts to work,
	// and customer starts
	// to enter the market. The while loop makes sure that the market stays open
	// until there's someone at the cashiers queue, and after the market finally
	// closes, it prints out the average
	// waiting time for randomly selected queues and calculation based selected
	// queues average waiting time, then closes the market.

	public static void main(String[] args) throws FileNotFoundException {
		timer.start();
		System.out.println(timer.humanTime());
		ProductList p = new ProductList();
		System.out.println(timer.humanTime());
		Cashier cs1 = new Cashier(timer);
		Cashier cs2 = new Cashier(timer);
		Cashier cs3 = new Cashier(timer);
		cs1.setName("1");
		cs2.setName("2");
		cs3.setName("3");
		mycash.add(cs1);
		mycash.add(cs2);
		mycash.add(cs3);
		CustomerProducer clist = new CustomerProducer(timer, p, mycash);
		clist.start();
		while (timer.getTime().getH() < 9) {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		cs1.start();
		cs2.start();
		cs3.start();

		System.out.println(timer.humanTime());
		while (timer.getTime().getH() < 17 || !cs1.thequeue.isEmpty() || !cs2.thequeue.isEmpty()
				|| !cs3.thequeue.isEmpty()) {
			try {
				TimeUnit.MILLISECONDS.sleep(10);
				cs1.run();
				cs2.run();
				cs3.run();
			} catch (InterruptedException e) {
				System.out.println("error in main");
			}
		}
		// to check if the queues is really empty.
		// cs1.printQueue();
		// cs2.printQueue();
		// cs3.printQueue();
		System.out.println("|-----0-----0-----0-----|");
		System.out.print("Random waiting time is: ");
		timer.calcAveRan();
		System.out.println("");
		System.out.print("Calculated waiting time is: ");
		timer.calcAveCalc();
		System.out.println("");
		System.out.println("Market is now closed.");
		System.exit(1);
	}
}
