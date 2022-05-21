import java.util.Random;

public class HillDecorator extends ObstacleDecorator {

	/**
	 * This is a concrete decorator class that creates Hills for all the cars. It
	 * extends ObstacleDecorator.
	 * 
	 * @author ChangSu Nam
	 * @UNI cn2521
	 * @since Assignment3 2.3
	 */

	/**
	 * Constructor that create HillDecorator.
	 * 
	 * @param carWithObstacle the cars to go on the hill
	 */
	public HillDecorator(Movable carWithObstacle) {
		super(carWithObstacle);

	}

	/**
	 * This method randomly creates integer between 0 to 5, and only applies Hill to
	 * the group of car when the value is 0. The chance of meeting a hill is 1/6.
	 * 
	 * Then it creates an integer between -1 to 1, randomHill to be used for y
	 * coordinates of all cars.
	 * 
	 * @return randomHill the random integer created for Hill, to be used for y.
	 */
	public int generateObstacle() {
		Random random = new Random();

		int zeroForHill = random.nextInt(6); // create random number in range of 0 to 5
		if (zeroForHill == 0) {
			randomHill = random.nextInt(2 + 1) - 1; // 1 0 or -1
			return randomHill;
		} else {// no hill
			randomHill = 0;
			return 0;
		}
	}

	/**
	 * This method translates the group cars with Hills. it adds the randomHill
	 * value to the y coordinate.To make sure the car does not change its y
	 * coordinate too fast, making it look like "teleporting" in y direction, a for
	 * loop is used in a way that the car translates with (0.0) several loops.
	 */
	public void translate(int xChange, int yChange) {
		generateObstacle();
		// System.out.println(randomHill);
		if (randomHill != 0) {
			for (int i = 0; i < 600 ; i++) {
				if (i == 0 || i== 599) {
					super.translate(0, yChange + randomHill);
				} else {
					super.translate(0, 0);
				}
			}
		} else {
			super.translate(xChange, yChange + randomHill);
		}

	}
	/**
	 * randomHill the random integer to be used to translate, creating an illusion of hill.
	 */
	private int randomHill;

}
