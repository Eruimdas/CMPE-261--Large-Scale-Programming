package worksheet_5;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	Random ran = new Random();
	private int r;
	private int xax, yax;
	private Color c;

	public Circle() {
		r = 50;
		c = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		xax = ran.nextInt(200) + 100;
		yax = ran.nextInt(200) + 100;
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

	public int getR() {
		return r;
	}

	public Color getColor() {
		return c;
	}

	public void changeR(int x) {
		r += x;
	}
}
