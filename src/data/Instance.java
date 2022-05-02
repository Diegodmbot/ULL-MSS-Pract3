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
    public Instance(ArrayList<Double> flowerParams) {
        this.flowerParams = flowerParams;
        this.flowerName = "";
    }
    // Metodos
    public ArrayList<Double> GetParams(){
    	return flowerParams;
    }
    public double GetParam(int i) {
    	return flowerParams.get(i);
    }
    public String GetName() {
    	return flowerName;
    }
    public void Write() {
    	System.out.print("Características: ");
    	for(double param : this.flowerParams) {
    		System.out.print(param + " ");
    	}
    	
    	System.out.println("Nombre: " + this.flowerName);
    }
}
