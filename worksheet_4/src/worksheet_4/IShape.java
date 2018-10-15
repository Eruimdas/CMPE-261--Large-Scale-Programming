package worksheet_4;

import java.awt.Graphics;

public interface IShape {

	public void drawShape(Graphics g);
	public double area();
	public double distance(Point p);
	public void move();
	
	

}
