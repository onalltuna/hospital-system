package polyclinic;

import java.util.ArrayList;

	// I designed my project in a way that the four types of clinics
	//are subclasses of the mother class: Clinic


public abstract class Clinic {
	
	//Constructor:
	public Clinic(String name) {
		
		this.name = name;
		this.docList = new ArrayList<Doctor>(5);
		this.patList = new ArrayList<Patient>();		
	}
	
	public String name;
	public ArrayList<Doctor> docList;
	public ArrayList<Patient> patList;
	
	//Getter methods:
	public String getName() {
		return name;
	}
	public ArrayList<Doctor> getDocList() {
		return docList;
		}
	public ArrayList<Patient> getPatList() {
		return patList;
	}
	
	//A method to add patients to the Patients List of the clinic, it takes patient as an argument
	public void addPatient(Patient p) {
		patList.add(p);
	}
	
	//toString method for Clinic
	@Override
	public String toString() {
		return "Clinic [name=" + name + ", patList=" + patList + "]";
	}
	
	
	
}
