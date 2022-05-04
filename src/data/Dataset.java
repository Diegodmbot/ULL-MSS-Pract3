package data;

import java.io.*;
import java.util.*;

public class Dataset {
    /*
     * Atributos
     */
    public static final String DELIMETER = ",";
    // cada espacio del array es una columna del fichero csv
    ArrayList<Attribute_Numeric> attributes;
    // atributos normalizados
    ArrayList<Attribute_Numeric> normalizedAttributes;
    // atributos cualitativos
    Attribute_Qualitative qualitativeAttributes;
    // guarda los distintos tipos de flores
    ArrayList<String> types;
    //
    String titulo;
    int numAttributes;
    int numInstances;

    /*
     * Constructor
     */
    public Dataset() {
        attributes = new ArrayList<Attribute_Numeric>();
        normalizedAttributes = new ArrayList<Attribute_Numeric>();
        types = new ArrayList<String>();
        titulo = "";
        numAttributes = 0;
        numInstances = 0;
    }

    public Dataset(String filename) throws IOException {
        read(filename);
    }

    /*
     * Metodos
     */
    public String getTitulo() {
        return titulo;
    }

    public int getNumAttributes() {
        return numAttributes;
    }

    public int getNumInstances() {
        return numInstances;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public String getType(int i) {
        return (String) normalizedAttributes.get(numAttributes - 1).getValue_(i);
    }

    public ArrayList<Double> getInstance(int ins) {
        ArrayList<Double> output = new ArrayList<Double>();
        for (int i = 0; i < numAttributes - 1; i++) {
            output.add((Double) normalizedAttributes.get(i).value_.get(ins));
        }
        return output;
    }

    public void normalize() {
        for (int i = 0; i < numAttributes - 1; i++) {
            normalizedAttributes.get(i).Normalize();
        }
    }

    public ArrayList<Double> normalizeIns(ArrayList<Double> ins) {
        double tempDouble;
        for (int i = 0; i < numAttributes - 1; i++) {
            tempDouble = ins.get(i);
            ins.set(i, normalizedAttributes.get(i).NormalizeVal(tempDouble));
        }
        return ins;
    }

    void read(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        this.titulo = line;
        // Guarda cada valor de la linea en string separados
        String[] tempArr;
        tempArr = line.split(DELIMETER);
        numAttributes = tempArr.length;
        // Crea los ArrayList según los elementos que haya
        attributes = new ArrayList<>(numAttributes - 1);
        normalizedAttributes = new ArrayList<Attribute_Numeric>(numAttributes - 1);
        qualitativeAttributes = new Attribute_Qualitative();
        types = new ArrayList<>();
        for (int i = 0; i < numAttributes - 1; i++) {
            attributes.add(new Attribute_Numeric());
            normalizedAttributes.add(new Attribute_Numeric());
        }
        // Lee cada linea y almacena cada valor en su respectivo atributo
        while ((line = br.readLine()) != null) {
            tempArr = line.split(DELIMETER);
            for (int i = 0; i < numAttributes; i++) {
                if (i == numAttributes-1) {
                    qualitativeAttributes.Add(tempArr[i]);
                    addType(tempArr[i]);
                } else {
                    attributes.get(i).Add(tempArr[i]);
                    normalizedAttributes.get(i).Add(tempArr[i]);
                }
            }
        }
        normalize();
        numInstances = attributes.get(0).Size();
        br.close();
        fr.close();
    }

    public void write() {
        System.out.println(titulo);
        for (int i = 0; i < numInstances; i++) {
            for (int j = 0; j < numAttributes - 1; j++) {
                attributes.get(j).Write(i);
            }
            qualitativeAttributes.Write(i);
            System.out.println();
        }
    }

    public void writeNormalized() {
        System.out.println(titulo);
        for (int i = 0; i < numInstances; i++) {
            for (int j = 0; j < numAttributes - 1; j++) {
                normalizedAttributes.get(j).Write(i);
            }
            qualitativeAttributes.Write(i);
            System.out.println();
        }
    }

    private void addType(String s) {
        int count = 0;
        for (String str : types) {
            if (str.equals(s))
                count++;
        }
        if (count == 0)
            types.add(s);
    }

    public void writeAtribInfo(int i) {
        System.out.println("\tValores: " + attributes.get(i).Size());
        System.out.println("\tMin: " + attributes.get(i).getMin_());
        System.out.println("\tMax: " + attributes.get(i).getMax_());
        System.out.println("\tMedia: " + attributes.get(i).getAvg());
        System.out.println("\tDesviacion Tipica: " + attributes.get(i).getTypicalDesviation());
    }
}
