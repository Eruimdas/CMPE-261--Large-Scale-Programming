package worksheet_5;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

// Hasan Kemik 116207076 CMPE 261 
public class worksheet5_cmpe261 extends JFrame implements KeyListener, ActionListener {

	private JPanel pnlOne, pnlTwo;
	private JTabbedPane myTab;
	private JMenu myProgram, myHelp;
	private JMenuBar myMenuBar;
	private JMenuItem itmNewCircle, itmHelp, itmExit, itmAbout;
	private Circle myCircle;
	private JButton buttonp, buttonm;
	private JLabel circler, circlex, circley, circlecolor;

	public worksheet5_cmpe261() {
		myTab = new JTabbedPane();

		pnlOne = new JPanel() {
			public void paint(Graphics g) {
				super.paint(g);
				myCircle.drawShape(g);
			}
		};

		pnlTwo = new JPanel(new GridLayout(4, 1));

		myCircle = new Circle();

		buttonp = new JButton("+");
		buttonm = new JButton("-");

		circler = new JLabel();
		circlex = new JLabel();
		circley = new JLabel();
		circlecolor = new JLabel();

		myProgram = new JMenu("Program");
		myHelp = new JMenu("Help");

		myMenuBar = new JMenuBar();

		itmNewCircle = new JMenuItem("New Circle");
		itmExit = new JMenuItem("Exit");
		itmHelp = new JMenuItem("Help");
		itmAbout = new JMenuItem("About");

		myProgram.add(itmNewCircle);
		myProgram.add(itmExit);

		myHelp.add(itmAbout);
		myHelp.add(itmHelp);

		myMenuBar.add(myProgram);
		myMenuBar.add(myHelp);

		setJMenuBar(myMenuBar);

		itmNewCircle.addActionListener(this);
		itmExit.addActionListener(this);
		itmHelp.addActionListener(this);
		itmAbout.addActionListener(this);

		pnlOne.add(buttonp);
		pnlOne.add(buttonm);

		pnlTwo.add(circlex);
		pnlTwo.add(circley);
		pnlTwo.add(circler);
		pnlTwo.add(circlecolor);

		updateCircleInfo();

		buttonp.addActionListener(this);
		buttonm.addActionListener(this);
		buttonp.addKeyListener(this);
		buttonm.addKeyListener(this);

		myTab.add("Drawing", pnlOne);
		myTab.add("Values", pnlTwo);

		add(myTab);
		addKeyListener(this);
		setFocusable(true);
		pnlOne.addKeyListener(this);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new worksheet5_cmpe261();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			myCircle.moveY(-25);

		}

		else if (key == KeyEvent.VK_S) {
			myCircle.moveY(25);
		}

		else if (key == KeyEvent.VK_A) {
			myCircle.moveX(-25);
		} else if (key == KeyEvent.VK_D) {
			myCircle.moveX(25);
		}
//		System.out.println("Key Listener");
		updateCircleInfo();
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(buttonm)) {
			myCircle.changeR(-10);
		} else if (e.getSource().equals(buttonp)) {
			myCircle.changeR(10);
		} else if (e.getSource().equals(itmNewCircle)) {
			myCircle = new Circle();
		} else if (e.getSource().equals(itmExit)) {
			Object[] option = { "Exit", "Cancel" };
			int flag = JOptionPane.showOptionDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
			if (flag == 0) {
				System.exit(0);
			}
		} else if (e.getSource().equals(itmHelp)) {
			JOptionPane.showMessageDialog(null,
					"In the program section if you click new circle a new circle will be created. If you\n click exit a popup windows will be shown.",
					"Help", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource().equals(itmAbout)) {
			JOptionPane.showMessageDialog(null, "This program is written by Hasan Kemik", "About",
					JOptionPane.INFORMATION_MESSAGE);
		}
		updateCircleInfo();
		repaint();

	}

	public void updateCircleInfo() {
		circlex.setText("The circle x value is :" + myCircle.getX());
		circley.setText("The circle y value is :" + myCircle.getY());
		circler.setText("The circle r value is :" + myCircle.getR());
		circlecolor.setText("The circle's color is: " + myCircle.getColor());
	}
}
