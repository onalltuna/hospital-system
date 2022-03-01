package polyclinic;

import java.util.ArrayList;

	//Drug class:
	//Drugs have names prices and list of conflicting drugs
	//Half of the each drugs goes to the clinic as profit
	//other half goes to drug company
	//All patients have 1 old drug and they can have new drugs if they are not conflicting
public class Drug {
	
	//Constructor of the Drug
	//Drugs will be created in the PolyclinicSystem class
	public Drug(String name, double price) {
		this.conflicts = new ArrayList<Drug>();
		this.price = price;
		this.name = name;
	}
	private double price;
	private String name;
	private ArrayList<Drug> conflicts;
	
	//Getters:
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Drug> getConflicts() {
		return conflicts;
	}
	
	//Setters:
	public void setPrice(double price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setConflicts(ArrayList<Drug> conflicts) {
		this.conflicts = conflicts;
	}
	
	//toString which shows only the name of the drug on GUI
	@Override
	public String toString() {
		return name;
	}
	
}
