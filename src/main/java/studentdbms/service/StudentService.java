package studentdbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import studentdbms.entity.Student;
import studentdbms.repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Student findById(int id) {
		return studentRepository.findById(id).get();
	}
	
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	//my

	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return ((StudentService) studentRepository).getStudentById(id);
	}

	public void saveOrUpdateStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		
	}
	public List<Student> searchByName(String keyword) {
        return studentRepository.findByFirstNameContainingIgnoreCase(keyword);
    }
	
}
