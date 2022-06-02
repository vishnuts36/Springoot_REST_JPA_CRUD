package springJPAnew.demo;

import java.util.List;

public interface EmplyeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmpById(long id);
	
	Employee updateEmpById(long id, Employee mployee);
	
	void deleteEmpById(long id);

}
