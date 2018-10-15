package worksheet_4;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;

public class Circle {
	private static int r;
	private Point p;
	private static Color c;
	private Random ran;
	private static int x;
	private static int y;

	public Circle(int y) {
		ran = new Random();
		p = new Point(ran.nextInt(255), y);
		c = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		r = ran.nextInt(30) + 10;

	}

	public void drawShape(Graphics g) {
		g.setColor(c);
		g.fillOval(p.getX(), p.getY(), r, r);
		System.out.println(p.getX());

	}

	public double area() {
		// TODO Auto-generated method stub
		return Math.PI * r * r;
	}

	public void move() {
		int k = p.getX();
		p.setX(k + 5);
		// y=y+5;
	}

	public  void setPointX(int x) {
		p.setX(x);
	}

	public  void setPointY(int y) {
		p.setY(y);
	}

	public  int getX() {
		return p.getX();
	}

	public void setX(int x) {
		this.x = x;
	}

	public  int getY() {
		return p.getY();
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public static Color getC() {
		return c;
	}

}