# SpaceShip
111B Homework

## Background Thought
An event in a graphical user interface is an object that represents some action such as clicking a mouse, dragging the mouse, pressing a key on the keyboard, or any other action that is expected to elicit a response. Actually, events are more general that just the events of a GUI. For example, a message from a printer to the operating system saying that the printer is ready to print another document can be considered an event

## Instructions/Design
1) Design and implement a program named SpaceShip.java.  If you are developing a stand-alone application, you will need 2 files: SpaceShip.java and SpaceShipPanel.java 

This program is a simple ‘game’ (or at least a partial game) that displays a ‘spaceship’ that follows the mouse and shoots ‘lasers’. In addition, the program keeps track of how many shots were fired. This ‘shot counter’ is controlled by a button that resets ‘shot counter’ to zero.

2) The spaceship can be drawn at any location on the screen. You may create the spaceship using basic shapes (such as an oval, rectangle, etc).

3) The spaceship follows the movement of the mouse. When the mouse moves so does the spaceship.

4) When the mouse button is pressed, have a laser beam (line) shoot out of the spaceship. The spaceship should aim at random targets each time the laser is fired. Note: you know the x,y coordinates of the spaceship, you will need a second set of x,y coordinates to draw the line. Pick a random location within the dimensions of your program for this second set of coordinates. Just make sure the ‘laser beam’ is long enough to see.

5) Note that the laser does not always show on the screen, only when the mouse is pressed. You will need a ‘flag’ (boolean variable) to keep track if the mouse is fired or not.

6) The program also keeps track of how many shots have been fired. Each time the laser is fired (mouse is pressed), update a ‘shot counter’ variable. This ‘shot counter’ is displayed for the user.

7) The laser beam must change color each time it is fired. You should use at least 4 different colors for the laser beam and cycle through them. One approach is to use the shot counter to help cycle thru the colors (a switch statement is useful). Example: If you mod by 4 the shot counter you will get a number between 0 and 3; if remainder is 2 you would set color to be red.

8) Implement one button to control your application. The button resets the “shot counter” to zero.

9) Each event listened for needs its own private inner class.
##Extra credit

Have a laser sound play when the laser is “firing.” Extra points will be given if you implement a second button. This button turns the sound on and off. The initial setting should be "off". You will need a flag (boolean variable) to ‘remember’ if the sound is on or not. Because this is extra credit, you will need to figure out how to do the sound.

Look thru the documentation for the AudioClip class and its play() method. Here is one resource:
http://www.javaworld.com/article/2077521/learn-java/java-tip-24--how-to-play-audio-in-applications.html
