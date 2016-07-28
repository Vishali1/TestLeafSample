package collections;

import java.util.ArrayList;
import java.util.List;

public class LearnList {

	/**
	 * 
	 * Collections - 
	 * 
	 * 
	 * All collections frameworks contain the following:
	 * 
	 * 1) Interfaces: These are abstract data types that 
	 * represent collections.Interfaces allow collections 
	 * to be manipulated independently of the details
	 * 
	 * 2) Implementations: These are the concrete 
	 * implementations of the collection interfaces.
	 * In essence, they are reusable data structures.
	 * 
	 * 3) Algorithms: These are the methods that perform 
	 * useful computations, such as searching and sorting, 
	 * on objects that implement collection interfaces.
	 * The algorithms are said to be polymorphic: 
	 * that is, the same method can be used on many
	 * different implementations of the appropriate 
	 * collection interface. 
	 * 
	 * 
	 */


	/**
	 * Date: 01 May 2016
	 * 
	 * 1) 
	 * List is an interface
	 * An ordered collection (also known as a sequence). 
	 * The user of this interface has precise control over where in the list each element is inserted. 
	 * The user can access elements by their integer index (position in the list),
	 * and search for elements in the list.
	 * 
	 * Lists typically allow duplicate elements.
	 * Lists (like Java arrays) are zero based 
	 * 
	 * 2) 
	 * ArrayList is one of the implementation of the List interface 
	 * ArrayList has few additional methods on top of List interface
	 *
	 * 3) 
	 * Methods we will learn today
	 * 
	 * size, get(index), add, remove, clear, isEmpty
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a List
		List<String> mentors = new ArrayList<String>();

		// Add mentors to the set -- Note the order
		mentors.add("Kader");
		mentors.add("Gopi");
		mentors.add("Nesa");
		mentors.add("Bharath");
		mentors.add("Karim");
		mentors.add("Sakthi");


		// Now get the count
		System.out.println("The total mentors are :"+mentors.size());

		// Try duplicate
		mentors.add("Bharath");

		// Now get the count
		System.out.println("The total mentors are :"+mentors.size());

		// Print the name of all mentors -- you will notice the order in the list not maintained
		for (String mentor : mentors) {
			System.out.println(mentor);
		}

		// contains
		System.out.println("Is Karim is available "
				+ "in the set :"+mentors.contains("Karim"));

		// remove
		mentors.remove("Karim");

		// contains
		System.out.println("Is Karim is available in the set"
				+ " after removal :"+mentors.contains("Karim"));

		// clear
		mentors.clear();

		// check if it empty
		System.out.println("The set is empty :"
				+ ""+mentors.isEmpty());


	}

}
