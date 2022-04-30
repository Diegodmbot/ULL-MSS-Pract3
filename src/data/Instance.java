package data;

import java.util.ArrayList;

public class Instance {
	// Atributos
    private ArrayList<Double> flowerParams;
    private String flowerName;

    // Constructor
    public Instance() {
    	this.flowerName = "";
    	for(double param : this.flowerParams) {
    		param = 0;
    	}
    }    
    public Instance(String flowerName, ArrayList<Double> flowerParams) {
        this.flowerName = flowerName;
        this.flowerParams = flowerParams;
    }
    // Metodos
    public void Write() {
    	System.out.print("Características: ");
    	for(double param : this.flowerParams) {
    		System.out.print(param + " ");
    	}
    	
    	System.out.println("Nombre: " + this.flowerName);
    }
}
