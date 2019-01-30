package dao;

import java.util.List;

import domain.EmployeeDTO;

	

public interface EmployeeDAO {
	
	public void insertEmployee(EmployeeDTO emp);

	public List<EmployeeDTO> selectEmployee();

	public List<EmployeeDTO> selectEmployees(String serachWord);

	public EmployeeDTO selectEmployee(String serachWord);

	public int countEmplotees();

	public boolean existsEmployee(String serachWord);

	public void updateEmployee(EmployeeDTO emp);

	public void deleteEmployee(EmployeeDTO emp);
}
