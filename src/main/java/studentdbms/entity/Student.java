package studentdbms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student 
{
	@Id
	@GeneratedValue
	private int id;
	
	/*
	 * @Column private String name;
	 */
	/*
	 * @Column private String firstName;
	 * 
	 * @Column private String lastName;
	 * 
	 * @Column private String email;
	 * 
	 * @Column private Integer mobileNumber;
	 * 
	 * @Column private String address;
	 * 
	 * @Column private String rollNumber;
	 */
	@Column(name = "first_name")  // Correct naming convention
    private String firstName;

    @Column(name = "last_name")  // Correct naming convention
    private String lastName;

    @Column
    private String email;

    @Column(name = "mobile_number")  // Correct naming convention
    private String mobileNumber;

    @Column
    private String address;

    @Column(name = "roll_number")  // Correct naming convention
    private String rollNumber;
	
	public Student(String firstName, String laststName, String email, String mobileNumber, String address,
			String rollNumber) {
		super();
		this.firstName = firstName;
		this.lastName = laststName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.rollNumber = rollNumber;
	}

	@OneToOne
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", 
		joinColumns = @JoinColumn(name="STUDENT_ID"), 
		inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>();

	public Student() {}

	/*
	 * public Student(String name) { this.name = name; }
	 */

	public int getId() {
		return id;
	}

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
	 	return "Student [id=" + ", firstName=" + firstName + ", laststName=" + lastName
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", address=" + address + ", rollNumber="
				+ rollNumber + ", passport=" + passport + ", courses=" + courses + "]";
	}
}
