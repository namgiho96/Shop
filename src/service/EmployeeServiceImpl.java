package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
		
	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();
	private EmployeeServiceImpl() {dao = EmployeeDAOImpl.getInstance();};
	public static EmployeeServiceImpl getInstance() {
		return instance;
	}
	EmployeeDAO dao;


	@Override
	public void registEmployee(EmployeeDTO emp) {
		System.out.println(">>>>>>서비스임플 진입<<<<<<");
		dao.insertEmployee(emp);
	}

	@Override
	public List<EmployeeDTO> bringEmployee() {
		
		return dao.selectEmployee();
	}

	@Override
	public List<EmployeeDTO> retriveEmployees(String serachWord) {
		return dao.selectEmployees(serachWord);
	}

	@Override
	public EmployeeDTO retriveEmployee(String serachWord) {
		return dao.selectEmployee(serachWord);
	}

	@Override
	public int countEmplotees() {
		return 0;
	}

	@Override
	public boolean existEmployee(EmployeeDTO emp) {
		return dao.existsEmployee(emp);
	}

	@Override
	public void modfyEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub

	}

}
