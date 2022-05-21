import java.awt.*;

/**
 * This is an interface class for movable objects. This code was suggested by
 * StickFigure on Coursework.
 *
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment4 2.1
 */
public interface Movable {

	/**
	 * method to draw car
	 * 
	 * @param g2D the Graphics2D reference
	 */
	void drawCar(Graphics2D g2D);

	/**
	 * method to change coordinates of car
	 * 
	 * @param xChange the change to be applied to x coordinate
	 * @param yChange the change to be applied to y coordinate
	 */
	void translate(int xChange, int yChange);
}