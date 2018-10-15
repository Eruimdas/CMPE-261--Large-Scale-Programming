package worksheet_3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// Hasan Kemik 116207076 Cmpe 261

public class worksheet_3_cmpe261 {

	private static JFrame myframe = new JFrame();
	private static JButton button1 = new JButton();
	private static JButton button2 = new JButton();
	private static JButton button3 = new JButton();
	private static JButton button4 = new JButton();
	private static JButton button5 = new JButton();
	private static JButton button6 = new JButton();
	private static JButton button7 = new JButton();
	private static JButton button8 = new JButton();
	private static JButton button9 = new JButton();
	private static JLabel label1 = new JLabel();
	private static JLabel label2 = new JLabel();
	private static JLabel label3 = new JLabel();
	private static JLabel label4 = new JLabel();
	private static JTextField tfield1 = new JTextField();
	private static JTextField tfield2 = new JTextField();
	private static JTextField tfield3 = new JTextField();
	private static JCheckBox check1 = new JCheckBox();
	private static JCheckBox check2 = new JCheckBox();
	private static JRadioButton radio1 = new JRadioButton();
	private static JRadioButton radio2 = new JRadioButton();
	private static JRadioButton radio3 = new JRadioButton();
	private static int result;

	public static void main(String[] args) {
		result = 0;
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radio1.isSelected()) {
					tfield1.setText(Integer.toString(Integer.parseInt(tfield1.getText()) + 1));
				}
			}

		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radio1.isSelected()) {
					tfield1.setText(Integer.toString(Integer.parseInt(tfield1.getText()) - 1));
				}

			}

		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radio2.isSelected()) {
					tfield2.setText(Integer.toString(Integer.parseInt(tfield2.getText()) + 1));
				}
			}

		});

		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radio2.isSelected()) {
					tfield2.setText(Integer.toString(Integer.parseInt(tfield2.getText()) - 1));
				}
			}

		});

		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radio3.isSelected()) {
					tfield3.setText(Integer.toString(Integer.parseInt(tfield3.getText()) + 1));
				}
			}

		});

		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radio3.isSelected()) {
					tfield3.setText(Integer.toString(Integer.parseInt(tfield3.getText()) - 1));
				}
			}

		});

		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radio1.isSelected()) {
					if (check1.isSelected() && check2.isSelected()) {
						int st = Integer.parseInt(tfield1.getText());

						result += (st * 30);
					} else if (check1.isSelected() || check2.isSelected()) {
						int st = Integer.parseInt(tfield1.getText());

						result += (st * 25);
					} else {
						int st = Integer.parseInt(tfield1.getText());

						result += (st * 20);
					}

				}
				if (radio2.isSelected()) {
					if (check1.isSelected() && check2.isSelected()) {
						int ord = Integer.parseInt(tfield2.getText());

						result += (ord * 40);
					} else if (check1.isSelected() || check2.isSelected()) {

						int ord = Integer.parseInt(tfield2.getText());

						result += (ord * 35);
					} else {

						int ord = Integer.parseInt(tfield2.getText());

						result += (ord * 30);
					}

				}

				if (radio3.isSelected()) {
					if (check1.isSelected() && check2.isSelected()) {
						int sen = Integer.parseInt(tfield3.getText());

						result += (sen * 25);
					} else if (check1.isSelected() || check2.isSelected()) {
						int sen = Integer.parseInt(tfield3.getText());

						result += (sen * 20);
					} else {
						int sen = Integer.parseInt(tfield3.getText());

						result += (sen * 15);
					}

				}

				if (result != 0) {

					label4.setText("Total income is " + Integer.toString(result) + " Turkish Lira.");
					result = 0;
				} else {
					label4.setText("Total income will be displayed here.");
					result = 0;
				}
			}

		});

		button8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfield1.setText("0");
				tfield2.setText("0");
				tfield3.setText("0");
				radio1.setSelected(false);
				radio2.setSelected(false);
				radio3.setSelected(false);
				check1.setSelected(false);
				check2.setSelected(false);
				result = 0;
				label4.setText("Total income will be displayed here.");

			}

		});

		button9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});

		myframe.setSize(500, 250);
		myframe.setLayout(null);

		tfield1.setSize(30, 25);
		tfield2.setSize(30, 25);
		tfield3.setSize(30, 25);

		tfield1.setText("0");
		tfield2.setText("0");
		tfield3.setText("0");

		tfield1.setEditable(false);
		tfield2.setEditable(false);
		tfield3.setEditable(false);

		tfield1.setLocation(125, 90);
		tfield2.setLocation(290, 90);
		tfield3.setLocation(425, 90);

		radio1.setText("Student");
		radio2.setText("Ordinary");
		radio3.setText("Senior");

		radio1.setSize(100, 50);
		radio2.setSize(100, 50);
		radio3.setSize(75, 50);

		radio1.setLocation(50, 75);
		radio2.setLocation(200, 75);
		radio3.setLocation(350, 75);

		check1.setText("3D");
		check2.setText("IMAX");
		check1.setSize(50, 50);
		check2.setSize(75, 50);
		check1.setLocation(0, 130);
		check2.setLocation(125, 130);

		label1.setText("Student: 20₺");
		label1.setForeground(Color.red);
		label1.setSize(100, 50);
		label1.setLocation(25, 5);

		label2.setText("Ordinary: 30₺");
		label2.setForeground(Color.blue);
		label2.setSize(100, 50);
		label2.setLocation(150, 5);

		label3.setText("Senior: 15₺");
		label3.setForeground(Color.green);
		label3.setSize(100, 50);
		label3.setLocation(290, 5);

		label4.setText("Total income will be displayed here.");
		label4.setSize(400, 50);
		label4.setLocation(125, 175);

		button1.setText("+");
		button2.setText("-");
		button3.setText("+");
		button4.setText("-");
		button5.setText("+");
		button6.setText("-");
		button7.setText("Calculate");
		button8.setText("Reset");
		button9.setText("Exit");

		button1.setSize(25, 25);
		button2.setSize(25, 25);
		button3.setSize(25, 25);
		button4.setSize(25, 25);
		button5.setSize(25, 25);
		button6.setSize(25, 25);
		button7.setSize(100, 25);
		button8.setSize(100, 25);
		button9.setSize(75, 25);

		button1.setLocation(25, 75);
		button2.setLocation(25, 95);
		button3.setLocation(170, 75);
		button4.setLocation(170, 95);
		button5.setLocation(320, 75);
		button6.setLocation(320, 95);
		button7.setLocation(250, 140);
		button8.setLocation(350, 140);
		button9.setLocation(375, 25);

		myframe.add(label1);
		myframe.add(label2);
		myframe.add(label3);
		myframe.add(label4);
		myframe.add(button1);
		myframe.add(button2);
		myframe.add(button3);
		myframe.add(button4);
		myframe.add(button5);
		myframe.add(button6);
		myframe.add(button7);
		myframe.add(button8);
		myframe.add(button9);
		myframe.add(check1);
		myframe.add(check2);
		myframe.add(radio1);
		myframe.add(radio2);
		myframe.add(radio3);
		myframe.add(tfield1);
		myframe.add(tfield2);
		myframe.add(tfield3);

		myframe.setVisible(true);

	}
}
