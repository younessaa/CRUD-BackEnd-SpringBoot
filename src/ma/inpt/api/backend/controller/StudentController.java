package ma.inpt.api.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ma.inpt.api.backend.model.Student;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/")
public class StudentController {
	private static List<Student> list = new ArrayList<>();
	
	static {
		list.add(new Student("Nom 1", "Casablanca"));
		list.add(new Student("Nom 2", "Rabat"));
		list.add(new Student("Nom 3", "Sale"));
		list.add(new Student("Nom 4", "Tanger"));
		list.add(new Student("Nom 5", "Fes"));
	}
	
	// get all students
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
	}
	
	// create student
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		student.setId(Student.i++);
		list.add(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	// get student by id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id)
				student = list.get(i);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	// update student by id 
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		Student student = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id)
				student = list.get(i);
		}
		student.setName(studentDetails.getName());
		student.setCity(studentDetails.getCity());
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	// delete student by id
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id)
				list.remove(i);
		}
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return new ResponseEntity<Map<String, Boolean>>(response, HttpStatus.OK);
	}
	
}
