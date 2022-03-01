package polyclinic;

import java.util.ArrayList;

	//Patient class which implements Comparable in order to 
	//Sort the patients acording to their ages and gender
public class Patient implements Comparable<Patient> {
	
	//Constructor of the Patient
	//Patients have name, id, age, gender in constructor
	//Patients also have the information of olddrugs, newdrugs and total drugs
	public Patient(String name, int id, int age, String gender) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.oldDrugs = new ArrayList<Drug>();
		this.newDrugs = new ArrayList<Drug>();
		this.drugs = new ArrayList<Drug>();
		this.fee = 0;
		
		
	}
	private String name;
	private int id;
	private int age;
	private double fee;
	private String gender;
	private ArrayList<Drug> oldDrugs;
	private ArrayList<Drug> newDrugs;
	private ArrayList<Drug> drugs;
	
	//Getters:
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public double getFee() {
		return fee;
	}
	public String getGender() {
		return gender;
	}
	public ArrayList<Drug> getOldDrugs() {
		return oldDrugs;
	}
	public ArrayList<Drug> getNewDrugs() {
		return newDrugs;
	}
	public ArrayList<Drug> getDrugs() {
		return drugs;
	}
	
	//Setter for fee which sets the fee of the patient to argumant double
	public void setFee(double c) {
		this.fee = c;
	}
	
	//toString which shows name, id, age, gender, old drugs and all drugs of the patient on GUI
	//So doctors can see their info before adding new drugs
	@Override
	public String toString() {
		return "Patient:" + name + ", id:" + id + ", age:" + age + ", gender:" + gender  + ", olddrugs:" + this.oldDrugs.toString() + ", all drugs:" + this.drugs;
	}
	
	//compareTo method which compares the patients first acording to their ages and if
	//Ther are same age then compare them acording to their gender
	@Override
	public int compareTo(Patient o) {
		if(age > o.getAge()) return 1;
		if(age < o.getAge()) return -1;
		if(age == o.getAge() && this.getGender().length() < o.getGender().length()) return 1;
		if(age == o.getAge() && this.getGender().length() > o.getGender().length()) return -1;
		
		return 0;
	}
}
