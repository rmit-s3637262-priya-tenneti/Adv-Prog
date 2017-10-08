package com.assignment;

public class Official extends Participant {
/*
 * created an official constructor and called super constructor of participant(super class)
 */
	public Official(String id, String name, int age, String state) {
		super(id, name, age, state);
	}
/*
 * method to summarize the results of athletes in a sorted manner based on their game type
 */
	public void summariseGame(Game game) {
		System.out.println("Game ID: " + game.getId());
		System.out.println("Game Type: " + game.getGameType());
		System.out.println("Official: " + super.getName());
		System.out.println(
				"First: " + game.getAthletesArr().get(0).getName() + "\tFinish Time: " + game.getAthletesArr().get(0).getFinishTime());
		System.out.println(
				"Second: " + game.getAthletesArr().get(1).getName() + "\tFinish Time: " + game.getAthletesArr().get(1).getFinishTime());
		System.out.println(
				"Third: " + game.getAthletesArr().get(2).getName() + "\tFinish Time: " + game.getAthletesArr().get(2).getFinishTime());

	}
}
