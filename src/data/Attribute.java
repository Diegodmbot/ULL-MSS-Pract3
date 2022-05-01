package data;

import java.util.ArrayList;

public abstract class Attribute {
	// Atributos
	String atribName;
	int index;
	ArrayList value_;

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
	public int Size() {
		return value_.size();
	}
	public void Write(){
		for(Object val : value_) {
			System.out.println(val);
		}
	}
	public void Write(int i){
		System.out.print(value_.get(i) + " ");
	}
	public abstract void Normalize();
	public abstract void Add(String str);
	public abstract Double NormalizeVal(double val);

}
