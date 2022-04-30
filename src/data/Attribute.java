package data;

import java.util.ArrayList;

public abstract class Attribute {
	// Atributos
	String atribName;
	int index;

	//Constructor
	Attribute() {
		atribName = "";
		index = 0;
	}

	Attribute(String name, int index) {
		atribName = name;
		this.index = index;
	}
	
	// Metodos
	public void setAtribName(String atribName) {
		this.atribName = atribName;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public abstract void Add(String str);
	public abstract void Write();
}
