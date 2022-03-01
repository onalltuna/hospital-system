package polyclinic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
	
	//Doctor class
public class Doctor {
	
	//Constructor of the Doctor which be used in different clinics
	//Doctors have name,id, visit cost, comission of examination
	//And String clinic to specify their clinics
	public Doctor(String name, int id, double visitCost, int comission, String clinic) {
		this.comission =  comission;
		this.name = name;
		this.id = id;
		this.visitCost = visitCost;
		this.clinic = clinic;
		this.schedule = new HashMap<Patient, String>();
		this.patientsofdoc = new ArrayList<Patient>();
	}
	
	//Doctors also have the information about their schedule, income and all patients:
	private String name;
	private int id;
	private double visitCost;
	private int comission;
	private String clinic;
	private Map<Patient, String> schedule;
	private ArrayList<Patient> patientsofdoc;
	private double income;
	
	//Getters:
	public int getComission() {
		return comission;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public double getVisitCost() {
		return visitCost;
	}
	
	public Map<Patient, String> getSchedule() {
		return schedule;
	}
	public ArrayList<Patient> getPatientsofdoc() {
		return patientsofdoc;
	}
	
	//Setters:
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setVisitCost(double visitCost) {
		this.visitCost = visitCost;
	}
	public void setSchedule(Map<Patient, String> schedule) {
		this.schedule = schedule;
	}
	
	// addPatient method works when a new patient registers to a clinic
	// It takes the needed information and creates a new patient object
	// While patients register they will se only the allowed times for examination
	//(between 9:00-12:00 and 13:30-17:00)
	public void addPatient(String name, int id, int age, String gender) {
		
		Patient patient = new Patient(name, id, age, gender);
		
	}
	// when an already registered patient wants to register for another examination addExistingPatient
	//method works and puts that patient to the schedule of the doctor
	public void addExistingPatient(Patient p, String s) {
		schedule.put(p, s);
	}
	
	// docIncome method calculates the income of the doctor by using number of the examinations and the comissions    
	public double docIncome() {
		double d = (schedule.size()*this.visitCost*this.comission)/100;
		this.income = d;
		return income;
	}
	
	// toString which shows doctors name and clinic on GUI 
	// In this way patients can see which doctor works in which clinic
	@Override
	public String toString() {
		return "Dr."+ this.name +"(" + this.clinic + ")";
	}
	// toString 2 method takes a map as an argumant which will be the schedule of the doctor 
	// and it will return the schedule of each doctor of selected clinic via GUI
	public String toString2(Map<Patient, String> m) {
		String d = "";
		
		for(int i = 0; i < m.size(); i++) {
			d += m.get(getPatientsofdoc().get(i)).toString();
			d += ", ";
		}
		return d;
	}
}
