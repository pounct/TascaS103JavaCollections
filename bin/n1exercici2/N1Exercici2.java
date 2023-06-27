package n1exercici2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class N1Exercici2 {

	public static void main(String[] args) {
		List<Integer> listInteger1 = new ArrayList<Integer>();
		listInteger1.add(1);
		listInteger1.add(2);
		listInteger1.add(3);

		System.out.println("List 1 : " + listInteger1);

		List<Integer> listInteger2 = new ArrayList<Integer>();
		listInteger2.add(4);
		listInteger2.add(5);
		listInteger2.add(6);

		System.out.println("List 2 : " + listInteger2);

		ListIterator<Integer> liatIterator1 = listInteger1.listIterator(listInteger1.size());
		while (liatIterator1.hasPrevious()) {
			listInteger2.add((Integer) liatIterator1.previous());
		}

		System.out.println("List 2 + inverse(List 1) : " + listInteger2);

	}
}
