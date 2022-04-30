package classification;

import java.util.ArrayList;
import data.*;

public class Environment {
	// Atributos
	ArrayList<Instance> neighbourds;
	int numNeighbourds;
	//Constructor
	Environment(){
		neighbourds = new ArrayList<Instance>();
		numNeighbourds = 0;
	}
}
