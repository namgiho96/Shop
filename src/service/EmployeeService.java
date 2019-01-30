package service;

import java.util.List;

import domain.EmployeeDTO;

public interface EmployeeService {
	
	public void addEmployee(EmployeeDTO emp);

	public List<EmployeeDTO> bringEmployee();

	public List<EmployeeDTO> retriveEmployees(String serachWord);

	public EmployeeDTO retriveEmployee(String serachWord);

	public int countEmplotees();

	public boolean existEmployee(String serachWord);

	public void modfyEmployee(EmployeeDTO emp);

	public void removeEmployee(EmployeeDTO emp);
}
