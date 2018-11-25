
public class Time {
	private int hour, min, sec;

	// the time is initially started from 8:55 am. Because that way
	// we can supervise the whole process from beginning to end.
	public Time() {
		hour = 8;
		min = 55;
		sec = 0;
	}

	// secPlus is increasing the second value, and controls the time.
	public void secPlus() {
		sec++;
		timeControl();

	}

	// the time control method makes sure that there's not any time like
	// 9:60:60.
	private void timeControl() {
		if (sec >= 60) {
			min++;
			sec = sec % 60;
		}

		if (min >= 60) {
			hour++;
			min = min % 60;
		}
	}

	public Time increase(int x) {
		sec += x;
		timeControl();
		return this;
	}

	public int getH() {
		return hour;
	}

	public int getM() {
		return min;
	}

	public int getS() {
		return sec;
	}
}
