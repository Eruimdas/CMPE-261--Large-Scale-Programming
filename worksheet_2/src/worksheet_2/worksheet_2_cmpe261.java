package worksheet_2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;

// Hasan Kemik 116207076 Ws2 of CMPE 261
public class worksheet_2_cmpe261 {

	private static JFrame myframe = new JFrame();
	private static JTextField textfield1 = new JTextField();
	private static JTextField textfield2 = new JTextField();
	private static JButton button = new JButton();

	public static void main(String[] args) {
		button.setText("Convert");
		textfield2.setEditable(false);

		Object[] option = { "Grid Layout", "Border Layout" };
		int flag = JOptionPane.showOptionDialog(null, "Select a layout", "Select a layout", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (flag == 1) {
			myframe.setLayout(new BorderLayout());
			myframe.setSize(150, 150);
			myframe.add(textfield1, BorderLayout.NORTH);
			myframe.add(button, BorderLayout.CENTER);
			myframe.add(textfield2, BorderLayout.SOUTH);

			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String reading = textfield1.getText();
					textfield2.setText(Integer.toBinaryString(Integer.parseInt(reading)));
				}
			});

			myframe.setVisible(true);
		} else if (flag == 0) {
			myframe.setLayout(new GridLayout(3, 1));
			myframe.setSize(150, 150);

			myframe.add(textfield1);
			myframe.add(textfield2);
			myframe.add(button);

			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String reading = textfield1.getText();
					textfield2.setText(Integer.toBinaryString(Integer.parseInt(reading)));
				}
			});

			myframe.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Please select an option", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
