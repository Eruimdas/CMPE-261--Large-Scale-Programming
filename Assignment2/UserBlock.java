import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class UserBlock {
	Random ran = new Random();
	private int xax, yax;
	private int height, width;
	private Color c;

	public UserBlock(int x, int y) {
		xax = x;
		yax = y;
		height = 100;
		width = 50;
		c = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
	}

	public void drawShape(Graphics g) {
		g.setColor(c);
		g.fillRect(xax, yax, width, height);
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

	public int getH() {
		return height;
	}
	
	public Color getColor() {
		return c;
	}
	
	public void setY(int y) {
		yax = y;
	}

}
