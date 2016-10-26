import javax.swing.*;
public class SpaceShipPanel
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new SpaceShip());
		frame.setVisible(true);
		frame.pack();
	}
}