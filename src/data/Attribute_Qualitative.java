package data;

import java.util.ArrayList;

public class Attribute_Qualitative extends Attribute{
	// Constructor
	Attribute_Qualitative(){
		value_ = new ArrayList<String>();
	}
	// Metodos
	@Override
	public void Add(String str) {
		value_.add(str);
	}
	@Override
	public void Normalize() {}
	@Override
	public Double NormalizeVal(double val) {
		return null;
	}
}
