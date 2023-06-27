package n1exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class N1Exercici1 {

	public static void main(String[] args) {
		ArrayList<Month> months = new ArrayList<Month>();
		months.add(new Month("Gener"));
		months.add(new Month("Febrer"));
		months.add(new Month("Març"));
		months.add(new Month("Abril"));
		months.add(new Month("Maig"));
		months.add(new Month("Juny"));
		months.add(new Month("Juliol"));

		months.add(new Month("Setembre"));
		months.add(new Month("Octubre"));
		months.add(new Month("Novembre"));
		months.add(new Month("Desembre"));

		months.add(7, new Month("Agost"));
		System.out.println(months);

		HashSet<Month> hashSetMonths = new HashSet<Month>(months);
		System.out.println(hashSetMonths);

		boolean booleanAdd = hashSetMonths.add(new Month("Desembre"));
		System.out.println("Permet duplicats ; " + booleanAdd);
		System.out.println(hashSetMonths);

		// Recorre la llista amb un for.
		for (Month month : hashSetMonths) {
			System.out.println(month);
		}

		// Recorre la llista amb un iterador.
		Iterator<Month> iterator = months.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
