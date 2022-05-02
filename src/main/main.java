package main;

import java.util.ArrayList;
import java.util.Scanner;
import data.*;
import classification.*;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// fichero csv
		System.out.print("Introduce el nombre del fichero csv: ");
		String fileName = sc.nextLine();
		Dataset iris = new Dataset(fileName);
		// normalizar
		iris.normalize();
		// características para analizar
		System.out.println("Introduce los datos para analizar: ");
		String tempArr[] = iris.getTitulo().split(",");
		ArrayList<Double> values = new ArrayList<Double>();
		double tempDouble = 0;
		for(int i = 0;i < iris.getNumAttributes()-1;i++) {
			System.out.print(tempArr[i] + ":");
			tempDouble = sc.nextDouble();
			values.add(tempDouble);
		}
		// normalizar ins1
		Instance ins1 = new Instance(iris.normalizeIns(values));
		// buscar los k vecinos
		System.out.print("Introduzca los k vecinos para analizar: ");
		int k = sc.nextInt();
		// calcular el tipo
		System.out.println("Tipo de distancia:");
		System.out.println("1.- Euclidea");
		int dist = sc.nextInt();
		KNN knn_ = new KNN(dist);
		String output = knn_.predictType(iris, k, ins1);
		System.out.println(output);
	}
}
