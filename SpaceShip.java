import javax.swing.*;
import java.util.*;
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
			g.setColor(Color.green);
			g.drawLine(clickedLocation.x, clickedLocation.y,
				(int)(Math.random() * 300),
				(int)(Math.random() * 200));
			isClicked = false;
		}
		if(mouseLocation != null)
		{
			g.setColor(Color.cyan);
			g.drawOval(mouseLocation.x, mouseLocation.y, 100, 100);
		}
		g.setColor(Color.white);
		g.drawString("Shot counter: " + shotCounter, 0, 195);
	}
	
	private class SpaceShipListener implements MouseListener,
											   MouseMotionListener,
											   ActionListener
	{
		// MouseListener
		public void mouseClicked(MouseEvent e) 
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
		public void mouseMoved(MouseEvent e) 
		{
			mouseLocation = e.getPoint();
			repaint();
		}
		
		// actionListener
		public void actionPerformed(ActionEvent arg0) 
		{
			shotCounter = 0;
			repaint();
		}
	}
	
}
