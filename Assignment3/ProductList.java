import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProductList {
	private File myfile;
	private int[] price, productId;
	private int pointer = 0;
	private int size = 0;
	// this class reads the supermarket's product list and prices.
	// and assigning it in two arrays.
	public ProductList() throws FileNotFoundException {
		myfile = new File("product_prices.txt");
		Scanner sc = new Scanner(myfile);
		System.out.println("Product list has begun");
		while (sc.hasNextLine()) {
			size++;
			sc.nextLine();
		}
		System.out.println("Size finished");
		sc = new Scanner(myfile);
		System.out.println("Array initializing is started.");
		price = new int[size];
		productId = new int[size];
		while (sc.hasNextLine()) {
			try {
				String[] x = sc.nextLine().replaceAll("[^\\d.]", " ").split(" ");
				productId[pointer] = Integer.parseInt(x[0]);
				price[pointer] = Integer.parseInt(x[3]);
				pointer++;
			} catch (Exception e) {

			}
		}
	}

	public int pri(int i) {
		return price[i];
	}

	public int Id(int i) {
		return productId[i];
	}
	// Method created to control the values.
	private void printArr(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
