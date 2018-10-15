package worksheet_4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// Hasan Kemik 116207076 CMPE 261 Worksheet 4

public class worksheet_4_cmpe_261 {

	private static Random ran;
	private static JFrame myframe = new JFrame();
	private static JPanel mypanel = new JPanel();
	private static JPanel mypanel2 = new JPanel();
	private static JButton button1 = new JButton();
	private static JButton button2 = new JButton();
	private static JButton button3 = new JButton();
	private static int speed = 3;
	private static Circle[] shapes;
	private static Timer timer;

	public static void main(String[] args) {

		myframe.setSize(500, 500);
		myframe.setLayout(new BorderLayout());
		int count = Integer.parseInt(JOptionPane.showInputDialog("How many shapes do you want?", "Input"));

		mypanel.setLayout(new FlowLayout());

		button1.setText("Faster");
		button2.setText("Start");
		button3.setText("Slower");

		button1.setSize(75, 50);
		button2.setSize(75, 50);
		button3.setSize(75, 50);

		mypanel.add(button1);
		mypanel.add(button2);
		mypanel.add(button3);
		timer = new Timer(250, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mymove(shapes, speed);
				mypanel2.repaint();
			}

		});
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (speed > 1)
					speed++;
			}

		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shapes = new Circle[count];
				for (int i = 0; i < count; i++) {
					ran = new Random();
					int x = ran.nextInt(2);
					if (x == 0) {
						shapes[i] = new Circle(75);
					} else {
						shapes[i] = new Circle(375);
					}

				}

				mypanel2 = new JPanel() {

					public void paint(Graphics g) {
						super.paint(g);
						for (int i = 0; i < count; i++) {
							shapes[i].drawShape(g);
						}
					}

				};
				mypanel2.setSize(400, 400);
				mypanel2.setVisible(true);
				myframe.add(mypanel2, BorderLayout.CENTER);
//				System.out.println("hhh");
				timer.start();
				mypanel2.repaint();
			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (speed > 1)
					speed--;
			}

		});

		myframe.add(mypanel, BorderLayout.NORTH);

		myframe.setVisible(true);
	}

	public static void mymove(Circle[] shapes, int speed) {
		for (int i = 0; i < shapes.length; i++) {
			moveHelper(shapes[i], speed);
			System.out.println("mymove1");
		}
	}

	public static void moveHelper(Circle shape, int speed) {
		if (shape.getX() > 250) {
			shape.setPointX(shape.getX() - 1 * speed);
		}
		if (shape.getY() > 250) {
			shape.setPointY(shape.getY() - 1 * speed);
		}
		if (shape.getX() < 250) {
			shape.setPointX(shape.getX() + 1 * speed);
		}
		if (shape.getY() < 250) {
			shape.setPointY(shape.getY() + 1 * speed);
		}
		System.out.println("mymovehelper");

	}

}
