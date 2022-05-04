package data;

import java.util.ArrayList;
import information.*;
import normalization.*;

public class Attribute_Numeric implements Attribute, Normalization, NumericInformation {
	// Atributos
	ArrayList<Double> value_;
	double max_;
	double min_;
	double denominator;
	// Constructor
	Attribute_Numeric(){
		value_ = new ArrayList<Double>();
	}

	private void calculateMaxMin() {
		this.max_ = (double) value_.get(0);
		this.min_ = (double) value_.get(0);
		double tempDouble = 0;
		for(int i = 1; i < value_.size(); i++) {
			tempDouble = (double) value_.get(i);
			if(tempDouble > max_) max_ = tempDouble;
			if(tempDouble < min_) min_ = tempDouble;
		}
	}
	/*
	Metodos de la clase Attribute
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

	@Override
	public void Add(String str) {
		value_.add(Double.parseDouble(str));
	}

	/*
	Métodos de la clase NumericInformation
	 */
	@Override
	public double getMax_() {
		return max_;
	}
	@Override
	public double getMin_() {
		return min_;
	}
	@Override
	public double getAvg(){
		double media = 0;
		for (int i = 0; i < value_.size(); i++) {
			media += (double)value_.get(i);
		}
		return media/value_.size();
	}
	@Override
	public double getTypicalDesviation() {
		double media = getAvg();
		double suma = 0;
		for (int i = 0; i < value_.size(); i++) {
			suma += Math.pow((double)value_.get(i) - media, 2);
		}
		return Math.sqrt(suma/value_.size());
	}

	/*
	Métodos de la clase Normalization
	 */
	@Override
	public void Normalize() {
		calculateMaxMin();
		this.denominator = max_ - min_;
		for(int i = 0; i < value_.size(); i++) {
			value_.set(i, NormalizeVal((double)value_.get(i)));
		}
	}
	@Override
	public Double NormalizeVal(double val) {
		return (val - min_) / denominator;
	}
}
