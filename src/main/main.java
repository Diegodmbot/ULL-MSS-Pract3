package main;

import java.util.ArrayList;
import java.util.Scanner;

import classification.*;
import data.*;

public class main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            // fichero csv
            System.out.print("Introduce el nombre del fichero csv: ");
            String fileName = sc.nextLine();
            Dataset iris = new Dataset(fileName);
            while (true) {
                menu(iris);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Menu
    public static void menu(Dataset iris) {
        System.out.println("1.- Mostrar datos");
        System.out.println("2.- Mostrar informacion sobre los atributos");
        System.out.println("3.- Analizar");
        System.out.println("4.- Salir");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1 -> iris.write();
            case 2 -> writeInfo(iris);
            case 3 -> analyzeData(iris);
            case 4 -> System.exit(0);
        }
    }

    // Mostrar información sobre los atributos
    private static void writeInfo(Dataset iris) {
        System.out.println("Atributos: " + iris.getTitulo());
        System.out.println("Numero de atributos numericos: " + iris.getNumAttributes());
        System.out.println("Numero de instancias: " + iris.getNumInstances());
        System.out.println("Numero de clases: " + iris.getTypes().size());
        // Mostrar información relevante de los atributos
        String[] atributos = iris.getTitulo().split(",");
        for (int i = 0; i < iris.getNumAttributes() - 1; i++) {
            System.out.println("Atributo " + atributos[i] + ":");
            iris.writeAtribInfo(i);
        }
        System.out.println("Numero de atributos cualitativos: " + iris.getNumQualitativeAttributes());
        for (int i = 0; i < iris.getTypes().size(); i++) {
            iris.writeQualitativeInfo(i);
        }
    }

    // Analizar
    public static void analyzeData(Dataset iris) {
        System.out.println("Introduzca el tipo de preprocesado: ");
        System.out.println("1.- Sin procesar");
        System.out.println("2.- Normalizar");
        System.out.println("3.- Estadarizar");
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1:
                break;
            case 3:
                iris.standardize();
                break;
            default:
                iris.normalize();
                break;
        }
        System.out.println("Introduce los datos para analizar: ");
        Scanner sc = new Scanner(System.in);
        String[] tempArr = iris.getTitulo().split(",");
        ArrayList<Double> values = new ArrayList<>();
        double tempDouble;
        for (int i = 0; i < iris.getNumAttributes() - 1; i++) {
            System.out.print(tempArr[i] + ":");
            tempDouble = sc.nextDouble();
            values.add(tempDouble);
        }
        Instance ins1 = null;
        switch (option) {
            case 1:
                ins1 = new Instance(values);
                break;
            case 3:
                ins1 = new Instance(iris.standardizeIns(values));
                break;
            default:
                ins1 = new Instance(iris.normalizeIns(values));
                break;
        }
        // buscar los k vecinos
        System.out.print("Introduzca los k vecinos para analizar: ");
        int k = sc.nextInt();
        // calcular el tipo
        System.out.println("Tipo de distancia:");
        System.out.println("1.- Euclidea");
        System.out.println("2.- Manhattan");
        System.out.println("3.- Chebychef");
        int dist = sc.nextInt();
        KNN knn_ = new KNN(dist);
        String output = knn_.predictType(iris, k, ins1);
        System.out.println("La clase sera: " + output);
    }
}


