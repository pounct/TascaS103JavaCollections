package n2exercici1;

import java.util.HashSet;
import java.util.Iterator;

public class N2Exercici1 {

	public static void main(String[] args) {
		HashSet<Restaurant> restaurantSet = new HashSet<Restaurant>();
		restaurantSet.add(new Restaurant("restaurant1", 3));
		restaurantSet.add(new Restaurant("restaurant1", 2));
		restaurantSet.add(new Restaurant("restaurant2", 5));
		restaurantSet.add(new Restaurant("restaurant3", 5));
		
		Iterator<Restaurant> iterator = restaurantSet.iterator();
	    while (iterator.hasNext()) {
	      System.out.println(iterator.next());
	    }
	    
	    // anadir un restaurant equal a uno d la Set
	    boolean RestaurantAnadido = restaurantSet.add(new Restaurant("restaurant1", 3));
	    
	    if (!RestaurantAnadido) {
	    	System.out.println("Restaurant no añadido!!");
	    }
	    
	    iterator = restaurantSet.iterator();
	    while (iterator.hasNext()) {
	      System.out.println(iterator.next());
	    }

	}

}
