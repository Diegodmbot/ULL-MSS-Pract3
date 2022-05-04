package data;

import java.util.ArrayList;

public class Attribute_Qualitative implements Attribute {
	ArrayList<String> value_;
	// Constructor
	Attribute_Qualitative(){
		value_ = new ArrayList<String>();
	}

	/*
	Metodos de la interfaz Attribute
	 */
	@Override
	public Object getValue_(int i) {
		return value_.get(i);
	}

	@Override
	public int Size() {
		return value_.size();
	}

	@Override
	public void Write(int i) {
		System.out.print(value_.get(i) + " ");
	}

	// Metodos
	@Override
	public void Add(String str) {
		value_.add(str);
	}
}
