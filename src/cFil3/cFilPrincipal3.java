package cFil3;

import cFil.cFil;

public class cFilPrincipal3 {

	public static void main(String[] pArguments) {

		System.out.println("Fil principal iniciat.");
		System.out.println("Fil secundari iniciat.");
		// Creación del proceso hijo
		cFil vObjecteFil = new cFil("#1");
		// Temporización grande → proceso hijo más lento
		vObjecteFil.sTemporitzacio(1000); //1.2

		// Se crea el hilo a partir del objeto cFil
		Thread vFil = new Thread(vObjecteFil);

		 // Inicio del proceso hijo
		vFil.start();
		
		//1.3
		//Aquí añadimos el join() → el padre espera a q temine el hijo
		try {
			vFil.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Error al esperar al proceso hijo");
		}
		
	System.out.println("Iniciant execució procés principal");

		try {
			// Bucle del proceso principal
			for (int vComptador = 0; vComptador < 10; vComptador++) {
				// Temporización pequeña del proceso principal
				Thread.sleep(200); //1.2

				System.out.println("Despertant aturada " + vComptador + " procès principal");

			}

		}

		catch (InterruptedException pExcepcio) {
			// Si el proceso principal es interrumpido
			System.out.println("Interrompent execució procès principal");

		}
		 // Fin del proceso principal
		System.out.println("Acabant execució procès principal");

	}
}

