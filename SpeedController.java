import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This Class creates JSlider that controls speed of the car.
 * This Class was inspired by Observer pattern example provided in Coursework.
 *@author ChangSu Nam
 *@UNI cn2521
 *@since Asssignment4 2.2
 *
 */
public class SpeedController extends JFrame {

	/**
	 * Contructor that creates JSlider to change speed of the car.
	 */
	public SpeedController() {

		JPanel speedPanel = new JPanel();
		JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);
		JLabel speedLabel = new JLabel();
		speedSlider.setPaintLabels(true);
		speedSlider.setPaintTrack(true);
		speedSlider.setPaintTicks(true);
		speedSlider.setMajorTickSpacing(2);
		speedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				speedToBeSet = speedSlider.getValue();
				CarRunner.carSpeed = speedToBeSet;
				speedLabel.setText("Slide to set speed. Current Speed is: " + speedToBeSet);
			}

		});

		speedPanel.add(speedSlider);
		speedLabel.setText("Slide to set the speed of the cars. Current Speed is: " + CarRunner.carSpeed);
		speedPanel.add(speedLabel);

		add(speedPanel, BorderLayout.NORTH);
	}
/**
 *  speedToBeSet the value that reflects numbers on JSlider
 */
	private int speedToBeSet;
}