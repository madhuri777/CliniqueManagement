package pojo;

public class Appointment {
	//private Doctor doctor;
	//private int patient_id;
	private Patients patient;
	private int doctor_id;
	//private String patient_name;
	private String doctor_name;
	private String specilaization;
	private String date;
	private int d_count;
	
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Patients getPatient() {
		return patient;
	}
	public void setPatient(Patients patient) {
		this.patient = patient;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getSpecilaization() {
		return specilaization;
	}
	public void setSpecilaization(String specilaization) {
		this.specilaization = specilaization;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getD_count() {
		return d_count;
	}
	public void setD_count(int d_count) {
		this.d_count = d_count;
	}
	@Override
	public String toString() {
		return "Appointment [patient=" + patient + ", doctor_id=" + doctor_id + ", doctor_name=" + doctor_name
				+ ", specilaization=" + specilaization + ", date=" + date + ", d_count=" + d_count + "]";
	}
	

	
	

}
