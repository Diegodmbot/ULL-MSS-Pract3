package main;

import data.*;

public class main {

	public static void main(String[] args) {
		Dataset iris = new Dataset("iris.csv");
		iris.Write();
	}

}
