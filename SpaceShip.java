/**
 * SpaceShip --- A game that counts your clicks
 * @author       David Ye Luo, Kenta Medina
 * @version      1.0
 * @since        2016-11-2
 */
//-----------------------------------------------------------
// 1) Detect what the user is doing.
// 2) Draw spaceship around the mouse.
// 3) Record each clicks and draw laser beam
// 4) Make 2 buttons
//		- Reset click count
//		- Turns on/off sound
//-----------------------------------------------------------
import javax.swing.*;

public class SpaceShip
{
	/**
	* Let the user play a game of SpaceShip
	* @param arg A string array containing 
	* the command line arguments.
	* @exception Any exception
	* @return    No return value.
	*/ 
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("SpaceShip");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new SpaceShipPanel());
		frame.setVisible(true);
		frame.pack();
	}
}