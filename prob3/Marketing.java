package CS390Assignment8.prob3;

import java.util.*;

public class Marketing {
	private String employeename;
	private String productname;
	private double salesamount;

	public Marketing(String employeename, String productname, double salesamount) {
		this.employeename = employeename;
		this.productname = productname;
		this.salesamount = salesamount;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(double salesamount) {
		this.salesamount = salesamount;
	}

	@Override
	public String toString() {
		return employeename + " " + productname + " " + salesamount;
	}

	//overriding the equal method
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(!(obj instanceof Marketing)) return false;
		Marketing m = (Marketing) obj;

		 if(this.salesamount == m.salesamount){
			 return true;
		 } else {
			 return false;
		 }
	}
	//sorting less than 1000
	public static List<Marketing> listMoreThan1000(List<Marketing> list){
		//creating new List to store the highest sales amount
		List<Marketing> moreThan = new ArrayList<>();

		//looping through the list to find the highest
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getSalesamount() > 1000){
				moreThan.add(list.get(i));
			}
		}
		//returning the new List
		return moreThan;
	}
	public static void main(String[] args) {
		//populating the marketing object
	List<Marketing> marketList = new ArrayList<>(Arrays.asList(
			new Marketing("Keleab","Tv",1525),
			new Marketing("Haben","Satellite",1636),
			new Marketing("Hanah","Salon",1546),
			new Marketing("Samuel","Truck",958)
		));
	//adding new marketing object to the list
	marketList.add(new Marketing("Awet","Truck",96));
	//deleting from marketing
		marketList.remove(3);
		//printing the size
		System.out.println("Size of the list");
		System.out.println(marketList.size());
		System.out.println("Before sorting");
		System.out.println(marketList);
		//after sorting
		System.out.println("After sorting");
		Collections.sort(marketList,new ComparatorClass());
		System.out.println(marketList);
		System.out.println("The over 1000 sale-amount list after sorting");
		System.out.println("This the new List " +listMoreThan1000(marketList));
		System.out.println("Checking the result ");
		System.out.println("object 0 equal to object index 1 is : " +marketList.get(0).equals(marketList.get(1)));
		System.out.println("object 0 compare to object index 1 is : " +new ComparatorClass().compare(marketList.get(0),marketList.get(1)));
		List<Marketing> list = listMoreThan1000(marketList);
		//sorting the over1000 list
		Collections.sort(list, new Comparator<Marketing>() {
			@Override
			public int compare(Marketing o1, Marketing o2) {
				return o1.getEmployeename().compareTo(o2.employeename);
			}
		});
		System.out.println("The over 1000 sale-amount list after sorting");
		System.out.println(list);
	}
}