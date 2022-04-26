package data;
import java.io.*;
import java.util.*;

public class Dataset {
    ArrayList<Instance> instances;
    String titulo;
    int numInstances;

    // Constructor
    public Dataset() {
    	instances = new ArrayList<Instance>(0);
        titulo = "";
    	numInstances = 0;
    }
    public Dataset(String filename) {
        Read(filename);
    }
    public Dataset(ArrayList<Instance> instances) {
        this.instances = instances;
        numInstances = instances.size();
        titulo = "";
    }
    void Read(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            titulo = line;
            line = br.readLine();
            instances = new ArrayList<Instance>();
            while(line != null) {
            	Instance aux = new Instance(line);
                instances.add(aux);
                line = br.readLine();
            }
            numInstances = instances.size();
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void Write() {
    	System.out.println(titulo);
    	for (Instance itr: instances) {
    		itr.Write();
    	}
    }
}
