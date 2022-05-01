package classification;

import java.util.ArrayList;
import data.*;

public class KNN {
	// Atributos
	Environment  neighbours;
	Distance distance_;
	// Constructor
	KNN(){
		neighbours = new Environment();
		distance_ = new Euclidean();
	}
	KNN(Dataset data_, ArrayList<Double> a,int k, int dist) {
		/*
		 * Buscar los k casos de data_ que correspondan con las características de a y almacenarlos en neighbourds
		 * Hacer un conteo de las clases dentro de este conjunto y asignar al nuevo dato la clase más repetida
		 */
	}
	// Metodos
}
