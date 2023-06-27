package n1exercici3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class N1Exercici3 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {

		HashMap<String, String> paisCapitalMap = llegirFitxer();
		System.out.println(paisCapitalMap);
		HashMap<String, Integer> userScoreMap = new HashMap<String, Integer>(512);
		menu(paisCapitalMap, userScoreMap);

	}

	private static void menu(HashMap<String, String> paisCapitalMap, HashMap<String, Integer> userScoreMap) {

		System.out.println("nom de l’usuari/ària:");
		String nom = sc.nextLine();
		starPlay(nom, paisCapitalMap, userScoreMap);
	}

	private static void starPlay(String nom, HashMap<String, String> paisCapitalMap,
			HashMap<String, Integer> userScoreMap) {

		List<String> paises = new ArrayList<String>(paisCapitalMap.keySet());
		int score = 0;

		System.out.println("Start game...");
		for (int i = 1; i <= 3; i++) {
			Integer randomNum = Integer.parseInt((int) (Math.random() * paisCapitalMap.size()) + "");
			String pais = paises.get(randomNum);
			System.out.println("escriure el nom de la capital del país " + pais + ".");
			String respusta = sc.nextLine();
			if (respusta.equalsIgnoreCase(paisCapitalMap.get(pais))) {
				score += 1;
			}

		}

		System.out.println("Score : " + score);
		escriureFitxer(nom, score);
		System.out.println("End game...");

	}

	public static void escriureFitxer(String nom, int score) {

		try {

			String destination = "C:\\Users\\HP_mini\\eclipse-workspace\\TascaS103JavaCollections\\src\\n1exercici3\\classificacio.txt";
			BufferedWriter fitxer = new BufferedWriter(new FileWriter(destination,true));

			//fitxer.newLine();
			fitxer.write(nom + " " + score);
			fitxer.newLine();

			fitxer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HashMap<String, String> llegirFitxer() {
		HashMap<String, String> paisCapitalMap = new HashMap<String, String>();
		String linea = null;
		String destination =".\\src\\n1exercici3\\countries.txt";

		try {

			FileReader resource = new FileReader(destination);
			try (BufferedReader buffer = new BufferedReader(resource)) {
				do {

					linea = buffer.readLine();
					System.out.println(linea);
					if (linea != null || linea != "") {

						String[] palabras = linea.split(" ");
						paisCapitalMap.put(palabras[0], palabras[1]);
						System.out.println(paisCapitalMap);

					}

				} while (linea != null);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return paisCapitalMap;

	}

}
