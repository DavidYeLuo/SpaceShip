import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpaceShip extends JPanel
{
	private Point clickedLocation = null;
	private Point mouseLocation = null;
	private boolean isClicked;
	private int shotCounter;
	
	private JButton resetButton;
	private SpaceShipListener listener;
	
	public SpaceShip()
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
				g.setColor(Color.magenta);
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
	}
	
	private class SpaceShipListener implements MouseListener,
											   MouseMotionListener,
											   ActionListener
	{
		// MouseListener
		public void mouseClicked(MouseEvent e) // Whenever a mouse clicks
		{
			isClicked = true;
			clickedLocation = e.getPoint();
			shotCounter++;
			repaint();
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		

		// mouseMotionListener
		public void mouseDragged(MouseEvent arg0) {}
		public void mouseMoved(MouseEvent e) // Detect mouse movements
		{
			mouseLocation = e.getPoint();
			repaint();
		}
		
		// actionListener
		public void actionPerformed(ActionEvent arg0) // Used for button (reset)
		{
			shotCounter = 0;
			repaint();
		}
	}
	
}
