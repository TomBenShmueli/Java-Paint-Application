import java.awt.Color;
import java.awt.Graphics;
/**
 * @author Tom Ben Shmueli 203525548
 *	MyRectangle class. defines an oval.
 *	The class can compare two ovals and create a new oval object.
 */
public class MyOval extends MyBoundShape{

	/**
	 * class CTOR for the MyOval class.
	 * @param x1 - x1 coordinate value.
	 * @param x2 - x2 coordinate value.
	 * @param y1 - y1 coordinate value.
	 * @param y2 - y2 coordinate value.
	 * @param color - color line.
	 * @param isFilled - states if the color is filled or not.
	 * @return new myOval object.
	 */
	public MyOval(int x1, int x2, int y1, int y2, Color color,boolean isFilled)
	{
		this.setX1(x1); 
		this.setX2(x2);
		this.setY1(y1);
		this.setY2(y2);
		this.setColor(color);
		this.setFilled(isFilled);
	}
	
	/**
	 * A method to calculate the oval's area.
	 * overrides the MyBoundShape abstract method. 
	 * @returns returns the oval's area.
	 */
	@Override
	protected double area() {
		return Math.PI*(Math.abs(getX2()-getX1())/2)*(Math.abs(getY2()-getY1())/2); // a*b*PI
		
	}

	/**
	 * draw implementation for the abstract draw(Graphics g) class.
	 * The method draws the shape.
	 * @param Graphics g - to be provided by paintComponent(Graphics g) provided by JPanel.
	 */
	@Override
	protected void draw(Graphics g) {
		g.setColor(getColor());
		if (isFilled())
		{
			g.fillOval(getX1(), getY1(), Math.abs(getX2()-getX1()), Math.abs(getY2()-getY1()));
		}
		else g.drawOval(getX1(), getY1(), Math.abs(getX2()-getX1()), Math.abs(getY2()-getY1()));
	}
	
	/**
	 * equals override. Two ovals are identical if they have the same bordering rectangle area.
	 * @param Object obj - object to be compared.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyOval)
		{

			MyOval comparedObj = (MyOval)obj;
			return (Math.abs(this.getX2()-this.getX1()) == Math.abs(comparedObj.getX2()-comparedObj.getX1())) &&(Math.abs(this.getY2()-this.getY1()) == Math.abs(comparedObj.getY2()-comparedObj.getY1()));
		}
		return false;
	}
}
