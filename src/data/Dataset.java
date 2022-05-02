package data;

import java.io.*;
import java.util.*;

public class Dataset {
	// Atributos
	public static final String delimiter = ",";
	ArrayList<Attribute> attributes;
	String titulo;
	int numAttributes;
	int numInstances;

	// Constructor
	public Dataset() {
		attributes = new ArrayList<Attribute>();
		titulo = "";
		numAttributes = 0;
		numInstances = 0;
	}

	public Dataset(String filename) {
		read(filename);
	}

	// Metodos
	public String getTitulo() {
		return titulo;
	}

	public int getNumAttributes() {
		return numAttributes;
	}

	public int getNumInstances() {
		return numInstances;
	}

	public ArrayList<Double> getInstance(int ins) {
		ArrayList<Double> output = new ArrayList<Double>();
		for (int i = 0; i < numAttributes - 1;i++) {
			output.add((Double) attributes.get(i).value_.get(ins));
		}
			return output;
	}

	public void normalize() {
		for (int i = 0; i < numAttributes - 1; i++) {
			attributes.get(i).Normalize();
		}
	}

	public ArrayList<Double> normalizeIns(ArrayList<Double> ins) {
		double tempDouble;
		for (int i = 0; i < numAttributes - 1; i++) {
			tempDouble = ins.get(i);
			ins.set(i, attributes.get(i).NormalizeVal(tempDouble));
		}
		return ins;
	}

	public void add(Instance ins) {
		numInstances++;
		String tempStr;
		for (int i = 0; i < numAttributes - 1; i++) {
			tempStr = ins.GetParam(i) + "";
			attributes.get(i).Add(tempStr);
		}
		attributes.get(numAttributes - 1).Add(ins.GetName());
	}

	void read(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			this.titulo = line;
			// Guarda cada valor de la linea en string separados
			String[] tempArr;
			tempArr = line.split(delimiter);
			numAttributes = tempArr.length;
			attributes = new ArrayList<Attribute>();
			/*
			 * Crea los ArrayList según los elementos que haya
			 */
			for (int i = 0; i < numAttributes - 1; i++) {
				attributes.add(new Attribute_Numeric());
			}
			attributes.add(new Attribute_Qualitative());
			/*
			 * Lee cada linea y almacena cada valor en su respectivo atributo
			 */
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				for (int i = 0; i < numAttributes; i++) {
					attributes.get(i).Add(tempArr[i]);
				}
			}
			numInstances = attributes.get(0).Size();
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void write() {
		System.out.println(titulo);
		for (int i = 0; i < numInstances; i++) {
			for (int j = 0; j < numAttributes; j++) {
				attributes.get(j).Write(i);
			}
			System.out.println();
		}
	}
}
