package es.unex.cum.reto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	private ArrayList <String> triangulos = new ArrayList<String>();
	public static void main(String[] args) {
		int ntriangulos;
		Main M = new Main();
		Scanner sc = new Scanner(System.in);
		ntriangulos = sc.nextInt(); //lectura del numero de triangulos que se van a evaluar
		M.leerCoordenadas(ntriangulos); //metodo para leer las coordenadas de los triangulos
		M.calcularLados();//Metodo que evalua los triangulos introducidos.
		sc.close();
	}
	/**
	 * Metodo que lee las coordenadas de los triangulos
	 * @param ntriangulos
	 */
	public void leerCoordenadas(int ntriangulos) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < ntriangulos; i++) {
			/* Se leen las coordenadas y se introducen en una lista */
			String coordenadas = sc.nextLine();
			triangulos.add(coordenadas);
		}
		sc.close();
	}
	/**
	 * Metodo que calcula los lados
	 */
	public void calcularLados() {
		Punto [] puntos = new Punto[3];
		int cont = 0;
		double lado1, lado2, lado3; //Estas variables contendran la longitud de los lados
		int x = 0, y = 0;
		for (String c : triangulos) {
			/* Se leen las coordenadas introducidas en la lista para calcular la distancia entre puntos */
			StringTokenizer tokens = new StringTokenizer(c);			
			while (tokens.hasMoreTokens() && cont < 3) {	
				String xy = tokens.nextToken();
				StringTokenizer tokensPunto = new StringTokenizer(xy, ",");
				x = Integer.parseInt(tokensPunto.nextToken());
				y = Integer.parseInt(tokensPunto.nextToken());
				Punto P = new Punto(x, y);
				puntos[cont] = P;
				cont++;
			}
			/* Calculo de las distancias entre puntos */
			lado1 = puntos[0].distancia(puntos[1]); //Vertice 0 con vertice 1
			lado2 = puntos[0].distancia(puntos[2]); //Vertice 0 con vertice 2
			lado3 = puntos[1].distancia(puntos[2]); //Vertice 1 con vertice 2
			mostrarResultado(lado1, lado2, lado3);
			/* Se reinician en array y el contador */
			puntos = new Punto[3];
			cont = 0;
		}
		
	}
	
	public void mostrarResultado(double lado1, double lado2, double lado3) {
		

		if (lado1 == lado2) {
			if (lado1 == lado3) {
				System.out.println("Equilátero");
			}
			else {
				System.out.println("Isósceles");
			}
		}
		else {
			if (lado2 == lado3) {
				System.out.println("Isósceles");
			}
			else {
				System.out.println("Escaleno");
			}
		}
	}
}
