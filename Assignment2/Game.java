import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/*	The game generally working around if blocks and boolean controllers,
 *  the controllers made the decision whether ball's moving position as random,
 *  or is the ball interacts with users or the wall.
 * 	
 * 	The game ends if a user points 7 scores, such as real life games. 
 * 	The scoreboards have name labels of the users, and the color of them is
 * 	same as the users boards which decided random in UserBlock class, 
 * 	also every balls color is randomized.
 */

// Hasan Kemik CMPE 261 Assignment 2 116207076
public class Game extends JFrame implements ActionListener, KeyListener {

	private Timer timer;
	private JButton bstart, bpause, bstop;
	private JTextField p1score, p2score;
	private JLabel label1, label2;
	private Random ran = new Random();
	private JPanel panel1;
	private Ball ball;
	private UserBlock player1, player2;
	private int ballmovex, ballmovey;
	private boolean checkcollision1, checkcollision2;
	private static String user1, user2;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (timer.isRunning()) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_W) {
				if (player1.getY() > 139)
					movePlayer1(-50);
//			repaint();
//				System.out.println("KeW");
			} else if (key == KeyEvent.VK_S) {
				if (player1.getY() < 400)
					movePlayer1(50);
//			repaint();
//				System.out.println("KeS");
			} else if (key == KeyEvent.VK_UP) {
				if (player2.getY() > 139)
					movePlayer2(-50);
//			repaint();
//				System.out.println("KeUp");
			} else if (key == KeyEvent.VK_DOWN) {
				if (player2.getY() < 400)
					movePlayer2(50);
//			repaint();
//				System.out.println("KeDown");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Starting the timer, and moving the ball
		if (e.getSource().equals(bstart)) {
			timer.start();
			ballmovex = 0;
			ballmovey = 0;
			// while loop makes sure of the ball is moving with a rate that eyes can see.
			while (ballmovex > -5 && ballmovex < 5) {
				ballmovex = -60 + ran.nextInt(121);
				ballmovey = -60 + ran.nextInt(121);
			}
			p1score.setText("00");
			p2score.setText("00");
//			System.out.println("Timer has started.");
		} else if (e.getSource().equals(bpause)) {
			if (timer.isRunning()) {
				timer.stop();
			} else {
				timer.start();
			}
//			System.out.println("Timer has paused.");
		} else if (e.getSource().equals(bstop)) {
			timer.stop();
			ball = new Ball();
		}
		moveBall();
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		player1.drawShape(g);
		player2.drawShape(g);
		ball.drawShape(g);
	}

	public Game() {
		// Initializing the objects, setting sizes and placing them.
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(600, 500);
		setLayout(new BorderLayout());

		timer = new Timer(400, this);

		ball = new Ball();
		player1 = new UserBlock(0, 100);
		player2 = new UserBlock(550, 100);

		panel1 = new JPanel(null);
		panel1.setSize(600, 100);

		bstart = new JButton();
		bpause = new JButton();
		bstop = new JButton();

		bpause.setSize(100, 50);
		bpause.setText("Pause");
		bpause.setLocation(110, 15);
		bpause.addActionListener(this);

		bstart.setSize(100, 50);
		bstart.setText("Start");
		bstart.setLocation(260, 15);
		bstart.addActionListener(this);

		bstop.setSize(100, 50);
		bstop.setText("Stop");
		bstop.setLocation(410, 15);
		bstop.addActionListener(this);

		p1score = new JTextField("00");
		p2score = new JTextField("00");

		p1score.setEditable(false);
		p2score.setEditable(false);

		p1score.setForeground(player1.getColor());
		p2score.setForeground(player2.getColor());

		p1score.setSize(30, 40);
		p2score.setSize(30, 40);

		p1score.setLocation(10, 15);
		p2score.setLocation(560, 15);

		label1 = new JLabel(user1);
		label2 = new JLabel(user2);

		label1.setSize(50, 30);
		label1.setForeground(player1.getColor());
		label1.setLocation(40, 15);

		label2.setSize(50, 30);
		label2.setForeground(player2.getColor());
		label2.setLocation(510, 15);

		panel1.add(bpause);
		panel1.add(bstart);
		panel1.add(bstop);
		panel1.add(p1score);
		panel1.add(p2score);
		panel1.add(label1);
		panel1.add(label2);
		panel1.setPreferredSize(new Dimension(600, 100));

		panel1.setVisible(true);

		checkcollision1 = false;
		checkcollision2 = false;

		bstart.addKeyListener(this);
		bpause.addKeyListener(this);
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		add(panel1, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// showing the message dialogs for users and initializing the game.
		JOptionPane.showMessageDialog(null,
				"You're about the play my game 'Ping Pong'. First you need to enter 2 user names, \nand then you need to press start button to start, and press pause button for \ncontinuing after a score. The game will end when a user scores 7 points.",
				"Ping Pong Info", JOptionPane.INFORMATION_MESSAGE);
		user1 = JOptionPane.showInputDialog("Enter the name of user1: ");
		user2 = JOptionPane.showInputDialog("Enter the name of user2: ");
//		System.out.println(user1 + " ... " + user2);
		new Game();
	}

	public void moveBall() {
		// Checking the score board for finishing game or starting it,
		if (Integer.parseInt(p2score.getText()) != 2 && Integer.parseInt(p1score.getText()) != 7) {
			// setting the balls move area
			if ((ball.getX() < 550 && ball.getX() > 0))
				ball.moveX(ballmovex);
			if ((ball.getY() < 450 && ball.getY() > 70))
				ball.moveY(ballmovey);

			if (ball.getY() < 100) {
				ballmovey = ran.nextInt(15) + 10;
//			System.out.println("Y changed: " + ball.getY());
				ball.moveY(ballmovey);
			}
			if (ball.getY() > 440) {
				ballmovey = -60 + ran.nextInt(15);
//			System.out.println("Y changed: " + ball.getY());
				ball.moveY(ballmovey);
			}
			// checking if there's a collision between the user 1 and the ball
			if (checkcollision1) {
				ballmovex = ran.nextInt(15) + 30;
//			System.out.println("X changed: " + ball.getX());
				ball.moveX(ballmovex);
				checkcollision1 = false;
			} else {
				if (ball.getX() < 0) {
					p2score.setText(Integer.toString((Integer.parseInt(p2score.getText()) + 1)));
					ball = new Ball();
					timer.stop();
					ballmovex = 0;
					ballmovey = 0;
					while (ballmovex > -5 && ballmovex < 5) {
						ballmovex = -60 + ran.nextInt(121);
						ballmovey = -60 + ran.nextInt(121);
					}
					String s = user2 + " has scored. Press pause to continue.";
					JOptionPane.showMessageDialog(rootPane, s, "P1 Scored!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			checkCollision(player1.getY(), player2.getY());
			// checking if there's a collision between the user 2 and the ball
			if (checkcollision2) {
				ballmovex = -40 + ran.nextInt(15);
//			System.out.println("X changed: " + ball.getX());
				ball.moveX(ballmovex);
				checkcollision2 = false;
			} else {
				// Saying that, if there's no collision and the ball passes through the
				// userblock1, the game will count it as a score.And the point will be
				// increased.
				if (ball.getX() > 545) {
					p1score.setText(Integer.toString((Integer.parseInt(p1score.getText()) + 1)));
					ball = new Ball();
					timer.stop();
					ballmovex = 0;
					ballmovey = 0;
					while (ballmovex > -5 && ballmovex < 5) {
						ballmovex = -30 + ran.nextInt(61);
						ballmovey = -30 + ran.nextInt(61);
					}
					String s = user1 + " has scored. Press pause to continue.";
					JOptionPane.showMessageDialog(rootPane, s, "P1 Scored!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else {
			// In here, saying that if there's no collision and the ball passes through the
			// userblock 2, the game will count it as a score. And the point will be
			// increased.
			if (Integer.parseInt(p1score.getText()) < Integer.parseInt(p2score.getText())) {
				timer.stop();
				String s1 = user2 + " has won the game.";
				JOptionPane.showMessageDialog(rootPane, s1, "Game Ended!", JOptionPane.INFORMATION_MESSAGE);
				p1score.setText("00");
				p2score.setText("00");
				player1.setY(100);
				player2.setY(100);
				ball = new Ball();
			} else if (Integer.parseInt(p1score.getText()) > Integer.parseInt(p2score.getText())) {
				timer.stop();
				String s1 = user1 + " has won the game.";
				JOptionPane.showMessageDialog(rootPane, s1, "Game Ended!", JOptionPane.INFORMATION_MESSAGE);
				p1score.setText("00");
				p2score.setText("00");
				player1.setY(100);
				player2.setY(100);
				ball = new Ball();
			}
		}
//		System.out.println("X speed: " + ballmovex);
//		System.out.println("Y speed: " + ballmovey);
	}

	public void checkCollision(int user1y, int user2y) {
		// Checkcollision makes sure of that, if the ball hits the player's moved
		// userblock.
		if (ball.getX() < 60 && (player1touch(ball.getY()))) {
			checkcollision1 = true;
//			System.out.println("Checkcollision1");
		}
		if (ball.getX() > 510 && (player2touch(ball.getY()))) {
			checkcollision2 = true;
//			System.out.println("Checkcollision2");
		}
	}

	public boolean player1touch(int bally) {
		// player1touch is controlling if the ball's y intersects with the userblock
		if (bally > player1.getY() && bally < (player1.getY() + player1.getH()) && ball.getX() < 150) {
//			System.out.println("Player 1 touched.");
			return true;
		} else {
			return false;
		}
	}

	public boolean player2touch(int bally) {
		// same as the player1touch method.
		if (bally > player2.getY() && bally < (player2.getY() + player2.getH()) && ball.getX() > 450) {
//			System.out.println("Player 2 touched.");
			return true;
		} else {
			return false;
		}
	}

	public void movePlayer1(int a) {
		player1.moveY(a);
	}

	public void movePlayer2(int a) {
		player2.moveY(a);
	}

}
