/**Author : s3640623 - Rochelle Maria Gracias */
package interfaces;

import java.util.ArrayList;

import assignment.Athlete;
import assignment.Game;
import assignment.Official;

public interface GameManager {

	public Game createGame(int id, String gameType, int startTime, int endTime);

	public Game addAthletes(Game game, ArrayList<Athlete> athleteArray);

	public Game addOfficials(Game game, Official official);

	public Game predictWinner(Game game, String userPredictedName);

	public Game startGame(Game game);

	public Game displayGameresults(Game game);

	public String[] getAthletesNames(Game game);
}
