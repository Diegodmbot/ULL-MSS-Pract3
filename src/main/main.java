package main;

import java.util.ArrayList;
import java.util.Scanner;
import data.*;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// fichero csv
		System.out.print("Introduce el nombre del fichero csv: ");
		String fileName = sc.nextLine();
		Dataset iris = new Dataset(fileName);
		iris.Write();
		// características para analizar
		System.out.println("Introduce los datos para analizar: ");
		String tempArr[] = iris.getTitulo().split(",");
		ArrayList<Double> values = new ArrayList<Double>();
		double tempDouble = 0;
		for(int i = 0;i < iris.getAttributes()-1;i++) {
			System.out.print(tempArr[i] + ":");
			tempDouble = sc.nextDouble();
			values.add(tempDouble);
		}
		Instance ins1 = new Instance(values);
		iris.Add(ins1);
		// normalizar
		iris.Normalize();
		System.out.print("Datos normalizados: ");
		iris.Write();
		// calcular el tipo
		
	}
}
