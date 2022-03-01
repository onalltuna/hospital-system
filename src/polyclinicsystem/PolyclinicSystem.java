package polyclinicsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import polyclinic.Clinic;
import polyclinic.Doctor;
import polyclinic.Drug;
import polyclinic.Ophthalmology;
import polyclinic.Orthopedics;
import polyclinic.Patient;
import polyclinic.Psychiatry;
import polyclinic.Urology;

	//PolyclinicSystem class which extends JFrame and where the GUI is created
	//Clinics and drugs are manually created but patients will be registered via GUI
	
public class PolyclinicSystem extends JFrame {
	
	private HashMap<Integer,Patient> allPatients = new HashMap<>();
	
	//4 types of clinics:
	private Clinic ophthalmology = new Ophthalmology("Ophtalmolgy");
	private Clinic orthopedics = new Orthopedics("Orthopedics");
	private Clinic psychiatry = new Psychiatry("Psychiatry");
	private Clinic urology = new Urology("Urology");
	
	//6 types of drugs and prices:
	private Drug drugA = new Drug("DrugA", 20);
	private Drug drugB = new Drug("DrugB", 30);
	private Drug drugC = new Drug("DrugC", 40);
	private Drug drugD = new Drug("DrugD", 50);
	private Drug drugE = new Drug("DrugE", 60);
	private Drug drugF = new Drug("DrugF", 70);
	
	//All the JLabels used on GUI:
	private JLabel clinicslabel;
	private JLabel clinicslabel2;
	private JLabel namelabel;
	private JLabel idlabel;
	private JLabel agelabel;
	private JLabel genderlabel;
	private JLabel doctorslabel;
	private JLabel drugslabel;
	private JLabel drugs;
	private JLabel patientslabel;
	
	//All the JButtons used on GUI:
	private JButton register;
	private JButton display;
	private JButton displaydoctors;
	private JButton drugadd;
	private JButton displaypatients;
	private JButton totalfee;
	private JButton clinicprofit;
	private JButton doctorincomes;
	
	//All the JTextFields used on GUI:
	private JTextField namefield;
	private JTextField idfield;
	private JTextField agefield;
	private JTextField genderfield;
	
	//All the JComboBoxes used on GUI:
	private JComboBox<Clinic> clinics;
	private JComboBox<Clinic> clinics2;
	private JComboBox<Doctor> docsb;
	private JComboBox<String> times;
	private JComboBox<Drug> drugsbox;
	private JComboBox<Drug> drugbox2;
	private JComboBox<Patient> patientsbox;
	
	//2 panel are used to split the frame in 2
	//1 for patienst and registration
	//1 for doctors to add drugs, payment calculations, and display doctors and patients
	private JPanel p;
	private JPanel p2;
	
	//2 JTextAreas are used to print needed outputs
	private JTextArea pane;
	private JTextArea pane2;
	

