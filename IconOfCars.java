import java.awt.*;
import javax.swing.*;

/**
 * This class contains methods related to icon. It implements the interface
 * Icon. This code was suggested by StickFigure on Coursework.
 *
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment4 2.1
 */

public class IconOfCars implements Icon { 

	/**
	 * This constructor creates with icon of given width, height and movable object.
	 * 
	 * @param movingObject the object that implement Movable
	 * @param iconWidth    the width of icon to be created
	 * @param iconHeight   the height of icon to be created
	 */
	public IconOfCars(Movable movingObject, int iconWidth, int iconHeight) {
		this.movingObject = movingObject;
		this.iconWidth = iconWidth;
		this.iconHeight = iconHeight;
	}
/**
 * Get method to return the width.
 * @return iconWidth the width of icon
 *
 */
	public int getIconWidth() {
		return iconWidth;
	}
	/**
	 * Get method to return the height.
	 * @return iconWidth the height of icon
	 *
	 */
	public int getIconHeight() {
		return iconHeight;
	}
	
	
	
	/**
	 * @param iconComponent the observer component used when icon has no image observer
	 * @param iconGraphics the graphic context
	 * @param x the x coordinate of the top left corner
	 * @param y the y coordinate of the top left corner 
	 */
	public void paintIcon(Component iconComponent, Graphics iconGraphics, int x, int y) {
		Graphics2D g2D = (Graphics2D) iconGraphics;
		movingObject.drawCar(g2D);
	}
/**
 * iconWidth the width of icon
 * iconHeight the height of icon
 * movingObject the movable object
 */
	private int iconWidth;
	private int iconHeight;
	private Movable movingObject;
}