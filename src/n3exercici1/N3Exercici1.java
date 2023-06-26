package n3exercici1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class N3Exercici1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		TreeSet<Persona> personesSet = llegirFitxer();
		menu(personesSet);
		
	}
	public static TreeSet<Persona> llegirFitxer() {
		TreeSet<Persona> personesSet = new TreeSet<Persona>();
		String linea = null;
		String destination =".\\src\\n3exercici1\\fitxer.CSV";

		try {

			FileReader resource = new FileReader(destination);
			try (BufferedReader buffer = new BufferedReader(resource)) {
				do {

					linea = buffer.readLine();
					System.out.println(linea);
					if (linea != null || linea != "") {

						String[] palabras = linea.split("\s*");
						System.out.println(palabras);

						personesSet.add(new Persona(palabras[0],palabras[1],palabras[2]));
						//System.out.println(personesSet);

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
		return personesSet;

	}

	public static void menu(TreeSet<Persona> personesSet) {
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
				IntroduirPersona(personesSet);
				break;
			}
			case 2: {
				System.out.println("2.- Mostrar les persones ordenades per nom (A-Z).");
				MostrarPersonesOrdenadesNomAZ(personesSet);
				
				break;
			}
			case 3: {
				System.out.println("3.- Mostrar les persones ordenades per nom (Z-A).");
				MostrarPersonesOrdenadesNomZA(personesSet);
				
				break;
			}
			case 4: {
				System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z).");
				MostrarPersonesOrdenadesCognomsAZ(personesSet);
				break;
			}
			case 5: {
				System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A).");
				MostrarPersonesOrdenadesCognomsZA(personesSet);

				break;
			}
			case 6: {
				System.out.println("6.- Mostrar les persones ordenades per DNI (1-9).");
				MostrarPersonesOrdenadesDNI19(personesSet);

				break;
			}
			case 7: {
				System.out.println("7.- Mostrar les persones ordenades per DNI (9-1).");
				MostrarPersonesOrdenadesDNI91(personesSet);

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

		}
	}
	public static void leerSet(TreeSet<Persona> personesSet) {
		Iterator<Persona> iterator = personesSet.iterator();
		while (iterator.hasNext()) {
			Persona element = iterator.next();
			System.out.println(element);

		}
	}
	private static void IntroduirPersona(TreeSet<Persona> personesSet) {
		// TODO Auto-generated method stub
		
	}
	private static void MostrarPersonesOrdenadesDNI91(TreeSet<Persona> personesSet) {
		personesSet = new TreeSet<Persona>(
				Comparator.comparing(Persona::getDNI));
		personesSet = (TreeSet<Persona>) personesSet.descendingSet();
		leerSet(personesSet);
		
	}
	private static void MostrarPersonesOrdenadesDNI19(TreeSet<Persona> personesSet) {
		personesSet = new TreeSet<Persona>(
				Comparator.comparing(Persona::getDNI));
		leerSet(personesSet);
		
	}
	private static void MostrarPersonesOrdenadesCognomsZA(TreeSet<Persona> personesSet) {
		personesSet = new TreeSet<Persona>(
				Comparator.comparing(Persona::getCognom).thenComparing(Persona::getDNI));
		personesSet = (TreeSet<Persona>) personesSet.descendingSet();
		leerSet(personesSet);
		
	}
	private static void MostrarPersonesOrdenadesCognomsAZ(TreeSet<Persona> personesSet) {
		personesSet = new TreeSet<Persona>(
				Comparator.comparing(Persona::getCognom).thenComparing(Persona::getDNI));
		leerSet(personesSet);
		
	}
	private static void MostrarPersonesOrdenadesNomZA(TreeSet<Persona> personesSet) {
		personesSet = new TreeSet<Persona>(
				Comparator.comparing(Persona::getNom).thenComparing(Persona::getDNI));
		personesSet = (TreeSet<Persona>) personesSet.descendingSet();
		leerSet(personesSet);
	}
	private static void MostrarPersonesOrdenadesNomAZ(TreeSet<Persona> personesSet) {
		personesSet = new TreeSet<Persona>(
				Comparator.comparing(Persona::getNom).thenComparing(Persona::getDNI));
		leerSet(personesSet);
		
	};

}
