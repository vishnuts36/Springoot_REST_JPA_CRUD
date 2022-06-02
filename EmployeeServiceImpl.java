package springJPAnew.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmplyeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(long id) {
		/*
		 * Optional<Employee> employee = employeeRepository.findById(id);
		 * 
		 * if (employee.isPresent()) { return employee.get(); }else { throw new
		 * ResourceNotFoundException("employee", "id", id); }
		 */
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee", "id", id));
	}

	@Override
	public Employee updateEmpById(long id, Employee employee) {
		Employee existingemployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", id));
		existingemployee.setEmail(employee.getEmail());
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		employeeRepository.save(existingemployee);
		return existingemployee;
	}

	@Override
	public void deleteEmpById(long id) {
		employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", id));
		employeeRepository.deleteById(id);
	}

}
