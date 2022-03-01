package polyclinic;

import java.util.ArrayList;
	// Ophthalmology is the first sublcass of Clinic
	// Ophthalmology also implements the interface Initialise
	// In order to create the doctors for Ophthalmology clinic
public class Ophthalmology extends Clinic implements Initialise {

	//Constuctor which creates the doctors when the clinic is created
	public Ophthalmology(String name) {
		super(name);
		this.docList = new ArrayList<Doctor>(5);
		this.patList = new ArrayList<Patient>();
		intialise();	
	}
	
	private ArrayList<Doctor> docList;
	private ArrayList<Patient> patList;
	
	// Getters:
	public ArrayList<Patient> getPatList() {
		return patList;
	}
	public ArrayList<Doctor> getDocList() {
		return docList;
	}
	
	
	
	
	// Override of the interface "Initialise".
	// Creates the doctor(s) and add them to the doctors list of the clinic
	@Override
	public void intialise() {
		// TODO Auto-generated method stub
		Doctor doc1 = new Doctor("Esra",1, 300, 10, "Ophthalmology");
		this.docList.add(doc1);	
	}
	
	
	//In order to show only the name of the clinic on the GUI
	// toString method only returns name of the clinic
	@Override
	public String toString() {
		return  name;
	}
	
	
	
	
}
