package CS390Assignment8.prob1;

import java.util.Arrays;

// Common task : Make sure to check your code should not throw any run time exception
public class MyPersonList {
	private final int INITIAL_LENGTH = 3;
	private Person[] PersonArray;
	private int size;

	// Default Constructor
	public MyPersonList() {
		PersonArray = new Person[INITIAL_LENGTH];
		size = 0;
	}

	// 1. Implement method to Add as last element, make sure you have enough room else call resize()
	public void add(Person s) {
		//checking if the input is null or not
		if(s == null || s.equals("")) {
			return;
		}
		//checking if the storage is full or not
		if(PersonArray.length == size){
			resize();
		}
		//adding the input to the array
		PersonArray[size++] = s;
	}

	// 2. get person information by passing index
	public Person get(int i) {
		//checking if the user input is valid
		if(i < 0 || i > PersonArray.length){
			return null;
		} else {
			//retrieving the element using the user input
		return PersonArray[i];
		}
	}

	// 3. Find the Person object using lastname
	public boolean find(String lastName) {
		boolean isFound = false;
		//validating
		if(lastName == null || lastName.equals(""))
			throw new NullPointerException();

			//traversing through the array to find the lastname
			for (int i = 0; i < size; i++) {
				if (PersonArray[i].getLast().equals(lastName)) {
				isFound = true;
				}
			}
			return isFound;
	}
 
  	// 4. Remove the person object by passing its lastname
	public boolean remove(String lastName) {
		boolean removed = false;
		if(lastName == null || lastName.equals("") || size == 0)
			return false;

		//traversing through the array to find the index of the input
		int i;
		int temp = 0;
		for(i = 0; i < size; i++) {
			if (PersonArray[i].getLast().equals(lastName)) {
				temp = i;
				removed = true;
			}
		}
		//time to shift
		for(int j = temp; j < size; j++){
			PersonArray[j] = PersonArray[j+1];
		}
		size--;
		return removed;
	}
  	// 5. Resizing the list
	private void resize() {
		int newLength = PersonArray.length * 2;
		//resizing the array
		PersonArray = Arrays.copyOf(PersonArray,newLength);
	}
   // To display all the persons list
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(PersonArray[i] + ", \n");
		}
		sb.append(PersonArray[size - 1] + "]");
		return sb.toString();
	}
   // Return the size
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MyPersonList list = new MyPersonList();
		list.add(new Person("Renuka", "Mohanraj", 36));
		list.add(new Person("Paul", "Corozza", 51));
		list.add(new Person("Joe", "Lermon", 53));
		list.add(new Person("Anne", "Dow", 55));
		System.out.println("\nSize() : " + list.size() + "\n" + list);
		list.remove("Renuka");
		System.out.println("\nSize() : " + list.size() + "\n" + list);
		System.out.println("\nSearching of  Lermon: " + list.find("Joe"));
		System.out.println(list.get(2));

	}
}