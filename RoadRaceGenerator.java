import java.util.Random;
import java.awt.*;

/**
 * This class creates aggregate of cars of random size and y coordinate.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment4 2.2
 */
public class RoadRaceGenerator implements Movable {
	/**
	 * Constructor that creates aggregate of 3 cars with random location.
	 * 
	 * @param maxY     the maximum value of y coordinate to create a car at
	 * @param unitSize the unit of the car to be created.
	 */
	public RoadRaceGenerator(int maxY, double unitSize) {
		raceCarArray = new Movable[3];
		for (int i = 0; i < 3; i++) {
			Random random = new Random();
			int randomY = random.nextInt(maxY + 1 - 0) + 0; // 0 to maxY+1, because max is exclusive
			double randomSize = 0.5 + (2 - 0.5) * random.nextDouble(); // 0.5 to 2
			raceCarArray[i] = new Car(0, randomY, randomSize * unitSize); // x is 0 y is random

		}
	}

	/**
	 * Get method to get a specific car
	 * 
	 * @param carIndex the index of array of cars.
	 * @return the specific car
	 */
	public Movable getCar(int carIndex) {
		return raceCarArray[carIndex];
	}

	/**
	 * Set method to replace a car
	 * 
	 * @param carIndex     the index of array of cars.
	 * @param carToBeAdded a new car to be replaced
	 */
	public void setCar(int carIndex, Movable carToBeAdded) {
		raceCarArray[carIndex] = carToBeAdded;
	}

	/**
	 * This method gets the size of array of cars.
	 * 
	 * @return the size of aggregate
	 */
	public int getLength() {
		return raceCarArray.length;
	}

	/**
	 * This method draws the cars in array with Graphics2D
	 * 
	 * @param g2d reference to Graphics2D
	 */
	public void drawCar(Graphics2D g2d) {
		for (Movable raceCar : raceCarArray) {
			raceCar.drawCar(g2d);
		}

	}

	/**
	 * This method changes the coordinate of the cars.
	 * 
	 * @param xChange the change to be made in x coordinate
	 * @param yChange the change to be made in y coordinate.
	 */
	public void translate(int xChange, int yChange) {

		for (Movable raceCar : raceCarArray) {
			raceCar.translate(xChange, yChange);

		}
	}
/**
 * raceCarArray the array that holds cars to be raced.
 */
	private Movable[] raceCarArray;

}
