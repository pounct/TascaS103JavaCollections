package n3exercici1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import static java.util.Comparator.comparing;

public class N3Exercici1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Persona> persones = readFromCSV(".\\src\\n3exercici1\\fitxer.CSV");
		for (Persona p : persones) {
			System.out.println(p);
		}

		// TreeSet<Persona> personesSet = llegirFitxer();
		menu(persones);

	}

	private static List<Persona> readFromCSV(String fileName) {
		List<Persona> persones = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

			String line = br.readLine();

			while (line != null) {

				String[] attributes = line.split(",");
				Persona persona = createPersona(attributes);

				persones.add(persona);

				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return persones;
	}

	private static Persona createPersona(String[] attributes) {
		String nom = attributes[0].strip();
		String cognom = attributes[1].strip();
		String dNI = attributes[2].strip();
		return new Persona(nom, cognom, dNI);
	}

	public static void menu(List<Persona> persones) {
		boolean programaOn = true;
		while (programaOn) {
			System.out.println();
			System.out.println();
			System.out.println("1.- Introduir persona.");
			System.out.println("2.- Mostrar les persones ordenades per nom (A-Z).");
			System.out.println("3.- Mostrar les persones ordenades per nom (Z-A).");
			System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z).");
			System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A).");
			System.out.println("6.- Mostrar les persones ordenades per DNI (1-9).");
			System.out.println("7.- Mostrar les persones ordenades per DNI (9-1).");
			System.out.println("0.- Sortir.");

			Byte opcion = sc.nextByte();

			switch (opcion) {

			case 0: {
				programaOn = false;
				System.out.println("0.- Fin de programa.");
				break;
			}
			case 1: {
				System.out.println("1.- Introduir persona.");
				IntroduirPersona(persones);
				break;
			}
			case 2: {
				System.out.println("2.- Mostrar les persones ordenades per nom (A-Z).");
				MostrarPersonesOrdenadesNomAZ(persones);

				break;
			}
			case 3: {
				System.out.println("3.- Mostrar les persones ordenades per nom (Z-A).");
				MostrarPersonesOrdenadesNomZA(persones);

				break;
			}
			case 4: {
				System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z).");
				MostrarPersonesOrdenadesCognomsAZ(persones);
				break;
			}
			case 5: {
				System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A).");
				MostrarPersonesOrdenadesCognomsZA(persones);

				break;
			}
			case 6: {
				System.out.println("6.- Mostrar les persones ordenades per DNI (1-9).");
				MostrarPersonesOrdenadesDNI19(persones);

				break;
			}
			case 7: {
				System.out.println("7.- Mostrar les persones ordenades per DNI (9-1).");
				// persones=(List<Persona>) new TreeSet(persones);
				MostrarPersonesOrdenadesDNI91(persones);

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

		}
	}

	public static void leerList(List<Persona> persones) {
		Iterator<Persona> iterator = persones.iterator();
		while (iterator.hasNext()) {
			Persona element = iterator.next();
			System.out.println(element);

		}
	}

	private static void LeerInverseList(List<Persona> persones) {
		for (int i = persones.size() - 1; i >= 0; i--) {
			System.out.println(persones.get(i));
		}

	}

	private static void IntroduirPersona(List<Persona> persones) {

		sc.nextLine();
		System.out.println("Indroduir el nom :");
		
		String nom = sc.nextLine();
		System.out.println("Indroduir el cognom :");
		String cognom = sc.nextLine();
		System.out.println("Indroduir el DNI :");
		String dNI = sc.nextLine();
		Persona personaBuscada = buscarPersona(dNI, persones);
		if (personaBuscada==null) {
			boolean personaIntroduida = persones.add(new Persona(nom, cognom, dNI));
			if (personaIntroduida) {
				System.out.println(" persona introduida con exito!!");
			}
		} else {
			System.out.println("Persona con este dni ya existe!!! ");
		}

	}

	private static Persona buscarPersona(String dNI, List<Persona> persones) {
		Persona personaBuscada = null;
		int ind = 0;
		while (personaBuscada == null && ind < persones.size()) {
			if (persones.get(ind).getDNI().equals(dNI)) {
				personaBuscada = persones.get(ind);
			}
			ind++;
		}
		return personaBuscada;
	}

	private static void MostrarPersonesOrdenadesDNI91(List<Persona> persones) {
		persones.sort(comparing(Persona::getDNI));
		LeerInverseList(persones);

	}

	private static void MostrarPersonesOrdenadesDNI19(List<Persona> persones) {
		persones.sort(comparing(Persona::getDNI));
		leerList(persones);

	}

	private static void MostrarPersonesOrdenadesCognomsZA(List<Persona> persones) {
		persones.sort(comparing(Persona::getCognom));
		LeerInverseList(persones);

	}

	private static void MostrarPersonesOrdenadesCognomsAZ(List<Persona> persones) {
		persones.sort(comparing(Persona::getCognom));
		leerList(persones);

	}

	private static void MostrarPersonesOrdenadesNomZA(List<Persona> persones) {
		persones.sort(comparing(Persona::getNom));
		LeerInverseList(persones);
	}

	private static void MostrarPersonesOrdenadesNomAZ(List<Persona> persones) {
		persones.sort(comparing(Persona::getNom));
		leerList(persones);

	};

}
