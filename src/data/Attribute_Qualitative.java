package data;

import java.util.ArrayList;

public class Attribute_Qualitative extends Attribute{
	ArrayList<String> name_;
	// Constructor
	Attribute_Qualitative(){
		name_ = new ArrayList<String>();
	}
	// Metodos
	public void Write() {
		for(String name : name_) {
			System.out.println(name);
		}
	}
	@Override
	public void Add(String str) {
		name_.add(str);
	}
}
