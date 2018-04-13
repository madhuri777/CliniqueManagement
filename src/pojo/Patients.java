package pojo;

public class Patients {
 
	private String p_name;
	private int p_id;
	private long phoneno;
	private int age;
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Patients [p_name=" + p_name + ", p_id=" + p_id + ", phoneno=" + phoneno + ", age=" + age + "]";
	}
	
	
}
