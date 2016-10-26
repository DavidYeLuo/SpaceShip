import javax.swing.*;
public class SpaceShip
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new SpaceShipPanel());
		frame.setVisible(true);
		frame.pack();
	}
}