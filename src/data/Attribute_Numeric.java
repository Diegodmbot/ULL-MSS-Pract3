package data;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Attribute_Numeric extends Attribute {
	// Atributos
	double max_;
	double min_;
	// Constructor
	Attribute_Numeric(){
		value_ = new ArrayList<Double>();
	}
	// Metodos
	@Override
	public void Add(String str) {
		value_.add(Double.parseDouble(str));
	}
	@Override
	public void Normalize() {
		this.max_ = (double) value_.get(0);
		this.min_ = (double) value_.get(0);
		double tempDouble = 0;
		for(int i = 1; i < value_.size(); i++) {
			tempDouble = (double) value_.get(i);
			if(tempDouble > max_) max_ = tempDouble;
			if(tempDouble < min_) min_ = tempDouble;
		}
		double denominator = max_ - min_;
		DecimalFormat df = new DecimalFormat("#.###");
		for(int i = 0; i < value_.size(); i++) {
			value_.set(i, df.format(((double)value_.get(i) - min_) / denominator));
		}
	}
}
