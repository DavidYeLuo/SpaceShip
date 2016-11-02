/**
 * SpaceShipPanel --- A game that counts your clicks
 * @author            David Ye Luo, Kenta Medina
 * @version           1.0
 * @since             2016-11-2
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

public class SpaceShipPanel extends JPanel
{
	private Point clickedLocation = null;
	private Point mouseLocation = null;
	private boolean clickEnabled;
	private boolean soundEnabled;
	private int shotCounter;
	private int lastColor;
	
	private JButton resetButton;
	private JButton soundButton;
	private SpaceShipListener listener;
	
	private InputStream in; //extra credit
	private AudioStream as; //extra credit
	
	//------------------------------------------------------
	//	Default Constructor
	//------------------------------------------------------
	public SpaceShipPanel()
	{
		shotCounter = 0;
		lastColor = 0;
		soundEnabled = false;
		listener = new SpaceShipListener();
		resetButton = new JButton("Reset");
		soundButton = new JButton("Sound is: " + "Off");

		add(resetButton);
		add(soundButton);
		
		resetButton.addActionListener(new ResetButtonListener());
		soundButton.addActionListener(new SoundButtonListener());
		addMouseListener(listener);
		addMouseMotionListener(listener);

		setBackground(Color.black);
		setPreferredSize(new Dimension(300, 200));
	}
	
	//------------------------------------------------------
	//	Draw the panel
	//------------------------------------------------------
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		if(clickedLocation != null && clickEnabled)
		{
			// draw a laser beam
			lastColor += +(int)(java.lang.Math.random()*4+1);
			switch(lastColor%5)	// Color Generator
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
			clickEnabled = false;
		}

		if(mouseLocation != null)
		{
			// Draw SpaceShip when mouse is detected
			
			// SpaceShip's Head
			g.setColor(Color.red);
			g.fillOval(mouseLocation.x-8, mouseLocation.y-7 - 12, 16, 14);
			
			// SpaceShip's Body
			g.setColor(Color.yellow); 
			g.fillOval(mouseLocation.x-25, mouseLocation.y-12, 50, 25);
			
			// SpaceShip's Window
			g.setColor(Color.blue);
			g.fillOval(mouseLocation.x-5 - 12, mouseLocation.y-5, 10, 10); // first window
			g.fillOval(mouseLocation.x-5, mouseLocation.y-5, 10, 10); // second window
			g.fillOval(mouseLocation.x-5 + 12, mouseLocation.y-5, 10, 10); // third window
		}
		// String displayed
		g.setColor(Color.white);
		g.drawString("Shot counter: " + shotCounter, 0, 195);  // Counter
		g.drawString("by David and Kenta", 194, 195);  // Credit
	}
	
	/**
	 * SpaceShipListener --- Programs to hold Listener
	 * @author 		 David Ye Luo, Kenta Medina
	 * @version		 1.0
	 * @since		 2016-10-28
	 */
	private class SpaceShipListener implements MouseListener,
						   MouseMotionListener
	{
		//------------------------------------------------------
		//	Listen to mouse pressed and released
		//------------------------------------------------------
		public void mouseClicked(MouseEvent e) // MouseListener
		{
			// This is the sound played 
			// Feel free to make it more efficient
			// So far this is my only solution
			// Due to IDE technical difficulties
			// My Eclipse doesn't work with sound classes
			if(soundEnabled) 					
			{							// :On purpose:
				try{						// New files are created
					in = new FileInputStream("raygun.au"); 	// to repeat the sound.
					as = new AudioStream(in);		//
					AudioPlayer.player.start(as);		// If the variables
				}catch(Exception ex) {}				// aren't reinstantiated
			}							// the sound will only play once.
			clickEnabled = true;
			clickedLocation = e.getPoint();
			shotCounter++;
			repaint();
		}
		
		//------------------------------------------------------
		//	Detects when mouse is in the panel
		//------------------------------------------------------
		public void mouseEntered(MouseEvent arg0) {}  // MouseListener
		
		//------------------------------------------------------
		//	Detects when mouse is out of panel
		//------------------------------------------------------
		public void mouseExited(MouseEvent arg0) {}   // MouseListener
		
		//------------------------------------------------------
		//	Detects when a mouse clicks
		//------------------------------------------------------
		public void mousePressed(MouseEvent arg0) {}  // MouseListener
		
		//------------------------------------------------------
		//	Detects when a mouse un-clicks
		//------------------------------------------------------
		public void mouseReleased(MouseEvent arg0) {} // MouseListener
		
		//------------------------------------------------------
		//	Detects mouse movements
		//------------------------------------------------------
		public void mouseMoved(MouseEvent e) // MouseMotionListener
		{
			mouseLocation = e.getPoint();
			repaint();
		}
		
		//------------------------------------------------------
		//	Detects when a mouse clicks then move
		//------------------------------------------------------
		public void mouseDragged(MouseEvent arg0) {} // MouseMotionListener
	}
	
	/**
	 * ResetButtonListener --- Reset scores when button is pressed
	 * @author                 David Ye Luo, Kenta Medina
	 * @version		   1.0
	 * @since		   2016-11-2
	 */
	private class ResetButtonListener implements ActionListener
	{
		//------------------------------------------------------
		//	Listen for button press
		//------------------------------------------------------
		public void actionPerformed(ActionEvent arg0)
		{
			// Used for button (reset)
			shotCounter = 0;
			repaint();
		}
	}
	/**
	 * SoundButtonListener --- Turns on or off sound
	 * @author		   David Ye Luo, Kenta Medina
	 * @version		   1.0
	 * @since		   2016-11-2
	 */
	private class SoundButtonListener implements ActionListener
	{

		//------------------------------------------------------
		//	Listen for button press
		//------------------------------------------------------
		public void actionPerformed(ActionEvent arg0) 
		{
			// Whenever the button is pressed,
			// sound is switched
			// and changes the button's text
			
			String text;
			if(soundEnabled) 
			{
				soundEnabled = false;
				text = "OFF";
			}
			else
			{
				soundEnabled = true;
				text = "ON";
			}
			soundButton.setText("Sound is: " + text);
		}
		
	}
	
}