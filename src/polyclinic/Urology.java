package polyclinic;

import java.util.ArrayList;

	// Fourth and last subclass of the Clinic
	// Urology also implements Initialise
public class Urology extends Clinic implements Initialise {

	//Constructor of the Urology
	public Urology(String name) {
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
	
	// Override of the initialise
	// Urology has 4 doctors
	@Override
	public void intialise() {
		// TODO Auto-generated method stub
		
		Doctor doc7 = new Doctor("Kerem", 7, 600, 20, "Urology");
		Doctor doc8 = new Doctor("Seyda", 8, 400, 10,"Urology");
		Doctor doc9 = new Doctor("Pınar", 9, 500, 30,"Urology");
		Doctor doc10 = new Doctor("Hande", 10,500, 20,"Urology");
		
		this.docList.add(doc7);
		this.docList.add(doc8);
		this.docList.add(doc9);
		this.docList.add(doc10);	
	}
	
	// toString to show only the name of the clinic on GUI
	@Override
	public String toString() {
		return  name;
	}
}
