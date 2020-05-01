import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Tom Ben Shmueli 203525548
 *	MyLine class. defines a basic line.
 *	The class can compare two lines and create a new line object.
 */

public class MyLine extends MyShape{
	
	/**
	 * class CTOR for the MyLine class.
	 * @param x1 - x1 coordinate value.
	 * @param x2 - x2 coordinate value.
	 * @param y1 - y1 coordinate value.
	 * @param y2 - y2 coordinate value.
	 * @param color - color line.
	 * @return new MyLine object.
	 */
	public MyLine(int x1, int x2, int y1, int y2, Color color)
	{
		this.setX1(x1); 
		this.setX2(x2);
		this.setY1(y1);
		this.setY2(y2);
		this.setColor(color);
	}

	/**
	 * draw implementation for the abstract draw(Graphics g) class.
	 * The method draws the shape.
	 * @param Graphics g - to be provided by paintComponent(Graphics g) provided by JPanel.
	 */
	@Override
	protected void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());		
	}
	
	/**
	 * equals override. Two lines are identical if they have the same length.
	 * @param Object obj - object to be compared.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyLine)
		{
			return this.length() == ((MyLine)obj).length();
		}
		else return false;
	}
	
	/**
	 * A method to calculate the line's length. 
	 * @return double length line's length
	 */
	private double length()
	{
		return Math.sqrt(Math.pow((getX1()-getX2()),2) + Math.pow((getY1()-getY2()),2)); // line length formula
	}

}
