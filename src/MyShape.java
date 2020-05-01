import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Tom Ben Shmueli 203525548
 *	MyShape abstract class. defines basic properties such as coordinates & color.
 *	The class provides access to the private properties with get/set methods and not by inheritance.
 */

public abstract class MyShape implements Cloneable{
	
	/*
	 * class variables
	 */
	private int x1; 
	private int x2;
	private int y1;
	private int y2;
	private Color color;
	
	/*
	 * GET/SET methods for the properties.
	 */
	
	/**
	 * A method to get x1.
	 * @return Returns x1's integer representation.
	 */
	protected int getX1() {
		return x1;
	}

	/**
	 * A method to set x1's value. Adds a negative value check.
	 * @param x1 - MyShape x1 value.
	 */
	protected void setX1(int x1) {
		if(x1 >= 0)
		{
			this.x1 = x1;
		}
	}
	
	/**
	 * A method to get x2.
	 * @return Returns x2's integer representation.
	 */
	protected int getX2() {
		return x2;
	}
	
	/**
	 * A method to set x2's value. Adds a negative value check.
	 * @param x2 - MyShape x2 value.
	 */
	protected void setX2(int x2) {
		if(x2 >= 0)
		{
			this.x2 = x2;
		}	
	}
	
	/**
	 * A method to get y1.
	 * @return Returns y1's integer representation.
	 */
	protected int getY1() {
		return y1;
	}

	/**
	 * A method to set y1's value. Adds a negative value check.
	 * @param y1 - MyShape y1 value.
	 */
	protected void setY1(int y1) {
		if(y1>= 0)
		{
			this.y1 = y1;
		}	
	}
	
	/**
	 * A method to get y2.
	 * @return Returns y2's integer representation.
	 */
	protected int getY2() {
		return y2;
	}

	/**
	 * A method to set y2's value. Adds a negative value check.
	 * @param y2 - MyShape y2 value.
	 */
	protected void setY2(int y2) {
		if(y2>= 0)
		{
			this.y2 = y2;
		}	
	}	

	/**
	 * A method to set the shape's color value. Adds a Color object check.
	 * @param color - the new shape's color.
	 */
	protected void setColor(Color color)
	{
		if (color instanceof Color)
			{
			this.color = color;
			}
	}
	
	/**
	 * A method to get the shape's color.
	 * @return Returns the color as a Color object.
	 */
	protected Color getColor()
	{
		return color;
	}
	
	/**
	 * draw abstract function, to be implemented on extending classes
	 * @param Graphics g - to be sent by paintComponent(Graphics g).
	 */
	protected abstract void draw(Graphics g);
	
	/**
	 * Clonable interface clone() implementation
	 * @returns (MyShape)Object cloned object.
	 */
	public Object clone() throws CloneNotSupportedException
    {  
		return (MyShape)super.clone();  
	}
	
	/**
	 * toString override
	 */
	@Override
	public String toString() 
	{
		return x1 + " " + x2 +" " + y1 + " " + y2; 
	}   

}
