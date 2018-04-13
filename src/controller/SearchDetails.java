package controller;

import java.util.Scanner;

public class SearchDetails {

	private Scanner scanner = new Scanner(System.in);

	public void search() {
		System.out.println("Search :----1.Search Doctor----2.Search Patient----:");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			searchDoctor();
			break;
		case 2:
			searchPatient();
			break;
		}
	}

	public void searchDoctor() {
		System.out.println("search doctor by:----1.Doctor_Id----2.specialization----3.Available----");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			searchByDoctorId();
			break;
		case 2:
			searchBySpecialization();
			break;
		case 3:
			searchByAvailability();
			break;
		}

	}

	public void searchPatient() {
		System.out.println("search patient by:----1.Patient_Id----2.Contactno----3.PatientName----");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			searchByPatientId();
			break;
		case 2:
			searchBycontactno();
			break;
		case 3:
			searchByPatientName();
			break;
		}

	}
	public void searchByDoctorId() {
		
	}
	public void searchBySpecialization() {
		
	}
	public void searchByAvailability() {
		
	}
	public void searchByPatientId() {
		
	}
	public void searchBycontactno() {
		
	}
	public void searchByPatientName() {
		
	}
}
