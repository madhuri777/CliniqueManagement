package pojo;

public class Doctor {

	private String  d_name;
	private int d_id;
	private String specialization;
	private  String availability;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return d_name;
	}
	public void setName(String name) {
		this.d_name = name;
	}
	public int getId() {
		return d_id;
	}
	public void setId(int id) {
		this.d_id = id;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Doctor [d_name=" + d_name + ", d_id=" + d_id + ", specialization=" + specialization + ", availability="
				+ availability + ", count=" + count + "]";
	}
	
	
}
