import java.awt.*;
import java.util.Random;
import java.awt.geom.*;

/**
 * This class contains methods to create and draw a car. It implements the
 * interface Movable. This code was suggested by StickFigure on Coursework.
 *
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment4 2.1
 */
public class Car implements Movable {

	/**
	 * Constructor that sets coordinate and unit for car.
	 * 
	 * @param x    the x Coordinate of the car
	 * @param y    the y Coordinate of the car
	 * @param unit the unit of size of the acr
	 */
	public Car(int x, int y, double unit) {

		this.x = x;
		this.y = y;
		this.unit = unit; // unit is in pixels
	}

	/**
	 * This method adds new values to coordinate of the car.
	 * 
	 * @param xChange the value to be added to the x coordinate.
	 * @param yChange the value to be added to the y coordinate.
	 */
	public void translate(int xChange, int yChange) {

		x += xChange;
		y += yChange;

	}

//	
	/**
	 * This method draws a car components of car, and draw and paint it using
	 * Graphics2D.
	 * 
	 * @param g2D the object referring to Graphics2D.
	 */
	public void drawCar(Graphics2D g2D) {
// the x coordinate of Center of the car
		int xCenter = x + (int) (CARLENGTH / 2 * unit);
// Driver's Head located at the middle of the car  
		int headXUpLeft = xCenter;
		int headYUpLeft = y;
		int headSize = (int) unit;
		Ellipse2D.Double driverHead = new Ellipse2D.Double(headXUpLeft, headYUpLeft, headSize, headSize);

// Car body 

		int carX = x;
		int carY = y + (int) (WINDOWHEIGHT * unit);
		int carWidth = (int) (CARLENGTH * unit);
		int carHeight = (int) (CARHEIGHT * unit);

		Rectangle2D.Double carBody = new Rectangle2D.Double(carX, carY, carWidth, carHeight);

//window
		int windowXUpLeft = xCenter + headSize;
		int windowYUpLeft = y;
		int windowXBottomRight = xCenter + headSize + (int) (WINDOWHEIGHT * unit);
		int windowYBottomRight = y + (int) (WINDOWHEIGHT * unit);

		Line2D.Double carWindow = new Line2D.Double(windowXUpLeft, windowYUpLeft, windowXBottomRight,
				windowYBottomRight);

//Wheels

		int leftWheelXUpLeft = x + (int) (CARLENGTH / BODYVSWHEELX * unit);
		int leftWheelYUpLeft = y + (int) (CARHEIGHT * unit * BODYVSWHEELY);
		int wheelSize = (int) (WHEELHEIGHT * unit);
		int rightWheelXUpLeft = x + (int) (CARLENGTH / BODYVSWHEELX * unit * 2);
		int rightWheelYUpLeft = y + (int) (CARHEIGHT * unit * BODYVSWHEELY);
		Ellipse2D.Double leftWheel = new Ellipse2D.Double(leftWheelXUpLeft, leftWheelYUpLeft, wheelSize, wheelSize);
		Ellipse2D.Double rightWheel = new Ellipse2D.Double(rightWheelXUpLeft, rightWheelYUpLeft, wheelSize, wheelSize);

// aggregate car components using one GeneralPath
		GeneralPath car = new GeneralPath();
		car.append(carBody, false);
		car.append(leftWheel, false);
		car.append(rightWheel, false);

		Random random = new Random();
		int randomColor = random.nextInt(150 + 1 - 0) + 0;
		// System.out.println("Random Color is: "+randomColor);
		g2D.setPaint(new Color(randomColor, randomColor, randomColor));

		g2D.fill(driverHead);
		g2D.fill(car);
		g2D.draw(carWindow);

	}
/**
 * x the x coordinate of car
 * y the y coordinate of car
 * unit the unit of the size of the car
 * CARLENGTH the length of car's body
 * CARHEIGHT the height of car
 * WINDOWHEIGHT the height of window
 * WHEELHEIGHT the height of wheels
 * BODYVSWHEELX the relative location of Wheel vs body for x coordinate
 * BODYVSWHEELY the relative location of Wheel vs body for y coordinate
 */
	private int x;
	private int y;
	private double unit;
	private final double CARLENGTH = 6.0;
	private final double CARHEIGHT = 1.8;
	private final double WINDOWHEIGHT = 1.0;
	private final double WHEELHEIGHT = 1.3;
	private final double BODYVSWHEELX = 3;
	private final double BODYVSWHEELY = 1.7;
}