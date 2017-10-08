package com.assignment;

/*created an abstract class to maintain encapsulation and hide the
 *  inner methods of athlete and official*/ 
public abstract class Participant {
	private String id, name, state;
	private int age;
//constructor 
	public Participant(String id, String name, int age, String state) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setState(state);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void print() {
		System.out.print("\tName:" + this.name +"\tAge:" + this.age + "\tState:" +this.state);
	}
}
