/**
 * @author Tom Ben Shmueli 203525548
 *	MyBoundedShape abstract class. Adds a boolean filled/not filled property.
 *	The class provides access to the private property with get/set methods and not by inheritance.
 */
public abstract class MyBoundShape extends MyShape {
	
	/*
	 * class variables
	 */
	private boolean isFilled;
	
	/**
	 * A method to get the bounded shape isFilled value.
	 * @return boolean value - true if the shape is fllled, else false.
	 */	
	protected boolean isFilled() {
		return isFilled;
	}

	/**
	 * 
	 * @param isFilled - boolean value to define if the shape is filled or not.
	 */
	protected void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	/**
	 * Abstract method to be implemented. Calculates the shape's area.
	 * @return double area - the shape's area.
	 */
	protected abstract double area();

}
