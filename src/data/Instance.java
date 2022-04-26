package data;

import java.io.*;

public class Instance {
    private double[] flowerParams;
    private String flowerName;

    // Constructor
    public Instance() {
    	this.flowerName = "";
    	for(double param : this.flowerParams) {
    		param = 0;
    	}
    }
    public Instance(String line) {
        String[] tokens = line.split(",");
        this.flowerParams = new double[tokens.length-1];
        for (int i = 0; i < flowerParams.length; i++) {
            flowerParams[i] = Double.parseDouble(tokens[i]);
        }
        this.flowerName = tokens[tokens.length-1];
    }
    public Instance(String flowerName, double[] flowerParams) {
        this.flowerName = flowerName;
        this.flowerParams = flowerParams;
    }
    public void Read(BufferedReader br) throws IOException {
        String line = br.readLine();
        String[] tokens = line.split(",");
        this.flowerParams = new double[tokens.length - 1];
        for (int i = 0; i < flowerParams.length; i++) {
            flowerParams[i] = Double.parseDouble(tokens[i]);
        }
        this.flowerName = tokens[tokens.length];
    }
    public void Write() {
    	System.out.print("Características: ");
    	for(double param : this.flowerParams) {
    		System.out.print(param + " ");
    	}
    	System.out.println("Nombre: " this.flowerName);
    }
}
