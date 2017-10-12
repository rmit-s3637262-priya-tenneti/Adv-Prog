/**Author : s3640623 - Rochelle Maria Gracias */

package utilities;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import assignment.Game;

public class GameData {

	private static HashMap<Integer, Game> hmGame = new HashMap<Integer, Game>();
	private static int countGames;

	public static void writeToGameFile(Game game) throws FileRelatedExceptions {
		try {
			FileOutputStream fos = new FileOutputStream("GameData.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(game);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			throw new FileRelatedExceptions("File Related Excetion!\n", ex);
		}
	}

	public static void readFromGameFile() throws FileRelatedExceptions {

		try {
			FileInputStream fis = new FileInputStream("GameData.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while (true) {
				try {
					Game game = (Game) ois.readObject();
					hmGame.put(game.getId(), game);
				} catch (EOFException e) {
					break; // Break when the end-of-file is reached
				}
			}

			GameData.countGames = hmGame.size();

			ois.close();
			fis.close();
		} catch (ClassNotFoundException ex) {
			throw new FileRelatedExceptions("File Related Excetion!\n", ex);
		} catch (IOException ex) {
			throw new FileRelatedExceptions("File Related Excetion!\n", ex);
		}
	}

	public static void incrCountGames() {
		countGames = (getCountGames() + 1);
	}

	public static HashMap<Integer, Game> getHmGame() {
		return hmGame;
	}

	public static void addToHmGame(Game game) {
		incrCountGames();
		hmGame.put(countGames, game);
	}

	public static int getCountGames() {
		return countGames;
	}

}
