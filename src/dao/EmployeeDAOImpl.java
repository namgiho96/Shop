package dao;

import java.util.List;
import domain.EmployeeDTO;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {
		dao = EmployeeDAOImpl.getInstance();
	}
	public static EmployeeDAOImpl getInstance() {
		return instance;
	}
	EmployeeDAOImpl dao;

	@Override
	public void insertEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeDTO> selectEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> selectEmployees(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO selectEmployee(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmplotees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsEmployee(String serachWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub

	}

}
