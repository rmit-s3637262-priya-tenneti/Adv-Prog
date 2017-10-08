package com.assignment;
/*
 * To encapsulate the secured data,
 * we written an interface where we gave access to the user only for main menu 
 * and initialized the final variables for start and finishing time 
 */
public interface Drivable {
	
	/** Running - 11 to 20 seconds */
	final static int SPRINTER_START_TIME = 11;
	final static int SPRINTER_END_TIME = 20;
	/** Swimming - 101 to 200 seconds */
	final static int SWIMMER_START_TIME = 101;
	final static int SWIMMER_END_TIME = 200;
	/** Cycling - 501 to 800 seconds */
	final static int CYCLIST_START_TIME = 501;
	final static int CYCLIST_END_TIME = 800;

	public void mainMenu();

}
