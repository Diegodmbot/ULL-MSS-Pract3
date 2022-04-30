package data;

import java.io.*;
import java.util.*;

public class Dataset {
	// Atributos
	public static final String delimiter = ",";
	ArrayList<Attribute> attributes;
	String titulo;
	int numInstances; // no aplicado
	int numAttributes;

	// Constructor
	public Dataset() {
		attributes = new ArrayList<Attribute>();
		titulo = "";
		numAttributes = 0;
	}

	public Dataset(String filename) {
		Read(filename);
	}

	public Dataset(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
		numAttributes = attributes.size();
		titulo = "";
	}
	
	// Metodos
	void Read(String fileName) {
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
			 * Crea los ArrayList según cuantos elemntos haya
			 */
			for(int i = 0; i < numAttributes - 1; i++) {
				attributes.add(new Attribute_Numeric());
			}
			attributes.add(new Attribute_Qualitative());
			/*
			 * Lee cada linea y almacena cada valor en su respectivo atributo
			 */
            while((line = br.readLine()) != null) {
            	tempArr = line.split(delimiter);
            	for(int i = 0; i < numAttributes; i++) {
            		attributes.get(i).Add(tempArr[i]);
            	}
            }
            br.close();
            fr.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void Write() {
		System.out.println(titulo);
		for (Attribute atr : attributes) {
			atr.Write();
		}
	}
}
