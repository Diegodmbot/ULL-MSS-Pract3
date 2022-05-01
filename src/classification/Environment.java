package classification;

import java.util.ArrayList;
import data.*;

public class Environment {
	// Atributos
	ArrayList<Instance> instances;
	int numInstances;
	//Constructor
	Environment(){
		instances = new ArrayList<Instance>();
		numInstances = 0;
	}
	Environment(ArrayList<Instance> instances){
		this.instances = instances;
		this.numInstances = instances.size();
	}
	// Metodos
}
