package polyclinic;

import java.util.ArrayList;

	// Orthopedics is the second subclass of Clinic
	// Just like other subclasses it implements Initialise
public class Orthopedics extends Clinic implements Initialise {

		//Constructor of the Orthopdics:
		// Orthopedics clinic has 2 doctors
	public Orthopedics(String name) {
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
	
	// Override of the Initialise, creates the doctors and adds them to the doctor list.
	@Override
	public void intialise() {
		// TODO Auto-generated method stub
		
		Doctor doc2 = new Doctor("Baran", 2, 350, 15, "Orthopedics");
		Doctor doc3 = new Doctor("Isıl", 3, 400, 20, "Orthopedics");
		
		docList.add(doc2);
		docList.add(doc3);
	}
	
	// toString which only shows only the name on GUI.
	public String toString() {
		return  this.name;
	}
}
