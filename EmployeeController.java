package springJPAnew.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


	@Autowired
	private EmplyeeService emplyeeService;

	// build create employee REST API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(emplyeeService.saveEmployee(employee), HttpStatus.CREATED);

	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployee() {
		return emplyeeService.getAllEmployee();
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") long empId) {
		return new ResponseEntity<Employee>(emplyeeService.getEmpById(empId), HttpStatus.OK);

	}

	// update employee
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long empId, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(emplyeeService.updateEmpById(empId, employee), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long empId) {
		emplyeeService.deleteEmpById(empId);
		return new ResponseEntity<String>("Emplyee deleted succcessfully...", HttpStatus.OK);

	}
}
