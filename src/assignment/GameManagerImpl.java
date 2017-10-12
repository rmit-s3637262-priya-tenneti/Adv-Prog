/**Author : s3640623 - Rochelle Maria Gracias */
package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import interfaces.GameManager;
import interfaces.OzlympicsManager;

public class GameManagerImpl implements GameManager {

	@Override
	public Game createGame(int id, String gameType, int startTime, int endTime) {
		if (startTime == endTime)
			endTime += 1;
		Game game = new Game(id);
		game.setGameType(gameType);
		game.setStartTime(startTime);
		game.setEndTime(endTime);
		game.setGameSelected(true);
		return game;
	}

	@Override
	public Game addAthletes(Game game, ArrayList<Athlete> athleteArray) {
		game.setAthletesArr(athleteArray);
		game.setCountPlayers(athleteArray.size());
		return game;
	}

	@Override
	public Game addOfficials(Game game, Official official) {
		game.setOfficial(official);
		return game;
	}

	@Override
	public Game predictWinner(Game game, String userPredictedName) {
		game.setUserPredictedName(userPredictedName);
		game.setWinnerPredicted(true);
		return game;
	}
	
	@Override
	public Game startGame(Game game) {

		ArrayList<Athlete> athletesArr = game.getAthletesArr();

		for (int i = 0; i < athletesArr.size(); i++) {
			athletesArr.get(i).compete(game.getStartTime(), game.getEndTime());
			athletesArr.get(i).setPlayed(true);
		}

		Collections.sort(athletesArr, new Comparator<Athlete>() {
			public int compare(Athlete o1, Athlete o2) {
				if (o1.getFinishTime() > o2.getFinishTime()) {
					return 1;
				}
				return -1;
			}
		});

		athletesArr.get(0).updatePoints(OzlympicsManager.FIRST);
		athletesArr.get(1).updatePoints(OzlympicsManager.SECOND);
		athletesArr.get(2).updatePoints(OzlympicsManager.THIRD);

		game.setAthletesArr(athletesArr);

		game.setGameStarted(true);
		return game;
	}

	@Override
	public Game displayGameresults(Game game) {
		game.getOfficial().summariseGame(game);
		return game;
	}
	
	@Override
	public String[] getAthletesNames(Game game) {
		String[] athleteName = new String[game.getCountPlayers()];
		for (int i = 0; i < athleteName.length; i++)
			athleteName[i] = game.getAthletesArr().get(i).getName();
		return athleteName;
	}

}
