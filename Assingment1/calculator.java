import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Hasan Kemik CMPE 261 Assingment 1 116207076
public class calculator {
	// creating panels, frame and buttons for calculator.
	// panels used for splitting the desired view into 2 parts.
	// in the frame, the panels are fitted in one window.
	private static JPanel mypanel = new JPanel();
	private static JPanel mypanel2 = new JPanel();
	private static JButton button1 = new JButton("1");
	private static JButton button2 = new JButton("2");
	private static JButton button3 = new JButton("3");
	private static JButton button4 = new JButton("+");
	private static JButton button5 = new JButton("4");
	private static JButton button6 = new JButton("5");
	private static JButton button7 = new JButton("6");
	private static JButton button8 = new JButton("-");
	private static JButton button9 = new JButton("7");
	private static JButton button10 = new JButton("8");
	private static JButton button11 = new JButton("9");
	private static JButton button12 = new JButton("*");
	private static JButton button13 = new JButton("Calculate");
	private static JButton button14 = new JButton("0");
	private static JButton button15 = new JButton("Clear");
	private static JButton button16 = new JButton("/");
	private static JTextField textfield = new JTextField();
	private static JFrame myframe = new JFrame();
	// the string value "reading" is initialized in order to read
	// the values from the text field and apply operations on it.
	private static String reading = "";

	public static void main(String[] args) {
		// added action listeners on all of the buttons as desired operation occures.
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "1";
				textfield.setText(reading);
			}
		});

		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "2";
				textfield.setText(reading);
			}
		});

		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "3";
				textfield.setText(reading);
			}
		});

		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + " + ";
				textfield.setText(reading);
			}
		});

		button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "4";
				textfield.setText(reading);
			}
		});

		button6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "5";
				textfield.setText(reading);
			}
		});

		button7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "6";
				textfield.setText(reading);
			}
		});

		button8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + " - ";
				textfield.setText(reading);
			}
		});

		button9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "7";
				textfield.setText(reading);
			}
		});

		button10.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "8";
				textfield.setText(reading);
			}
		});

		button11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "9";
				textfield.setText(reading);
			}
		});

		button12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + " * ";
				textfield.setText(reading);
			}
		});

		button13.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText();
				calculate(reading);
			}
		});

		button14.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + "0";
				textfield.setText(reading);
			}
		});

		button15.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textfield.setText("");
			}
		});

		button16.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reading = textfield.getText() + " / ";
				textfield.setText(reading);
			}
		});
		// frame layout and the size is initialized.
		myframe.setSize(400, 600);
		myframe.setLayout(new BorderLayout());
		// calculator's main body, buttons are initialized and placed onto the panel.
		mypanel.setLayout(new GridLayout(4, 4));
		mypanel.add(button1);
		mypanel.add(button2);
		mypanel.add(button3);
		mypanel.add(button4);
		mypanel.add(button5);
		mypanel.add(button6);
		mypanel.add(button7);
		mypanel.add(button8);
		mypanel.add(button9);
		mypanel.add(button10);
		mypanel.add(button11);
		mypanel.add(button12);
		mypanel.add(button13);
		mypanel.add(button14);
		mypanel.add(button15);
		mypanel.add(button16);
		// calculator's text field which will work as a screen is initialized and placed
		// onto another panel.
		mypanel2.setLayout(new BorderLayout());
		textfield.setSize(200, 100);
		mypanel2.add(textfield, BorderLayout.CENTER);
		// panels are placed onto a frame for calculator layout.
		myframe.add(mypanel, BorderLayout.CENTER);
		myframe.add(mypanel2, BorderLayout.NORTH);
		// frame is set to visible.
		myframe.setVisible(true);
	}

	// in calculate method, the program understands how many operators and number
	// are given in the text field
	private static void calculate(String s) {
		int result = 0;
		// in the actionlistener's program concatenates the strings in a way that can be
		// split.
		// the split mechanism is hidden in the operators such as having one blank
		// character after and before the operator.
		String[] operation = s.split(" ");
		for (int i = 0; i < operation.length / 2; i++) {
			int k = (2 * i) + 1;
			if (k == 1) {
				result += calculatehelper(operation[k - 1], operation[k + 1], operation[k]);
			} else {
				result = calculatehelper(Integer.toString(result), operation[k + 1], operation[k]);
			}
		}
		textfield.setText(Integer.toString(result));
	}

	// and in calculatehelper method, the program makes the asked operation in the
	// way it's given. Mathematical expressions are not considered such as operation
	// priority.
	private static int calculatehelper(String s1, String s2, String op) {
		if (op.equals("+")) {
			return Integer.parseInt(s1) + Integer.parseInt(s2);
		} else if (op.equals("-")) {
			return Integer.parseInt(s1) - Integer.parseInt(s2);
		} else if (op.equals("/")) {
			return Integer.parseInt(s1) / Integer.parseInt(s2);
		} else if (op.equals("*")) {
			return Integer.parseInt(s1) * Integer.parseInt(s2);
		} else {
			return 0;
		}
	}

}
