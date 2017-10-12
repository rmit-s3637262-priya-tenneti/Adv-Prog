package interfaces;

import assignment.Game;
import utilities.GameRelatedExceptions;

public interface OzlympicsManager {

	/** Running - 11 to 20 seconds */
	final static int SPRINTER_START_TIME = 11;
	final static int SPRINTER_END_TIME = 20;
	/** Swimming - 101 to 200 seconds */
	final static int SWIMMER_START_TIME = 101;
	final static int SWIMMER_END_TIME = 200;
	/** Cycling - 501 to 800 seconds */
	final static int CYCLIST_START_TIME = 501;
	final static int CYCLIST_END_TIME = 800;

	/** Point for 1st, 2nd and 3rd place */
	final static int FIRST = 5;
	final static int SECOND = 2;
	final static int THIRD = 1;

	public void mainMenu() throws GameRelatedExceptions;
	public void createGame() throws GameRelatedExceptions;
	public Game selectGame(Game game) throws GameRelatedExceptions;
	public Game addParticipant(Game game) throws GameRelatedExceptions;
	public Game predictWinner(Game game) throws GameRelatedExceptions;
	public Game startGame(Game game) throws GameRelatedExceptions;
	public Game reRunLastGame(Game game) throws GameRelatedExceptions;
	public void displayResultsOfAthlete() throws GameRelatedExceptions;
	public void displayResultsOfGames() throws GameRelatedExceptions;
	
	public static String getType(int gameType) {
		if (gameType == 1)
			return "Running";
		else if (gameType == 2)
			return "Swimming";
		else if (gameType == 3)
			return "Cycling";
		else
			return "Invalid Type";
	}

	public static boolean isValid(String type, int gameType) {
		if (type.equals("Sprinter") && gameType == 1)
			return true;
		else if (type.equals("Swimmer") && gameType == 2)
			return true;
		else if (type.equals("Cyclist") && gameType == 3)
			return true;
		else if (type.equals("SuperAthlete"))
			return true;
		else
			return false;

	}
}
