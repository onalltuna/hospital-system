package polyclinic;

import java.util.ArrayList;

	// Third subclass of the Clinic is Psychiatry
	// Psychiatry implements the Initialise
public class Psychiatry extends Clinic implements Initialise {

	// Constructor of the Psychiatry:
	public Psychiatry(String name) {
		super(name);
		this.docList = new ArrayList<Doctor>(5);
		this.patList = new ArrayList<Patient>();
		intialise();
		
	}
	
	private ArrayList<Doctor> docList;
	private ArrayList<Patient> patList;
	
	//Getters:
	public ArrayList<Patient> getPatList() {
		return patList;
	}
	public ArrayList<Doctor> getDocList() {
		return docList;
	}
	
	// Override of the Initialise
	// Psychiatry has 3 doctors
	@Override
	public void intialise() {
		
		Doctor doc4 = new Doctor("Gokhan", 4, 450, 30,"Psychiatry");
		Doctor doc5 = new Doctor("Koray", 5, 500, 35,"Psychiatry");
		Doctor doc6 = new Doctor("Canan", 6, 550, 40,"Psychiatry");
		
		docList.add(doc4);
		docList.add(doc5);
		docList.add(doc6);
	}
	
	// toString which only shows the name of the clinic on GUI
	@Override
	public String toString() {
		return  name;
	}
}