	public PolyclinicSystem() {
		
		//Title of the frame
		super("KU-HEALTH");
		
		//Layout used for the frame
		GridLayout grid = new GridLayout(2, 1, 10, 10);
		this.setLayout(grid);
				
		//Conflicting drugs are set:
		drugB.getConflicts().add(drugD);
		drugB.getConflicts().add(drugF);
		drugC.getConflicts().add(drugE);
		drugD.getConflicts().add(drugB);
		drugE.getConflicts().add(drugC);
		drugF.getConflicts().add(drugB);
		
		//Labels are set:
		clinicslabel = new JLabel("Clinics:");
		clinicslabel2 = new JLabel("Clinics:");
		namelabel = new JLabel("Name:");
		idlabel = new JLabel("ID:");
		agelabel = new JLabel("Age:");
		doctorslabel = new JLabel("Doctors:");
		genderlabel = new JLabel("Gender:");
		drugslabel = new JLabel("Used Drugs:");
		drugs = new JLabel("Drugs:");
		patientslabel = new JLabel("Patients: ");
		
		//Buttons are set:
		register = new JButton("Register");
		display = new JButton("Display");
		displaydoctors = new JButton("Display Doctors");
		drugadd = new JButton("Add Drug");
		displaypatients = new JButton("Display Patient");
		totalfee = new JButton("Total Fee");
		clinicprofit = new JButton("Profit");
		doctorincomes = new JButton("Incomes of Doctors");
		
		//TextFields are set:
		namefield = new JTextField();
		idfield = new JTextField();
		agefield = new JTextField();
		genderfield = new JTextField();
		
		//ComboBox for old drugs of patients is set:
		drugsbox = new JComboBox<Drug>();
		drugsbox.addItem(drugA);
		drugsbox.addItem(drugB);
		drugsbox.addItem(drugC);
		drugsbox.addItem(drugD);
		drugsbox.addItem(drugE);
		drugsbox.addItem(drugF);
		
		//When new patients register they will be added to the ComboBox:
		patientsbox = new JComboBox<Patient>();
		
		//Second drugBox which doctors use to add new drugs to patients:
		drugbox2 = new JComboBox<Drug>();
		drugbox2.addItem(drugA);
		drugbox2.addItem(drugB);
		drugbox2.addItem(drugC);
		drugbox2.addItem(drugD);
		drugbox2.addItem(drugE);
		drugbox2.addItem(drugF);

		//Clinics combo box which shows the clinics for patients to choose is set:
		clinics = new JComboBox<Clinic>();
		clinics.addItem(ophthalmology);
		clinics.addItem(orthopedics);
		clinics.addItem(psychiatry);
		clinics.addItem(urology);
		
		
		//Second clinics box which is used to calculate the fee, display doctors, patients
		//profit, doctor incomes:
		clinics2 = new JComboBox<Clinic>();
		clinics2.addItem(ophthalmology);
		clinics2.addItem(orthopedics);
		clinics2.addItem(psychiatry);
		clinics2.addItem(urology);
		
		//Combo box of doctors which patients can choose the doctor they prefer:
		docsb = new JComboBox<Doctor>();
		docsb.addItem(ophthalmology.getDocList().get(0));
		docsb.addItem(orthopedics.getDocList().get(0));
		docsb.addItem(orthopedics.getDocList().get(1));
		docsb.addItem(psychiatry.getDocList().get(0));
		docsb.addItem(psychiatry.getDocList().get(1));
		docsb.addItem(psychiatry.getDocList().get(2));
		docsb.addItem(urology.getDocList().get(0));
		docsb.addItem(urology.getDocList().get(1));
		docsb.addItem(urology.getDocList().get(2));
		docsb.addItem(urology.getDocList().get(3));
		
		//Combo box of available times for examinations:
		times = new JComboBox<String>();
		times.addItem("09:00-09:30");
		times.addItem("09:30-10:00");
		times.addItem("10:00-10:30");
		times.addItem("10:30-11:00");
		times.addItem("11:00-11:30");
		times.addItem("11:30-12:00");
		times.addItem("13:30-14:00");
		times.addItem("14:00-14:30");
		times.addItem("14:30-15:00");
		times.addItem("15:00-15:30");
		times.addItem("15:30-16:00");
		times.addItem("16:00-16:30");
		times.addItem("16:30-17:00");
		
		//Text areas are designed:
		pane = new JTextArea();
		pane.setPreferredSize(new Dimension(1430, 270));
		pane.setEditable(false);
		pane2 = new JTextArea();
		pane2.setPreferredSize(new Dimension(1430, 290));
		pane2.setEditable(false);

		//panel1(for patients) is designed 
		p = new JPanel(new FlowLayout());
		p.setBackground(Color.LIGHT_GRAY);
		p.setBorder(BorderFactory.createTitledBorder("For Patients"));
		p.add(clinicslabel);
		p.add(clinics);
		p.add(namelabel);
		namefield.setColumns(7);
		p.add(namefield);
		p.add(idlabel);
		idfield.setColumns(7);
		p.add(idfield);
		p.add(agelabel);
		agefield.setColumns(7);
		p.add(agefield);
		p.add(genderlabel);
		genderfield.setColumns(7);
		p.add(genderfield);
		p.add(doctorslabel);
		p.add(docsb);
		p.add(times);
		p.add(drugslabel);
		p.add(drugs);
		p.add(drugsbox);
		p.add(register);
		p.add(display);
		p.add(pane);
	
		//panel2(for doctors) is designed
		p2 = new JPanel();
		p2.setBackground(Color.LIGHT_GRAY);
		idlabel = new JLabel("For Doctors");
		p2.setBorder(BorderFactory.createTitledBorder("For Doctors"));
		p2.add(clinicslabel2);
		p2.add(clinics2);
		p2.add(patientslabel);
		p2.add(patientsbox);
		p2.add(drugs);
		p2.add(drugbox2);
		p2.add(drugadd);		
		p2.add(displaydoctors);
		p2.add(displaypatients);
		p2.add(totalfee);
		p2.add(clinicprofit);
		p2.add(doctorincomes);
		p2.add(pane2);
		
		//panels are added to the frame:
		this.add(p);
		this.add(p2);
		
		
		// action for register button it checks if the doctor is available at selected time, is the doctor
		//works in selected clinic and if the patient is new or already registered
		register.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				// If patient is new and doctor is available, register button creates a new patient,
				// adds this patient to related doctors list and schedule,
				// adds the seleted drug to the patients old drug list and total drugs list,
				// adds the patient to the realted clinic,
				// adds the patient to all patients map in order to avoid the creation of same patient multiple times,
				// sets the fee of the patient 
				// prints the appropriate message
				
				if(!((Doctor) docsb.getSelectedItem()).getSchedule().containsValue(times.getSelectedItem()) &&
						((Clinic) clinics.getSelectedItem()).getDocList().contains(((Doctor) docsb.getSelectedItem())) &&
						!allPatients.containsKey(Integer.parseInt(idfield.getText()))) {
					
					
					Patient p = new Patient(namefield.getText(),Integer.parseInt(idfield.getText()), Integer.parseInt(agefield.getText()), genderfield.getText());
					((Doctor) docsb.getSelectedItem()).addPatient(namefield.getSelectedText(), idfield.getSelectionEnd(), agefield.getSelectionEnd(), genderfield.getSelectedText());
					((Doctor) docsb.getSelectedItem()).getSchedule().put(p, (String) times.getSelectedItem());
					((Doctor) docsb.getSelectedItem()).getPatientsofdoc().add(p);
					p.getOldDrugs().add(((Drug) drugsbox.getSelectedItem()));
					p.getDrugs().add(((Drug) drugsbox.getSelectedItem()));
					((Clinic) clinics.getSelectedItem()).getPatList().add(p);
					allPatients.put(Integer.parseInt(idfield.getText()), p);
					patientsbox.addItem (p);
					p.setFee(((Doctor) docsb.getSelectedItem()).getVisitCost() + ((Drug) drugsbox.getSelectedItem()).getPrice());
					pane.setText(null);
					pane.append("New patient is registered succesfully.");
					
				// if the patient is already registered and wants to register for another examination
				// and if the doctor is available at selected time
				// register button adds the patient to the selected doctors list and doctors schedule,
				// adds the patient to the patients list of the clinic,
				// resets the fee of the patient,
				// prints the appropriate message
					
				} else if (!((Doctor) docsb.getSelectedItem()).getSchedule().containsValue(times.getSelectedItem()) && 
						((Clinic) clinics.getSelectedItem()).getDocList().contains(((Doctor) docsb.getSelectedItem())) &&
						allPatients.containsKey(Integer.parseInt(idfield.getText()))) {
					
					((Doctor) docsb.getSelectedItem()).addExistingPatient(allPatients.get(Integer.parseInt(idfield.getText())), (String)times.getSelectedItem());
					((Doctor) docsb.getSelectedItem()).getSchedule().put(allPatients.get(Integer.parseInt(idfield.getText())), (String) times.getSelectedItem());
					((Doctor) docsb.getSelectedItem()).getPatientsofdoc().add(allPatients.get(Integer.parseInt(idfield.getText())));
					((Clinic) clinics.getSelectedItem()).getPatList().add((allPatients.get(Integer.parseInt((idfield.getText())))));
					allPatients.get(Integer.parseInt(idfield.getText())).setFee(allPatients.get(Integer.parseInt(idfield.getText())).getFee() + ((Doctor) docsb.getSelectedItem()).getVisitCost());
					pane.setText(null);
					pane.append("Patient is registered succesfully to another appointment.");
				}		
			}
		} );
		
		//Action for the display buttton
		//Displays(sorted acording to age and gender) patients in selected clinic 
		display.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				pane.setText(null);
				Collections.sort(((Clinic) clinics.getSelectedItem()).getPatList());
				pane.append("Patients in the " + ((Clinic) clinics.getSelectedItem()).getName() + " clinic are listed: \n");
				for (int i = 0; i < ((Clinic) clinics.getSelectedItem()).getPatList().size(); i++) {
					pane.append(((Clinic) clinics.getSelectedItem()).getPatList().get(i).toString() + "\n");
				}
			}
		} );
		
		//Action for the displaydoctors button
		//Displays the doctors schedule of the selected clinic
		displaydoctors.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				pane2.setText(null);
				pane2.append("In the " + ((Clinic) clinics2.getSelectedItem() + " clinic doctor's schedules is: \n" ));
								
				for(int i = 0; i < ((Clinic) clinics2.getSelectedItem()).getDocList().size(); i++) {
					pane2.append(((Clinic) clinics2.getSelectedItem()).getDocList().get(i).toString() + " has the schedule: \n");
					pane2.append(((Clinic) clinics2.getSelectedItem()).getDocList().get(i).toString2(((Clinic) clinics2.getSelectedItem()).getDocList().get(i).getSchedule()) + "\n");
					
					
				}	
			}
		} );
		
		//Action for the drugadd button
		//By this button doctors can add new drug for patients
		//If the selected drug conflicts with any drug in the total drugs of the patient
		//It does not add the drug and prints the appropriate message
		drugadd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				HashSet<Drug> confs = new HashSet<Drug>();
				
				for( int i = 0; i < ((Patient) patientsbox.getSelectedItem()).getDrugs().size();  i++) {
					for(int k = 0; k < ((Patient) patientsbox.getSelectedItem()).getDrugs().get(i).getConflicts().size(); k++) {
						confs.add(((Patient) patientsbox.getSelectedItem()).getDrugs().get(i).getConflicts().get(k));
					}
					
				}
				
				if(!((Patient) patientsbox.getSelectedItem()).getOldDrugs().contains(((Drug) drugbox2.getSelectedItem())) &&
						!confs.contains(((Drug) drugbox2.getSelectedItem())))
				{
					pane2.setText(null);
					pane2.append(((Drug) drugbox2.getSelectedItem()).getName() + " succesfully added.");
					((Patient) patientsbox.getSelectedItem()).getNewDrugs().add(((Drug) drugbox2.getSelectedItem()));
					((Patient) patientsbox.getSelectedItem()).getDrugs().add(((Drug) drugbox2.getSelectedItem()));
					((Patient) patientsbox.getSelectedItem()).setFee(((Patient) patientsbox.getSelectedItem()).getFee() + ((Drug) drugbox2.getSelectedItem()).getPrice());

				} else {
					
					pane2.setText(null);
					pane2.append("Some drugs are in the conflict list");
				}	
			}
		} );
		
		//Action for displaypatients button
		//It prints the selected patients name and drugs used or being used by that patient
		displaypatients.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				pane2.setText(null);
				pane2.append(((Patient) patientsbox.getSelectedItem()).toString());
				
			}
		} );
		
		//Action for totalfee button 
		//Prints the total fee of the selected patient
		totalfee.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				pane2.setText(null);
				pane2.append("The total fee of the patient " + ((Patient) patientsbox.getSelectedItem()).getName() + " is: " + ((Patient) patientsbox.getSelectedItem()).getFee() + "TL");
				
			}
		} );
		
		//Action for doctorincomes button
		//It prints the incomes of the doctors of the selected clinic
		doctorincomes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				pane2.setText(null);
				pane2.append("Income of the doctors in the " + ((Clinic) clinics2.getSelectedItem()).getName() + "is: \n" );
				
				for (int i = 0; i < ((Clinic) clinics2.getSelectedItem()).getDocList().size(); i++) {
					pane2.append("Dr." + ((Clinic) clinics2.getSelectedItem()).getDocList().get(i).getName() + ":");
					pane2.append(((Clinic) clinics2.getSelectedItem()).getDocList().get(i).docIncome() + "TL \n");
				}	
			}
		} );
		
		//Action for the clinicprofit button
		//it calculates the profit of selected clinic by using total fee of the patients of the selected clinic,
		//total income of the doctors of the selected clinic and
		//total profit which gained from the new drugs added to the patients of the selected clinic
		//by substracting total incomes of doctors and half of the price of the newly added drugs
		//from the total fee which patients pay of the selected clinic.
		clinicprofit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				double x = 0;
				double y = 0;
				double z = 0;
				
				for (int i = 0; i < ((Clinic) clinics2.getSelectedItem()).getPatList().size(); i++) {
					x += ((Clinic) clinics2.getSelectedItem()).getPatList().get(i).getFee();
				}
				for (int k = 0; k < ((Clinic) clinics2.getSelectedItem()).getDocList().size(); k++) {
					y += ((Clinic) clinics2.getSelectedItem()).getDocList().get(k).docIncome();
				}
				for (int m = 0; m < ((Clinic) clinics2.getSelectedItem()).getPatList().size(); m++) {
					for (int n = 0; n < ((Clinic) clinics2.getSelectedItem()).getPatList().get(m).getNewDrugs().size(); n++) {
						z += ((Clinic) clinics2.getSelectedItem()).getPatList().get(m).getNewDrugs().get(n).getPrice()/2;
					}
				}
				
				double c = x-y-z;
				pane2.setText(null);
				pane2.append("Profit of the clinic " + ((Clinic) clinics2.getSelectedItem()).getName() + " is: \n" + c + "TL" );
			}
		} );
		}
}
