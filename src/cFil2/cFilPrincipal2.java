package cFil2;

import cFil.cFil;

public class cFilPrincipal2 {

	public static void main(String[] pArguments) {

		System.out.println("Fil principal iniciat.");
		System.out.println("Fil secundari iniciat.");
		// Creación del proceso hijo
		cFil vObjecteFil = new cFil("#1");
		// Temporización grande → el proceso hijo acaba más tarde
		vObjecteFil.sTemporitzacio(1000); 
		

		// Se crea el hilo a partir del objeto cFil
		Thread vFil = new Thread(vObjecteFil);

		// Inicio del proceso hijo
		vFil.start();
		// Ejecución del proceso principal
	System.out.println("Iniciant execució procés principal");

		try {
			// Bucle del proceso principal
			for (int vComptador = 0; vComptador < 10; vComptador++) {
				// Temporización pequeña → proceso principal más rápido
				Thread.sleep(200);

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

