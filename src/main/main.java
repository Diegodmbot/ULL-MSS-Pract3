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
        System.out.println("2.- Mostrar datos normalizados");
        System.out.println("3.- Mostrar informacion sobre los atributos");
        System.out.println("4.- Analizar");
        System.out.println("5.- Salir");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                iris.write();
                break;
            case 2:
                iris.writeNormalized();
                break;
            case 3:
                writeInfo(iris);
                break;
            case 4:
                analyzeData(iris);
                break;
            case 5:
                System.exit(0);
        }
    }

    // Mostrar información sobre los atributos
    private static void writeInfo(Dataset iris) {
        System.out.println("Atributos: " + iris.getTitulo());
        System.out.println("Numero de atributos: " + iris.getNumAttributes());
        System.out.println("Numero de instancias: " + iris.getNumInstances());
        System.out.println("Numero de clases: " + iris.getTypes().size());
        // Mostrar información relevante de los atributos
        String atributos[] = iris.getTitulo().split(",");
        for (int i = 0; i < iris.getNumAttributes() - 1; i++) {
            System.out.println("Atributo " + atributos[i] + ":");
            iris.writeAtribInfo(i);
        }
    }

    // Analizar
    public static void analyzeData(Dataset iris) {
        System.out.println("Introduce los datos para analizar: ");
        Scanner sc = new Scanner(System.in);
        String tempArr[] = iris.getTitulo().split(",");
        ArrayList<Double> values = new ArrayList<Double>();
        double tempDouble = 0;
        for (int i = 0; i < iris.getNumAttributes() - 1; i++) {
            System.out.print(tempArr[i] + ":");
            tempDouble = sc.nextDouble();
            values.add(tempDouble);
        }
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

    // Limpiar pantalla
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}


