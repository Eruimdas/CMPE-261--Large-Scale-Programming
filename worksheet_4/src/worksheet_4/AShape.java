package worksheet_4;

import java.awt.Graphics;

public  abstract class AShape implements IShape{

	@Override
	public abstract void drawShape(Graphics g);

	@Override
	public abstract double area();
	
	@Override
	public double distance(Point p) {
		// TODO Auto-generated method stub
		double result= Math.sqrt(p.getX()*p.getX()+
				p.getY()*p.getY());
		
		return result;
	}
	
	public abstract void move();
	
}
