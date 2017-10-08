package com.assignment;

import java.util.*;

/*
 * created a class for implementing all functionalities in the application
 */
public class Driver implements Drivable {

	private static boolean gameSelected = false;
	private static boolean winnerPredicted = false;
	private static boolean participantSelected = false;
	private static boolean gameStarted = false;

	private static int gameType;

	private static Scanner input = new Scanner(System.in);
	private Data loadData = new Data();

	private static HashMap<Integer, Game> hmGame = new HashMap<Integer, Game>();
	private static List<Athlete> lAthlete = new ArrayList<Athlete>();

	/*
	 * constructor to load the data of athletes and officials from the data
	 * class
	 * 
	 */
	Driver() {
		Data.loadAthlethes();
		Data.loadOfficials();
	}

	/*
	 * created a method to provide a menu driven application for the program
	 * according to the requirement
	 */
	public void mainMenu() {
		System.out.println("\n**Ozlympic Game**");
		System.out.println("1. Select Game Type");
		System.out.println("2. Add Participants to select Game Type");
		System.out.println("3. Predict Winner of the current Game");
		System.out.println("4. Start Game");
		System.out.println("5. Re-run the last Game");
		System.out.println("6. Display the final results of all games");
		System.out.println("7. Display the points of all athletes");
		System.out.println("8. Exit");
		int option = 0;
		do {
			try {
				System.out.print("Enter an option: ");
				option = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Sorry only integers!!\n");
				input.next();
			}
		} while (option < 1 || option > 8);
		switch (option) {
		case 1:
			selectGame();
			break;
		case 2:
			addParticipant();
			break;
		case 3:
			predictWinner();
			break;
		case 4:
			startGame();
			break;
		case 5:
			reRun();
			break;
		case 6:
			displayResultsOfGames();
			break;
		case 7:
			displayResultsOfAthlete();
			break;
		case 8:
			System.out.println("**Exiting application**\nBye!");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	/**
	 * <summary> Method to Select Game from a subMenu the Game type 1.Running
	 * 2.Swimming 3.Cycling or 4.Exit to main Menu. Only allows integer input
	 * from user else throws InputMismatchException Exception, which is handled
	 * and allows you to re-enter an option from the sub-menu </summary>
	 * 
	 */
	public void selectGame() {
		if (!gameSelected) {
			System.out.println("\n**Select the Game**");
			System.out.println("1. Running");
			System.out.println("2. Swimming");
			System.out.println("3. Cycling");
			System.out.println("4. Exit");
			do {
				try {
					System.out.print("Enter an option: ");
					gameType = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.print("Sorry only integers!!\n");
					input.next();
				}
			} while (gameType < 1 || gameType > 4);
			if (!(gameType == 4)) {
				gameSelected = true;
				System.out.println("Game Type " + getType() + " selected\n*Hint: Select option 2. Add Participants*");
			} else
				System.out.println("**Warning**Exited without selecting game*");
		} else
			System.out.println(
					"Game Type " + getType() + " already selected.\n*Hint: Select option 2. Add Participants*");
	}

	/**
	 * <summary> Method to Add Participants - Athletes and Officials, to a
	 * Selected Game. Can Add Participants only after user Selects a Game Type.
	 * Only integer input from user else throws InputMismatchException
	 * Exception, which is handled and allows you to re-enter an option from the
	 * sub-menu. Asks user to enter the number of athletes that wishes to
	 * participate in the Select Game Type. Minimum athlete that can participate
	 * is 5 and maximum athlete that can participate is 8 </summary>
	 */
	public void addParticipant() {
		if (gameSelected) {
			if (!participantSelected) {

				int numOfPlayers = 0;
				int temp = 0;

				ArrayList<Athlete> athArr = new ArrayList<Athlete>();
				Athlete[] tempAthArr = (Athlete[]) loadData.getAthlete();

				System.out.println("**Add Game Participants**");
				/* Adding Athletes */
				do {
					try {
						System.out.print("Enter the number of athletes(Min:5-Max:8):");
						numOfPlayers = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
					}
				} while (numOfPlayers < 5 || numOfPlayers > 8);
				for (int i = 0; i < tempAthArr.length; i++) {
					System.out.println();
					System.out.print((i + 1) + ".");
					tempAthArr[i].print();
				}

				System.out.print("\nChoose the number corresponding to the athlete you wish to add!\n");
				for (int i = 0; i < numOfPlayers; i++) {
					try {
						System.out.print("Athlete[" + (i + 1) + "]:");
						temp = input.nextInt();
						if (isValid(tempAthArr[temp - 1].getType())) {
							if (!athArr.contains(tempAthArr[temp - 1])) {
								athArr.add(tempAthArr[temp - 1]);
								if (!lAthlete.contains(tempAthArr[temp - 1]))
									lAthlete.add(tempAthArr[temp - 1]);
							} else {
								System.out.print("Already participating in current game. Choose another athlete.\n");
								i--;
							}
						} else {
							System.out.print(
									"Wrong athlete type selected.\n*Hint: Please check the type before selecting.\n");
							i--;
						}
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
						i--;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.print("Sorry please choose only from the options provided!!\n");
						input.next();
						i--;
					}
				}

				/* Adding Officials from the data class */
				System.out.print("Choose the number corresponding to the official you wish to add!\n");
				Official[] tempOffArr = (Official[]) loadData.getOfficials();
				for (int i = 0; i < tempOffArr.length; i++) {
					System.out.print((i + 1) + ".");
					tempOffArr[i].print();
					System.out.println(" ");
				}

				do {
					try {
						System.out.print("Enter option from list:");
						temp = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.print("Sorry please choose only from the options provided!!\n");
						input.next();
					}
				} while (temp < 1 || temp > tempOffArr.length);
				Official official = tempOffArr[temp - 1];

				int id = Game.getCountGames();
				Game game = new Game(id, getType(), numOfPlayers, official, athArr);
				hmGame.put(id, game);

				participantSelected = true;
				System.out.println("Participants  added.\n*Hint: Select option 3.Predict winner*");
			} else
				System.out.println("Participants already added.\n*Hint: Select option 3.Predict winner*");
		} else
			System.out.println("*Hint: Select option 1.Select the game*");
	}

	/**
	 * OverLoading the AddParticipant for re-running the game by using the last
	 * existing game instance
	 */
	public void addParticipant(Game game) {
		if (gameSelected) {
			if (!participantSelected) {

				int numOfPlayers = 0;
				int temp = 0;
				ArrayList<Athlete> athArr = new ArrayList<Athlete>();
				Athlete[] tempAthArr = (Athlete[]) loadData.getAthlete();

				System.out.println("**Add Game Participants**");

				/* Adding Athletes */
				do {
					try {
						System.out.print("Enter the number of athletes(Min:5-Max:8):");
						numOfPlayers = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
					}
				} while (numOfPlayers < 5 || numOfPlayers > 8);
				for (int i = 0; i < tempAthArr.length; i++) {
					System.out.print((i + 1) + ".");
					tempAthArr[i].print();
					System.out.println();
				}

				System.out.print("Choose the number corresponding to the athlete you wish to add!\n");
				for (int i = 0; i < numOfPlayers; i++) {
					try {
						System.out.print("Athlete[" + (i + 1) + "]:");
						temp = input.nextInt();
						if (isValid(tempAthArr[temp - 1].getType())) {
							if (!athArr.contains(tempAthArr[temp - 1])) {
								athArr.add(tempAthArr[temp - 1]);
								if (!lAthlete.contains(tempAthArr[temp - 1]))
									lAthlete.add(tempAthArr[temp - 1]);
							} else {
								System.out.print("Already participating in current game. Choose another athlete.\n");
								i--;
							}
						} else {
							System.out.print(
									"Wrong athlete type selected.\n*Hint: Please check the type before selecting.\n");
							i--;
						}
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
						i--;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.print("Sorry please choose only from the options provided!!\n");
						input.next();
						i--;
					}
				}

				/* Adding Official */
				System.out.print("Choose the number corresponding to the official you wish to add!\n");
				Official[] tempOffArr = (Official[]) loadData.getOfficials();
				for (int i = 0; i < tempOffArr.length; i++) {
					System.out.print((i + 1) + ".");
					tempOffArr[i].print();
					System.out.println(" ");
				}

				do {
					try {
						System.out.print("Enter option from list:");
						temp = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.print("Sorry please choose only from the options provided!!\n");
						input.next();
					}
				} while (temp < 1 || temp > tempOffArr.length);
				Official official = tempOffArr[temp - 1];

				/*
				 * Replacing the new Participants and updating the already
				 * existing gameID in the hashMap
				 */
				game.setParticipants(getType(), numOfPlayers, official, athArr);
				hmGame.put(game.getId(), game);

				participantSelected = true;
				System.out.println("Participants  added.\n*Hint: Select option Predict winner*");
			} else
				System.out.println("Participants already added.\n*Hint: Select option Predict winner*");
		} else
			System.out.println("*Hint: Select option Select the game*");
	}

	/**
	 * <summary> Method to allow the user to predict a name from the list of
	 * players in a game. Only integer input from user else throws
	 * InputMismatchException Exception, which is handled and allows you to
	 * re-enter an option from the sub-menu</summary>
	 */
	public void predictWinner() {
		if (gameSelected) {
			if (participantSelected) {
				int userPredictionIndex = 0;
				int id = Game.getCountGames();
				Game game = hmGame.get(id);

				System.out.print("\n**Predict the winner**\n");
				for (int i = 0; i < game.getCountPlayers(); i++) {
					System.out.print((i + 1) + ".");
					game.printName(game.getAthletesArr().get(i));
					System.out.println();
				}
				do {
					try {
						System.out.print("Enter option:");
						userPredictionIndex = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
					}
				} while (userPredictionIndex < 1 || userPredictionIndex > game.getCountPlayers());

				game.setUserPredictedName(game.getAthletesArr().get(userPredictionIndex - 1).getName());

				System.out.println("*Hint: Select option 4.Start game*");
				winnerPredicted = true;
			} else
				System.out.println("*Hint: Select option 2.Add Participants*");
		} else
			System.out.println("*Hint: Select option 1.Select the game*");
	}

	/**
	 * OverLoading predict winner for re-running the game by using the last
	 * existing game instance
	 */
	public void predictWinner(Game game) {
		if (gameSelected) {
			if (participantSelected) {
				int userPredictionIndex = 0;
				hmGame.get(game.getId());

				System.out.print("\n**Predict the winner**\n");
				for (int i = 0; i < game.getCountPlayers(); i++) {
					System.out.print((i + 1) + ".");
					game.printName(game.getAthletesArr().get(i));
					System.out.println();
				}

				do {
					try {
						System.out.print("Enter option:");
						userPredictionIndex = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.print("Sorry only integers!!\n");
						input.next();
					}
				} while (userPredictionIndex < 1 || userPredictionIndex > game.getCountPlayers());

				game.setUserPredictedName(game.getAthletesArr().get(userPredictionIndex - 1).getName());

				System.out.println("*Hint: Select option 4.Start game*");
				winnerPredicted = true;
			} else
				System.out.println("*Hint: Select option 2.Add Participants*");
		} else
			System.out.println("*Hint: Select option 1.Select the game*");
	}

	/**
	 * <summary> Method to allow Start the game. Displays result plus checks
	 * prediction.</summary>
	 */
	public void startGame() {
		Random random = new Random();
		if (gameSelected) {
			if (participantSelected) {
				if (winnerPredicted) {

					int id = Game.getCountGames();
					Game game = hmGame.get(id);

					if (game.getGameType().equals("Running"))
						game.startGame(SPRINTER_START_TIME,
								random.nextInt((SPRINTER_END_TIME - SPRINTER_START_TIME) + SPRINTER_START_TIME));
					else if (game.getGameType().equals("Swimming"))
						game.startGame(SWIMMER_START_TIME,
								random.nextInt((SWIMMER_END_TIME - SWIMMER_START_TIME) + SWIMMER_START_TIME));
					else if (game.getGameType().equals("Cycling"))
						game.startGame(CYCLIST_START_TIME,
								random.nextInt(CYCLIST_END_TIME - CYCLIST_START_TIME) + CYCLIST_START_TIME);

					System.out.println("**Game Results**");
					game.displayResult();

					checkWinner();
					game.setGameStarted(true);
					gameStarted = true;
					
					gameSelected = false;
					winnerPredicted = false;
					participantSelected = false;

					Game.incrCountGames();
					
					System.out.println(
							"*Hint: Select option \n1.Select the Game \n5.Re-run the last game \n6.Display the final results of all games \n7.Display the points of all athletes*");
				} else
					System.out.println("*Hint: Select option 3.Predict the winner*");
			} else
				System.out.println("*Hint: Select option 2.Add Participants*");
		} else
			System.out.println("*Hint: Select option 1.Select the game*");
	}

	/** Checks if the user prediction is correct or wrong. */
	public void checkWinner() {
		int id = Game.getCountGames();
		Game game = hmGame.get(id);
		String userPredictedName = game.getUserPredictedName();
		if (userPredictedName.equalsIgnoreCase(game.getAthletesArr().get(0).getName()))
			System.out.println("\nCONGRATULATION! Your prediction is correct.\nYour predicted winner was "
					+ game.getUserPredictedName());
		else
			System.out.println(
					"\nSorry! Your prediction is wrong.\nYour predicted winner was " + game.getUserPredictedName()
							+ ". Actual Winner is" + " " + game.getAthletesArr().get(0).getName());

	}

	/** Checks if the user prediction is correct or wrong. */
	public void checkWinner(Game game) {
		game = hmGame.get(game.getId());

		String userPredictedName = game.getUserPredictedName();
		if (userPredictedName.equalsIgnoreCase(game.getAthletesArr().get(0).getName()))
			System.out.println("\nCONGRATULATION! Your prediction is correct.\nYour predicted winner was "
					+ game.getUserPredictedName());
		else
			System.out.println(
					"\nSorry! Your prediction is wrong.\nYour predicted winner was " + game.getUserPredictedName()
							+ ". Actual Winner is" + " " + game.getAthletesArr().get(0).getName());

	}

	/**
	 * <summary> Method to allow re-run last game</summary>
	 */
	public void reRun() {
		Random random = new Random();
		if (gameStarted) {
			if (gameSelected == false && participantSelected == false && winnerPredicted == false) {
				char option;
				int id = Game.getCountGames();
				// Last Game ID
				Game game = hmGame.get(id - 1);
				if (game.getGameStarted()) {

					gameSelected = true;
					// Want to run with existing participants or add new
					// participants
					do {
						System.out.println("You want to re-enter the particpants?(Y/N)");
						option = input.next().charAt(0);
					} while (option != 'Y' && option != 'N' && option != 'y' && option != 'n');
					if (option == 'Y' || option == 'y' || game.getAthletesArr().isEmpty()) {
						addParticipant(game);
					} else
						participantSelected = true;

					do {
						System.out.println("You want to re-predict the winner?(Y/N)");
						option = input.next().charAt(0);
					} while (option != 'Y' && option != 'N' && option != 'y' && option != 'n');
					if (option == 'Y' || option == 'y' || game.getUserPredictedName().equals(null)) {
						predictWinner(game);
					} else
						winnerPredicted = true;

					if (game.getGameType().equals("Running"))
						game.startGame(SPRINTER_START_TIME,
								random.nextInt((SPRINTER_END_TIME - SPRINTER_START_TIME) + SPRINTER_START_TIME));
					else if (game.getGameType().equals("Swimming"))
						game.startGame(SWIMMER_START_TIME,
								random.nextInt((SWIMMER_END_TIME - SWIMMER_START_TIME) + SWIMMER_START_TIME));
					else if (game.getGameType().equals("Cycling"))
						game.startGame(CYCLIST_START_TIME,
								random.nextInt(CYCLIST_END_TIME - CYCLIST_START_TIME) + CYCLIST_START_TIME);

					System.out.println("**Game Results**");
					game.displayResult();

					checkWinner(game);

					gameSelected = false;
					winnerPredicted = false;
					participantSelected = false;

					System.out.println(
							"*Hint: Select option \n1.Select the Game \n5.Re-run the last game \n6.Display the final results of all games \n7.Display the points of all athletes*");
				} else
					System.out.println("Start the Game before choosing re-run!");
			} else
				System.out.println("You need to complete the Game you started!");
		} else
			System.out.println(
					"Start atleast one game before re-run\n*Hint: Select option \n1.Select the Game \n2.Add participants \n3.Predict the winner \n4.Start the Game *");
	}

	public void displayResultsOfGames() {
		if (hmGame.isEmpty() || gameStarted == false)
			System.out.println("No Games to be displayed!");
		else {
			for (Integer key : hmGame.keySet()) {
				if (hmGame.get(key).getGameStarted())
					hmGame.get(key).displayResult();
			}
		}
	}

	/*
	 * Method for displaying the points in a sorted order by ensuring to make
	 * all members with the same points has sorted based on their alphabetical
	 * order of names
	 */
	public void displayResultsOfAthlete() {
		if (lAthlete.isEmpty() || gameStarted == false)
			System.out.println("No athletes to be displayed!");
		else {
			Collections.sort(lAthlete, new Comparator<Athlete>() {
				public int compare(Athlete one, Athlete other) {
					if (one.getPoint() == other.getPoint())
						return one.getName().compareTo(other.getName());
					else if (one.getPoint() < other.getPoint())
						return 0;
					else
						return -1;

				}
			});

			for (int i = 0; i < lAthlete.size(); i++) {
				if (lAthlete.get(i).isPlayed()) {
					System.out.print("\n" + (i + 1) + ".");
					System.out.print("Name:" + lAthlete.get(i).getName() + "\tType: " + lAthlete.get(i).getType()
							+ "\tPoints: " + lAthlete.get(i).getPoint());
				} else if (hmGame.isEmpty())
					System.out.println("No athletes to display has none have paticipated in any game.");
			}
		}
	}

	public String getType() {
		if (gameType == 1)
			return "Running";
		else if (gameType == 2)
			return "Swimming";
		else if (gameType == 3)
			return "Cycling";
		else
			return "Invalid Type";
	}

	public boolean isValid(String type) {
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
