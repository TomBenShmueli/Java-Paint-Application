import java.awt.Color;
import java.awt.Graphics;
/**
 * @author Tom Ben Shmueli 203525548
 *	MyRoundRectangle class. defines a round rectangle.
 *	The class can compare two round rectangles and create a new round rectangle object.
 */
public class MyRoundRectangle extends MyBoundShape {

	
	final private static int ARC_SIZE = 10; // arc size param
	
	/**
	 * class CTOR for the MyRectangle class.
	 * @param x1 - x1 coordinate value.
	 * @param x2 - x2 coordinate value.
	 * @param y1 - y1 coordinate value.
	 * @param y2 - y2 coordinate value.
	 * @param color - color line.
	 * @param isFilled - states if the color is filled or not.
	 * @return new MyRectangle object.
	 */
	public MyRoundRectangle(int x1, int x2, int y1, int y2, Color color,boolean isFilled)
	{
		this.setX1(x1); 
		this.setX2(x2);
		this.setY1(y1);
		this.setY2(y2);
		this.setColor(color);
		this.setFilled(isFilled);
	}

	public static int getArcSize()
	{
		return ARC_SIZE;
	}

	/**
	 * A method to calculate the rectangle's area.
	 * overrides the MyBoundShape abstract method. 
	 * @returns returns the rectangle's area.
	 */
	@Override
	protected double area() {
		return Math.abs(this.getX2()-this.getX1())*Math.abs(this.getY2()-this.getY1()); // a*b
	}

	/**
	 * draw implementation for the abstract draw(Graphics g) class.
	 * The method draws the shape.
	 * @param  g - to be provided by paintComponent(Graphics g) provided by JPanel.
	 */
	@Override
	protected void draw(Graphics g) {
		g.setColor(getColor());
		if(isFilled())
		{
			g.fillRoundRect(this.getX1(), this.getY1(), Math.abs(this.getX2()-this.getX1()), Math.abs(this.getY2()-this.getY1()),ARC_SIZE,ARC_SIZE);
		}
		else g.drawRoundRect(this.getX1(), this.getY1(), Math.abs(this.getX2()-this.getX1()), Math.abs(this.getY2()-this.getY1()),ARC_SIZE,ARC_SIZE);		
	}
	
	/**
	 * equals override. Two rectangles are identical if they have the same area
	 * @param  obj - object to be compared.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyRectangle)
		{
			MyRectangle comparedObj = (MyRectangle)obj;
			return (Math.abs(this.getX2()-this.getX1()) == Math.abs(comparedObj.getX2()-comparedObj.getX1())) &&(Math.abs(this.getY2()-this.getY1()) == Math.abs(comparedObj.getY2()-comparedObj.getY1()));
		}
		return false;
	}

}
