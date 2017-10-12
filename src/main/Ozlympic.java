package main;

import java.io.FileNotFoundException;

import assignment.Driver;

public class Ozlympic {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {
		Driver userInterface = new Driver();
		userInterface.begin(args);
	}
}
