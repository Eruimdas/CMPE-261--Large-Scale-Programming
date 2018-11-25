package worksheet_7;

import java.util.Random;

public class addInt {
	private Random rand;
	private int pointer;
	private int[] myarr;

	public addInt(int point, int[] arr) {
		pointer = point;
		myarr = arr;
		rand = new Random();
	}

	public void deleteMyInt(Consumer c) {

		if (pointer > 0 && pointer < 10) {
			try {
				myarr[pointer] = 0;
				if (pointer > 0)
					pointer--;
				System.out.printf("%s deletes last number. Array: %s", c.getName(), printArray(myarr));
			} catch (Exception e) {
			}

		} else if (pointer == 10) {
			myarr[pointer - 1] = 0;
			if (pointer > 0)
				pointer--;
			System.out.printf("%s deletes last number. Array: %s", c.getName(), printArray(myarr));
		} else {
			System.out.printf("The %s is now waiting. Pointer is: %d Array is: %s", c.getName(), pointer,
					printArray(myarr));

		}
	}

	public void addMyInt(Producer p) {
		if (pointer < 10) {
			try {
				int x = rand.nextInt(100) + 1;
				myarr[pointer] = x;
				pointer++;
				System.out.printf("%s adds: %d. The Array is: %s", p.getName(), x, printArray(myarr));
			} catch (Exception e) {

			}
		} else {
			System.out.printf("%s is now waiting. Pointer is: %d, Array is : %s", p.getName(), pointer,
					printArray(myarr));
		}
	}

	public String printArray(int[] myarr) {
		String s = "{";
		for (int i = 0; i < myarr.length; i++) {
			s += myarr[i] + ",";
		}
		s = s.substring(0, s.length() - 1);
		s += "}\n";
		return s;
	}
}
