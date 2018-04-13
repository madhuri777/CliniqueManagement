package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import pojo.Appointment;
import pojo.Doctor;
import pojo.Patients;

public class AddDetails {
	private List<Doctor> doctr_list = new ArrayList<Doctor>();
	private List<Patients> patient_list = new ArrayList<Patients>();
	private List<Appointment> apptment = new ArrayList<Appointment>();
	private ObjectMapper objectMapper = new ObjectMapper();
	File file;
	private Scanner scanner = new Scanner(System.in);
	Doctor doctor = new Doctor();
	Patients patient = new Patients();
	Appointment appointment = new Appointment();
	String jsonArray;
	
	

	/*public void add() throws Exception {
		System.out.println("AddDetails:----1.AddDoctor----2.AddPatient----3.Back----" 3.takeAppointment );
		System.out.println("Enter your option:");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			addDoctor();
			break;
		case 2:
			addPatients();
			break;
		
		 * case 3: manager; break;
		 
		}
	}*/

	/* add new Doctors */
	public void addDoctor() throws Exception {
		File file = new File("Doctor.json");
		doctr_list = fileReader(file, Doctor.class);
		System.out.println("Enter doctor's Name: ");
		String dname = scanner.next();
		doctor.setName(dname);

		System.out.println("Enter doctor's ID: ");
		int id = scanner.nextInt();
		doctor.setId(id);

		System.out.println("Enter doctor's Specialization: ");
		String specialization = scanner.next();
		doctor.setSpecialization(specialization);

		System.out.println("Enter Availability of doctor: 'AM' OR 'PM' OR 'Both'");
		String time = scanner.next();
		doctor.setAvailability(time);

		doctr_list.add(doctor);
		try {
			objectMapper.writeValue(file, doctr_list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* add new Patients */
	public void addPatients() {
		file = new File("Patients.json");
		patient_list = fileReader(file, Patients.class);
		
		System.out.println("Enter Patient Name: ");
		String pname = scanner.next();
		patient.setP_name(pname);

		System.out.println("Enter patient id: ");
		int id = scanner.nextInt();
		patient.setP_id(id);

		System.out.println("Enter contact number: ");
		long phoneno = scanner.nextLong();
		patient.setPhoneno(phoneno);

		System.out.println("Enter Age of Patient: ");
		int age = scanner.nextInt();
		patient.setAge(age);

		patient_list.add(patient);
		try {
			objectMapper.writeValue(file, patient_list);
			System.out.println(patient_list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Take Appointment */
	public void takeAppointment() throws Exception {
		 int counter = 0;
		System.out.println("==AppointMent File==");
		File file = new File("AppointMent.json");
		
		apptment = fileReader(file, Appointment.class);
		System.out.println("==Doctor File==");
		File file1 = new File("Doctor.json");
		doctr_list = fileReader(file1, Doctor.class);

		System.out.println("Todays date:");
		String date = scanner.next();
		appointment.setDate(date);
		System.out.println("Enter Patient Name:");
		String pname = scanner.next();
		patient.setP_name(pname);
		System.out.println("Enter aptient id:");
		int pid = scanner.nextInt();
		patient.setP_id(pid);
		System.out.println("Enter patient phone number:");
		int phoneno = scanner.nextInt();
		patient.setPhoneno(phoneno);
		System.out.println("Enter age of patient:");
		int age = scanner.nextInt();
		patient.setAge(age);
		appointment.setPatient(patient);

		System.out.println("Enter Doctor Name:");
		String dname = scanner.next();
		appointment.setDoctor_name(dname);
		System.out.println("Enter Doctor Id");
		int did = scanner.nextInt();
		appointment.setDoctor_id(did);
		System.out.println("Enter Doctor Specialization");
		String splztn = scanner.next();
		appointment.setSpecilaization(splztn);

		for (Doctor doctor : doctr_list) {
			if (doctor.getName().equals(dname) && doctor.getId() == did) {
				//System.out.println("i got name of doctor:");

				// counter = counter + 1;
				//appointment.setD_count(counter);
				if (doctor.getCount() < 5) {
					System.out.println("AppointMent Fixed");
					appointment.setD_count(appointment.getD_count()+1);
					doctor.setCount(doctor.getCount() + 1);
					//File file1 = new File("Doctor.json");
					objectMapper.writeValue(file1, doctr_list);
					apptment.add(appointment);
					break;
				} else {
					System.out.println("Doctor is Not available Today");
					//appointment.setD_count(0);
					doctor.setCount(0);
					//File file1 = new File("Doctor.json");
					objectMapper.writeValue(file1, doctr_list);

				}
			}
		}
		try {
			objectMapper.writeValue(file,apptment);
			/*String json = objectMapper.writeValueAsString(apptment);
			System.out.println(json);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AppointMent.json"));
			bufferedWriter.write(json);
			bufferedWriter.flush();
			bufferedWriter.close();*/

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* return doctorList */
	public List<Doctor> doctorList() {
		return doctr_list;
	}

	/* return patientList */
	public List<Patients> patientList() {
		return patient_list;
	}

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
		file = new File("Doctor.json");
		doctr_list = fileReader(file, Doctor.class);
		System.out.println("Enter id for Search the Doctor: ");
		int id = scanner.nextInt();
		System.out.println(doctr_list);
		// doctor=gson.fromJson(file, Doctor.class);
		Iterator<Doctor> itr = doctr_list.iterator();
		while (itr.hasNext()) {
			Doctor doctor = itr.next();

			if (doctor.getId() == id) {

				System.out.println("Doctor Found:");
				System.out.println(doctor.toString());

				break;
			}
		}

	}

	public void searchBySpecialization() {
		file = new File("Doctor.json");
		doctr_list = fileReader(file, Doctor.class);

		System.out.println("Enter doctor's Specialization:");
		String specialization = scanner.next();
		Iterator<Doctor> itr = doctr_list.iterator();
		while (itr.hasNext()) {
			doctor = itr.next();
			if (doctor.getSpecialization().equals(specialization)) {
				// System.out.println("Doctor found:");
				System.out.println(doctor.toString());

				// break;
			}
		}
	}

	public void searchByAvailability() {
		file = new File("Doctor.json");
		doctr_list = fileReader(file, Doctor.class);

		System.out.println("Enter doctor's Availability:");
		String availability = scanner.next();
		Iterator<Doctor> itr = doctr_list.iterator();
		while (itr.hasNext()) {
			doctor = itr.next();
			if (doctor.getAvailability().equals(availability)) {
				// System.out.println("Doctor found:");
				System.out.println(doctor.toString());

			}
		}
	}

	public void searchByPatientId() {
		file = new File("Patients.json");
		patient_list = fileReader(file, Patients.class);

		System.out.println("Enter id for Search the Patient: ");
		int id = scanner.nextInt();

		Iterator<Patients> itr = patient_list.iterator();
		while (itr.hasNext()) {
			patient = itr.next();
			if (patient.getP_id() == id) {
				System.out.println("specializationpatient Found:");
				System.out.println(patient.toString());
				break;
			}
		}
	}

	public void searchBycontactno() {
		file = new File("Patients.json");
		patient_list = fileReader(file, Patients.class);

		System.out.println("Enter ContactNo for Search the Patient: ");
		int contact = scanner.nextInt();
		Iterator<Patients> itr = patient_list.iterator();
		while (itr.hasNext()) {
			patient = itr.next();
			if (patient.getPhoneno() == contact) {
				System.out.println("patient Found:");
				System.out.println(patient.toString());
				break;
			}
		}
	}

	public void searchByPatientName() {
		file = new File("Patients.json");
		patient_list = fileReader(file, Patients.class);

		System.out.println("Enter Patient Name for Search the Patient: ");
		String name = scanner.next();
		Iterator<Patients> itr = patient_list.iterator();
		while (itr.hasNext()) {
			patient = itr.next();
			if (patient.getP_name().equals(name)) {
				System.out.println("patient Found:");
				System.out.println(patient.toString());
				break;
			}
		}
	}

	public <T> List<T> fileReader(File file, Class<T> clazz) {
		List<T> list = null;
		jsonArray = "";
		BufferedReader bufferedReader;
		try {

			bufferedReader = new BufferedReader(new FileReader(file));
			while ((jsonArray = bufferedReader.readLine()) != null) {
				System.out.println(jsonArray);

				JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);

				list = objectMapper.readValue(file, javaType);

			}

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void famousDoctor() {
		System.out.println();
	}
	/*
	 * public void fileDoctor() { // file = new File("Doc // File file1 = new
	 * File(file);tor.json"); System.out.println("DoctorFile: "); try {
	 * BufferedReader reader = new BufferedReader(new FileReader("Doctor.json"));
	 * String arrayToJson;
	 * 
	 * while ((arrayToJson = reader.readLine()) != null) {
	 * 
	 * 
	 * TypeReference<ArrayList<Doctor>> type = new
	 * TypeReference<ArrayList<Doctor>>() { };
	 * //System.out.println("jjjjjjjjjjjjjjj"+ arrayToJson);
	 * //System.out.println("hiiiiiiiiiiiiii"+ type); doctr_list =
	 * objectMapper.readValue(arrayToJson, type);
	 * 
	 * System.out.println(doctr_list);
	 * 
	 * } reader.close(); }catch(JsonMappingException e){ e.printStackTrace();
	 * }catch(JsonParseException e){ e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 * 
	 * public void filePatient() { System.out.println("PtientFile:"); //ObjectMapper
	 * objectMapper2 = new ObjectMapper();
	 * 
	 * try { BufferedReader reader = new BufferedReader(new
	 * FileReader("Patients.json")); String arrayToJson=" ";
	 * 
	 * while ((arrayToJson = reader.readLine()) != null) {
	 * TypeReference<ArrayList<Patients>> type = new
	 * TypeReference<ArrayList<Patients>>() { };
	 * 
	 * System.out.println("jjjjjjjjjjjjjjj"+ arrayToJson);
	 * System.out.println("hiiiiiiiiiiiiii"+ type); patient_list =
	 * objectMapper.readValue(arrayToJson, type);
	 * 
	 * System.out.println(patient_list);
	 * 
	 * } reader.close(); }catch(JsonMappingException e){ e.printStackTrace();
	 * }catch(JsonParseException e){ e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
}
