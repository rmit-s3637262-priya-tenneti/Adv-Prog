package com.assignment;

import java.util.Random;

public class Athlete extends Participant {

	private String type;
	private int point;
	private boolean played;
	private float finishTime;

	/*
	 * add a constructor for athlete to pass the argument values to the instance
	 * variables and added a super constructor of participant to call some
	 * variables
	 */
	public Athlete(String id, String name, int age, String state, String type, int point) {
		super(id, name, age, state);
		this.type = type;
		this.point = point;
		this.played = false;
	}

	/*
	 * added method for setting a start time and finishing time of all games
	 */
	public void compete(int startTime, int endTime) {
		this.played = true;
		Random rand = new Random();
		this.setFinishTime(rand.nextFloat() * (endTime - startTime) + startTime);
	}

	/**
	 * Overridden Method of participant to print the athlete names, age and
	 * state
	 */
	public void print() {
		super.print();
		System.out.print("\tType:" + this.type);
	}

	public void updatePoints(int point) {
		this.point += point;
	}

	public float getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(float finishTime) {
		this.finishTime = finishTime;
	}

	public int getPoint() {
		return point;
	}

	public String getType() {
		return type;
	}

	public boolean isPlayed() {
		return played;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}

}
