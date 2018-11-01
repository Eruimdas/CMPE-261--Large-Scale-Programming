package worksheet_6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Hasan Kemik 116207076 Cmpe 261
public class worksheet6_cmpe261 extends JFrame implements Runnable, ActionListener {

	private JButton start;
	private JLabel tlabel1, tlabel2, timerlabel;
	private Thread thread1, thread2;
	private int timercount = 0;
	private int random1 = -1;
	private int random2 = -2;
	private Random rand = new Random();
	private boolean checkmessage;
	private String chars = "ABCDEFGHIJ";

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(start)) {
			thread1 = new Thread(this);
			thread2 = new Thread(this);
			thread1.start();
			thread2.start();
			System.out.println("Timer started.");
			checkmessage = true;
		}
	}

	@Override
	public void run() {
		while (checkequality()) {
			if (Thread.currentThread().equals(thread1)) {
				random1 = rand.nextInt(chars.length());
				tlabel1.setText(Character.toString(chars.charAt(random1)));
				try {
					thread1.sleep(1000);
				} catch (Exception e) {

				}
			} else if (Thread.currentThread().equals(thread2)) {
				random2 = rand.nextInt(chars.length());
				tlabel2.setText(Character.toString(chars.charAt(random2)));
				try {
					thread2.sleep(1000);
				} catch (Exception e) {

				}
				timercount++;
				timerlabel.setText(Integer.toString(timercount));
			}
		}
		if (!checkequality() && checkmessage) {
			if (Thread.currentThread().equals(thread1)) {
				JOptionPane.showMessageDialog(this, "The program has stopped!\n " + timercount + " seconds has passed.",
						"Finish", JOptionPane.INFORMATION_MESSAGE);
				checkmessage = false;
				thread1.stop();
				thread2.stop();
			}
		}

	}

	public worksheet6_cmpe261() {
		setSize(150, 150);
		setLayout(null);
		setTitle("Random");

		start = new JButton("Start");
		tlabel1 = new JLabel("A");
		tlabel2 = new JLabel("A");
		timerlabel = new JLabel("0");

		start.setSize(75, 30);
		tlabel1.setSize(75, 75);
		tlabel2.setSize(75, 75);
		timerlabel.setSize(75, 75);

		start.setLocation(35, 25);
		tlabel1.setLocation(25, 75);
		tlabel2.setLocation(125, 75);
		timerlabel.setLocation(75, 50);

		start.addActionListener(this);

		add(start);
		add(tlabel1);
		add(tlabel2);
		add(timerlabel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new worksheet6_cmpe261();
	}

	public boolean checkequality() {
		if (random1 == random2) {
			return false;
		} else {
			return true;
		}

	}

}
