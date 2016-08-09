package com.openet.nblott;

import java.util.ArrayList;

public class Sim {
	
	protected ArrayList<Entity> parts;	

	public Sim(ArrayList<Entity> e) {
		parts = e;
	}
	
	public Sim() {
		parts = new ArrayList<Entity>();
	}

	public void setEnts(ArrayList<Entity> e) {
		parts = e;
	}

	public ArrayList<Entity> getEnts() {
		return parts;
	}

	public void update() {
		for (int i =0 ; i < parts.size() ; i++)
		{
			parts.get(i).update();
		}
	}

	public void print() {
		for (int i = 0 ; i < parts.size() ; i++)
		{
			parts.get(i).print();
		}
	}
}
