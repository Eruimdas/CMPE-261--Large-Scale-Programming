import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	Random ran = new Random();
	private int r;
	private int xax, yax;
	private Color c;

	public Ball() {
		r = 50;
		c = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		xax = 250;
		yax = 250;
	}

	public void drawShape(Graphics g) {
		g.setColor(c);
		g.fillOval(xax, yax, r, r);
	}

	public void moveX(int x) {
		xax += x;
	}

	public void moveY(int y) {
		yax += y;
	}

	public int getX() {
		return xax;
	}

	public int getY() {
		return yax;
	}
}
