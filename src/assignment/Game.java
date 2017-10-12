/**Author : s3640623 - Rochelle Maria Gracias */

package assignment;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean gameStarted;
	private boolean gameSelected;
	private boolean winnerPredicted ;
	private boolean participantSelected ;
	
	private int id;
	private int countPlayers;
	private int startTime;
	private int endTime;

	private String gameType;
	private String userPredictedName;
	private ArrayList<Athlete> athletesArr;
	private Official official;
	
	public Game(int id) {
		this.id = id;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	public boolean isGameSelected() {
		return gameSelected;
	}

	public void setGameSelected(boolean gameSelected) {
		this.gameSelected = gameSelected;
	}

	public boolean isWinnerPredicted() {
		return winnerPredicted;
	}

	public void setWinnerPredicted(boolean winnerPredicted) {
		this.winnerPredicted = winnerPredicted;
	}

	public boolean isParticipantSelected() {
		return participantSelected;
	}

	public void setParticipantSelected(boolean participantSelected) {
		this.participantSelected = participantSelected;
	}

	public int getCountPlayers() {
		return countPlayers;
	}

	public void setCountPlayers(int countPlayers) {
		this.countPlayers = countPlayers;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getUserPredictedName() {
		return userPredictedName;
	}

	public void setUserPredictedName(String userPredictedName) {
		this.userPredictedName = userPredictedName;
	}

	public ArrayList<Athlete> getAthletesArr() {
		return athletesArr;
	}

	public void setAthletesArr(ArrayList<Athlete> athletesArr) {
		this.athletesArr = athletesArr;
	}

	public Official getOfficial() {
		return official;
	}

	public void setOfficial(Official official) {
		this.official = official;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	
}
