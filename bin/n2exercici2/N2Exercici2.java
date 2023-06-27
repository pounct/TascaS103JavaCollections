package n2exercici2;

import java.util.TreeSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class N2Exercici2 {

	public static void main(String[] args) {
		HashSet<Restaurant> restaurantSet = new HashSet<Restaurant>();
		restaurantSet.add(new Restaurant("restaurant2", 6));
		restaurantSet.add(new Restaurant("restaurant2", 7));
		restaurantSet.add(new Restaurant("restaurant1", 3));
		restaurantSet.add(new Restaurant("restaurant1", 2));
		restaurantSet.add(new Restaurant("restaurant2", 5));
		restaurantSet.add(new Restaurant("restaurant3", 5));

		Iterator<Restaurant> iterator = restaurantSet.iterator();
		while (iterator.hasNext()) {
			Restaurant element = iterator.next();
			System.out.println(element);
		}

		// anadir un restaurant equal a uno d la Set
		boolean RestaurantAnadido = restaurantSet.add(new Restaurant("restaurant1", 3));

		if (!RestaurantAnadido) {
			System.out.println("Restaurant no añadido!!");
		}

		// ascending order
		TreeSet<Restaurant> treeRestaurantSet = new TreeSet<Restaurant>(
				Comparator.comparing(Restaurant::getNom).thenComparingInt(Restaurant::getPuntuacio));

		treeRestaurantSet.addAll(restaurantSet);
		System.out.println(treeRestaurantSet);

		// descending order
		treeRestaurantSet = (TreeSet<Restaurant>) (treeRestaurantSet).descendingSet();
		
		System.out.println("descending order");
		iterator = treeRestaurantSet.iterator();
		while (iterator.hasNext()) {
			Restaurant element = iterator.next();
			System.out.println(element);

		}

	}

}
