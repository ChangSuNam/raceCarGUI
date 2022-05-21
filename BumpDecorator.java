import java.util.Random;

/**
 * This is a concrete decorator class that creates bumps for the cars
 * separately. It extends ObstacleDecorator.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment3 2.3
 */
public class BumpDecorator extends ObstacleDecorator {
	/**
	 * Constructor that creates BumpDecorator.
	 * 
	 * @param carWithObstacle the cars to be bumped with objects
	 */
	public BumpDecorator(Movable carWithObstacle) {
		super(carWithObstacle);

	}

	/**
	 * This method randomly creates integer between -5 to 5, randomBumps to be used
	 * for y coordinates of each cars.
	 * 
	 * @return randomBump the random integer created.
	 */
	public int generateObstacle() {
		Random random = new Random();
		int randomBump = random.nextInt(6 + 5) - 5; // create bump in range of -5 to 5
		return randomBump;
	}

	/**
	 * This method translates the car objects with obstacles. it adds the randomBump
	 * value to the y coordinate.
	 */
	public void translate(int xChange, int yChange) {

		super.translate(xChange, yChange + generateObstacle());

	}

}
