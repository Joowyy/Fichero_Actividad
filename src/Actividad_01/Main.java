package Actividad_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

//		Asignamos nuestro archivo
		File f = new File("FicheroActividad_01.txt");
		
//		Mostramos todas las estadisticas del archivo
		mostrarEstadisticas(f);
		
//		Mostramos la primera palabra del archivo
		primeraPalabraDeLinea(f);
		
	}
	
	public static void mostrarEstadisticas(File archivo) {
		
		try {
			
//			Declaramos las variables
			int contadorLineas = 0;
			int contadorPalabras = 0;
			int contadorLetras = 0;
			
//			Declaramos File y Buffered para leer el fichero
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			
//			El fichero se lee hasta que se termina
			while ((linea = br.readLine()) != null) {
				
				System.out.println(linea);
				contadorLineas++;
				
				String[] palabras = linea.split(" ");
				
				for (int i = 0; i < palabras.length; i++) {
					
					contadorPalabras++;

					contadorLetras += palabras[i].length();
					
				}
				
			}
			
//			Resultados
			System.out.println("\nLineas -> " + contadorLineas);
			System.out.println("Palabras -> " + contadorPalabras);
			System.out.println("Letras -> " + contadorLetras);
			
//			Cerramos los flujos
			fr.close();
			br.close();
			
//		Checkeo de errores (Excepciones)
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
	public static boolean primeraPalabraDeLinea (File archivo) {
		
		boolean valorRetornado = false;

		try {

//			-- Su valor fuera del 'while' es null --
			String primeraPalabra = null;

//			Declaramos File y Buffered para leer el fichero
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;

//			El fichero se lee hasta que se termina
			while ((linea = br.readLine()) != null) {

				String[] palabras = linea.split(" ");

//				Comprueba que la palabra del inicio no sea un espacio
				if (palabras.length > 0) {

//					Resultados
					System.out.println("\n" + palabras[0]);
					valorRetornado = true;

				}

			}

//			Cerramos los flujos
			fr.close();
			br.close();

//		Checkeo de errores (Excepciones)
		} catch (IOException e) {

			e.printStackTrace();

		}

	return valorRetornado;
	}

}
