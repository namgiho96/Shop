package service;

import java.util.List;

import domain.EmployeeDTO;

public interface EmployeeService {
	
	public void registEmployee(EmployeeDTO emp);

	public List<EmployeeDTO> bringEmployee();

	public List<EmployeeDTO> retriveEmployees(String serachWord);

	public EmployeeDTO retriveEmployee(String serachWord);

	public int countEmplotees();

	public boolean existEmployee(EmployeeDTO emp);

	public void modfyEmployee(EmployeeDTO emp);

	public void removeEmployee(EmployeeDTO emp);
}
