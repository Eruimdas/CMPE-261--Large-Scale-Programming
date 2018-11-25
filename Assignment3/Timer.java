import java.util.ArrayList;

public class Timer extends Thread {
	private Time time = new Time();
	public ArrayList<Integer> queue1 = new ArrayList<Integer>();
	public ArrayList<Integer> queue2 = new ArrayList<Integer>();

	// Timer class is producing a time tick to a time class,
	// and using that time class, I'm able to simulate the whole 7 hour process
	// in seconds.
	public void Timer() {
	}

	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(3);
				time.secPlus();
				//System.out.println(humanTime());
			} catch (InterruptedException e) {
			}
		}

	}

	public Time getTime() {
		return time;
	}
	// returning a time which is easy to read for me.
	public String humanTime() {
		String mytime = "";
		mytime += time.getH() + ":" + time.getM() + ":" + time.getS();
		return mytime;
	}
	// these two methods adds time values to the array lists to calculate average.
	public void addTimeRandom(int x) {
		queue1.add(x);
	}

	public void addTimeCalc(int x) {
		queue2.add(x);
	}
	// calculating the average values.
	public void calcAveRan() {
		int time = 0;
		for (int i = 0; i < queue1.size(); i++) {
			time += queue1.get(i);
		}
		//System.out.println("Time is: " + time + " and the size is: " + queue1.size());
		time = (time / queue1.size());
		System.out.print("average time(in sec): " + time);
	}

	public void calcAveCalc() {
		int time = 0;
		for (int i = 0; i < queue2.size(); i++) {
			time += queue2.get(i);
		}
		//System.out.println("Time is: " + time + " and the size is: " + queue2.size());
		time = (time / queue2.size());
		System.out.print("average time(in sec): " + time);
	}
}
