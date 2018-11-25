package worksheet_7;

import java.util.concurrent.TimeUnit;

public class worksheet7_cmpe261 {

	private int pointer = 0;
	private int[] myint = new int[10];
	private addInt mystr;

	// Hasan Kemik 116207076 Cmpe 261 Worksheet 7
	public worksheet7_cmpe261() throws InterruptedException {
		addInt x = new addInt(pointer, myint);
		Producer p1 = new Producer(x);
		Producer p2 = new Producer(x);
		Consumer c1 = new Consumer(x);
		Consumer c2 = new Consumer(x);

		p1.setName("Producer1");
		p2.setName("Producer2");

		c1.setName("Consumer1");
		c2.setName("Consumer2");

		p1.start();
		TimeUnit.MICROSECONDS.sleep(100);
		p2.start();
		TimeUnit.MILLISECONDS.sleep(500);
		c1.start();
		TimeUnit.MILLISECONDS.sleep(500);
		c2.start();
	}

	public static void main(String[] args) throws InterruptedException {
		new worksheet7_cmpe261();

	}
}
