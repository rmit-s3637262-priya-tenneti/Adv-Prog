package com.assignment;

/**
 * Reference : http://www.kscodes.com/java/sorting-arraylist-java-using-comparators/
 */
import java.util.*;

/*
 * class to Start the game and display the results of games
 */
public class Game {

	private final int FIRST = 5;
	private final int SECOND = 2;
	private final int THIRD = 1;

	private static int countGames = 0;

	private boolean gameStarted;
	private int id;
	private int countPlayers;

	private String gameType;
	private Official official;

	private ArrayList<Athlete> athletesArr;
	private String userPredictedName;

	public Game(int id, String gameType, int countPlayers, Official official, ArrayList<Athlete> athletesArr) {
		this.id = id;
		this.gameType = gameType;
		this.countPlayers = countPlayers;
		this.official = official;
		this.athletesArr = athletesArr;
		this.gameStarted = false;
	}

	public void setParticipants(String gameType, int countPlayers, Official official, ArrayList<Athlete> athletesArr) {
		this.gameType = gameType;
		this.countPlayers = countPlayers;
		this.official = official;
		this.athletesArr = athletesArr;
	}

	/*
	 * added method to start the timer of the game as well as displaying the
	 * points in a sorted order by ensuring to make all members with the same
	 * points has sorted based on their alphabetical order of names
	 */
	public void startGame(int startTime, int endTime) {
	
		if (startTime == endTime)
			endTime += 1;
		for (int i = 0; i < athletesArr.size(); i++) {
			athletesArr.get(i).compete(startTime, endTime);
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
		athletesArr.get(0).updatePoints(FIRST);
		athletesArr.get(1).updatePoints(SECOND);
		athletesArr.get(2).updatePoints(THIRD);
		timer(endTime);
	}

	/*
	 * method to pause the system till the randomly generated finish time
	 */
	public void timer(int endTime) {
		System.out.println("Count Down in seconds:");
		int timer = 0;
		while (timer <= endTime) {
			System.out.print(timer + " ");
			try {
				timer++;
				Thread.sleep(1000L); // 1000L = 1000ms = 1 second
			} catch (InterruptedException e) {
				System.out.println("Error!-->InterruptedException");
			}
		}
		System.out.println();
	}

	public String[] getAthletesNames() {
		String[] athleteName = new String[athletesArr.size()];
		for (int i = 0; i < athletesArr.size(); i++)
			athleteName[i] = athletesArr.get(i).getName();
		return athleteName;

	}

	public void printName(Athlete athlete) {
		athlete.print();
	}

	/*
	 * created display Result method to invoke the summarize game from official
	 */
	public void displayResult() {
		official.summariseGame(this);
	}

	public ArrayList<Athlete> getAthletesArr() {
		return athletesArr;
	}

	public static void incrCountGames() {
		countGames++;
	}

	public static int getCountGames() {
		return countGames;
	}

	public int getId() {
		return id;
	}

	public String getGameType() {
		return gameType;
	}

	public int getCountPlayers() {
		return countPlayers;
	}

	public boolean getGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean value) {
		this.gameStarted = true;
	}

	public String getUserPredictedName() {
		return userPredictedName;
	}

	public void setUserPredictedName(String userPredictedName) {
		this.userPredictedName = userPredictedName;
	}
}
