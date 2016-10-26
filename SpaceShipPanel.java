/**
 * SpaceShip --- A game that counts your clicks
 * @author 		 David Ye Luo, Kenta Medina
 * @version		 1.0
 * @since		 2016-10-26
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpaceShipPanel extends JPanel
{
	private Point clickedLocation = null;
	private Point mouseLocation = null;
	private boolean isClicked;
	private int shotCounter;
	
	private JButton resetButton;
	private SpaceShipListener listener;
	
	//------------------------------------------------------
	//	Default Constructor
	//------------------------------------------------------
	public SpaceShipPanel()
	{
		shotCounter = 0;
		listener = new SpaceShipListener();
		resetButton = new JButton("Reset");
		
		add(resetButton);
		
		addMouseListener(listener);
		addMouseMotionListener(listener);
		resetButton.addActionListener(listener);
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(300, 200));
	}
	
	//------------------------------------------------------
	//	Draw the panel
	//------------------------------------------------------
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		if(clickedLocation != null && isClicked)
		{
			switch((int)(Math.random() * 5))	// Color Generator
			{
			case 0:
				g.setColor(Color.green);
				break;
			case 1:
				g.setColor(Color.blue);
				break;
			case 2:
				g.setColor(Color.red);
				break;
			case 3:
				g.setColor(Color.pink);
				break;
			case 4: // Could use default:
				g.setColor(Color.yellow);
				break;
			}
			
			g.drawLine(clickedLocation.x, clickedLocation.y,
				(int)(Math.random() * 300),
				(int)(Math.random() * 200));
			isClicked = false;
		}
		if(mouseLocation != null)
		{
			g.setColor(Color.cyan); // Spaceship
			g.fillOval(mouseLocation.x, mouseLocation.y, 100, 100);	// SpaceShip
		}
		g.setColor(Color.white);  // Counter
		g.drawString("Shot counter: " + shotCounter, 0, 195);  // Counter
		g.drawString("by David and Kenta", 194, 195);  // Credit
	}
	/**
	 * SpaceShipListener --- Programs to hold Listener
	 * @author 				 David Ye Luo, Kenta Medina
	 * @version				 1.0
	 * @since				 2016-10-26
	 */
	private class SpaceShipListener implements MouseListener,
						   MouseMotionListener,
						   ActionListener
	{
		//------------------------------------------------------
		//	Listen to mouse clicks
		//------------------------------------------------------
		public void mouseClicked(MouseEvent e) // MouseListener
		{
			isClicked = true;
			clickedLocation = e.getPoint();
			shotCounter++;
			repaint();
		}
		public void mouseEntered(MouseEvent arg0) {}  // MouseListener
		public void mouseExited(MouseEvent arg0) {}   // MouseListener
		public void mousePressed(MouseEvent arg0) {}  // MouseListener
		public void mouseReleased(MouseEvent arg0) {} // MouseListener
		
		//------------------------------------------------------
		//	Detects mouse movements
		//------------------------------------------------------
		public void mouseMoved(MouseEvent e) // Detect mouse movements
		{
			mouseLocation = e.getPoint();
			repaint();
		}
		public void mouseDragged(MouseEvent arg0) {} // MouseMotionListener

		//------------------------------------------------------
		//	Listen for button press
		//------------------------------------------------------
		public void actionPerformed(ActionEvent arg0) // ActionListener
		{
			// Used for button (reset)
			shotCounter = 0;
			repaint();
		}
	}
	
}
