import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a Runner class with a main method that creates the car.
 *
 ** This code was inspired by StickFigure on Coursework.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment4 2.1
 */

public class CarRunner {

	public static void main(String[] args) {
		JFrame frameForCars = new JFrame();
		
		//use decorator pattern for Hill and Bump, for Assignment 2.3
		HillDecorator carList = new HillDecorator(
				new BumpDecorator(new RoadRaceGenerator(ICON_H - (int) (5 * SIZE), SIZE)));

		final IconOfCars iconForCars = new IconOfCars(carList, ICON_W, ICON_H);
		final JLabel labelForCars = new JLabel(iconForCars);

		frameForCars.add(labelForCars);
		frameForCars.setLayout(new FlowLayout());
		frameForCars.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameForCars.pack();
		frameForCars.setVisible(true);
		final int DELAY = 100;
		// Milliseconds between timer ticks
		Timer timerForCars = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				carList.translate(carSpeed, 0);
				labelForCars.repaint();
			}
		});
		timerForCars.start();
		
		//Slider, for assignment 2.2
		SpeedController raceSpeedController = new SpeedController();
		raceSpeedController.pack();
		raceSpeedController.setVisible(true);

	}

	/**
	 * carSpeed the default speed of car,
	 * SIZE the unit for cars,
	 * ICON_W the width of icon,
	 * ICON_H the height of icon
	 */
	static int carSpeed = 1;
	private static final double SIZE = 20;
	private static final int ICON_W = 1000;
	private static final int ICON_H = 1000;
}
