package studentdbms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import studentdbms.entity.Course;
import studentdbms.entity.Student;
import studentdbms.service.CourseService;
import studentdbms.service.StudentService;

@SpringBootApplication
public class StudentDBMSApplication implements CommandLineRunner
{
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentDBMSApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Student student = new Student("Rakesh", "Yamala","rakesh2116@gmail.com","7993462116", "Nellore", "4A2");
		Student student1 = new Student("Archana", "Repalle","archanarepalle840@gmail.com","6301007964", "Karnool", "473");
		Student student2 = new Student("VenkataSai", "pogula","venkatasaipogula00@gmail.com","8096221578", "Parchur", "336");
		Student student3 = new Student("Nagireddy", "Damireddy","balanagireddydamireddy1@gmail.com","7569988324", "Kanigiri", "336");
		studentService.save(student);
		studentService.save(student1);
		studentService.save(student2);
		studentService.save(student3);
		Course course = new Course("Spring Boot");
		courseService.save(course);
		student.addCourse(course);
		student1.addCourse(course);
		student2.addCourse(course);
		student3.addCourse(course);
		studentService.save(student);
		studentService.save(student1);
		studentService.save(student2);
		studentService.save(student3);
		course.addStudent(student);
		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);
		courseService.save(course);
	}

}
