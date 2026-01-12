package cFil4;
import java.util.Scanner;
import cFil.cFil;

public class cFilPrincipal4 {

	public static void main(String[] args) {
		// Scanner para leer datos por teclado
		Scanner sc = new Scanner(System.in);
		// Se pide al usuario el número de procesos hijos
		System.out.println("Indica el número de procesos hijos a crear:");
		int n = sc.nextInt();

		// LÍMITE para evitar valores exagerados
		if (n <= 0 || n > 10) {
			System.out.println("Error: el número de procesos debe estar entre 1 y 10.");
			return;
		}
		 // Array para guardar los hilos creados
		Thread[] hilos = new Thread[n];
		// Inicio del proceso principal
		System.out.println("Proceso principal iniciado.");

		// CREACIÓN DE LOS PROCESOS HIJOS
		for (int i = 0; i < n; i++) {
			// Se crea el proceso hijo con un identificador
			cFil fil = new cFil("#" + (i + 1));

			// Cada proceso hijo tiene una temporización distinta
			fil.sTemporitzacio(200 + i * 200);
			// Se crea y se inicia el hilo
			Thread t = new Thread(fil);
			hilos[i] = t;
			t.start();
		}

		// EL PROCESO PADRE ESPERA A TODOS LOS HIJOS
		for (int i = 0; i < n; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				System.out.println("Error al esperar a los procesos hijos.");
			}
		}
		// Fin del programa
		System.out.println("Todos los procesos hijos han finalizado.");
		System.out.println("Finalizando ejecución del proceso principal.");
	}
}
