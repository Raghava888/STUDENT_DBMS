package studentdbms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import studentdbms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

	@Query(name = "Student.findByNameContainingIgnoreCase")
	 List<Student> findByFirstNameContainingIgnoreCase(@Param("name")String keyword);

}
