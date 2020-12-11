package Uppgift4;

import java.util.ArrayList;

public class PersonList {
	private ArrayList<Object> list = new ArrayList<>();

	public ArrayList<Object> getList() {
		return list;
	}

	public void setList(Person person) {
		this.list.add(person);
	}

}
