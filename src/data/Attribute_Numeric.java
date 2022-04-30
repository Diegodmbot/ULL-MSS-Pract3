package data;

import java.util.ArrayList;

public class Attribute_Numeric extends Attribute {
	// Atributos
	ArrayList<Double> value_;
	// Construsctor
	Attribute_Numeric(){
		value_ = new ArrayList<Double>();
	}
	// Metodos
	@Override
	public void Add(String str) {
		value_.add(Double.parseDouble(str));
	}
	@Override
	public void Write() {
		for(Double val : value_) {
			System.out.println(val);
		}
	}
}
