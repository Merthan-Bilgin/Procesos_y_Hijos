package cFil;

public class cFilPrincipal {

	public static void main(String[] pArguments) {

		System.out.println("Fil principal iniciat.");
		System.out.println("Fil secundari iniciat.");

		cFil vObjecteFil = new cFil("#1");
		vObjecteFil.sTemporitzacio(1000); 
		vObjecteFil.sTemporitzacio(100); 

		// alternativa: innecessari
		Thread vFil = new Thread(vObjecteFil);

		// alternativa: vObjecteFil
		vFil.start();
		
		//1.3
		//Aquí añadimos el join() → el padre espera al hijo
		try {
			vFil.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	System.out.println("Iniciant execució procés principal");

		try {

			for (int vComptador = 0; vComptador < 10; vComptador++) {


				Thread.sleep(200); //1.2
				Thread.sleep(1000); //1.1

				System.out.println("Despertant aturada " + vComptador + " procès principal");

			}

		}

		catch (InterruptedException pExcepcio) {

			System.out.println("Interrompent execució procès principal");

		}

		System.out.println("Acabant execució procès principal");

	}
}

