package CS390Assignment8.prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

		 if(this.salesamount == m.salesamount &&
				this.employeename.equalsIgnoreCase(m.employeename) &&
				this.productname.equalsIgnoreCase(m.productname)){
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
		System.out.println("The highest sales amount");
		System.out.println("This the new List " +listMoreThan1000(marketList));
	}
}