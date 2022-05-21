import java.awt.Graphics2D;

/**
 * This class is superclass for the bump and hill obstacle. It implements the
 * Movable interface.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment4 2.3
 */
public class ObstacleDecorator implements Movable {
	/**
	 * 
	 * Constructor that creates ObstacleDecorator
	 * 
	 * @param carWithObstacle the car that will experience change in y
	 */
	public ObstacleDecorator(Movable carWithObstacle) {
		this.carWithObstacle = carWithObstacle;

	}

	/**
	 * This method draws the car with Graphics2D.
	 * 
	 * @param g2D the reference to Graphics2D
	 */
	public void drawCar(Graphics2D g2D) {
		this.carWithObstacle.drawCar(g2D);
	}

	/**
	 * This method changes the coordinate of the car.
	 * 
	 * @param xChange the change to be made in x coordinate.
	 * @param yChange the change to be made in y coordinate.
	 */
	public void translate(int xChange, int yChange) {
		this.carWithObstacle.translate(xChange, yChange);

	}

	/**
	 * carWithObstacle the car that will go on Hills and bumps
	 */
	protected Movable carWithObstacle;
}
