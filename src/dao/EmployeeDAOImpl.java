package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.Databasefactory;

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
		try {
            System.out.println("=====6.다오임플진입====");
            String sql = EmployeeSQL.REGISTER.toString();
            System.out.println("===실행 쿼리==="+sql);
            Connection conn = Databasefactory.createDatabase(Vendor.ORACLE).getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, emp.getManager());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getBirthDate());
            pstmt.setString(4, emp.getPhoto());
            pstmt.setString(5, emp.getNotes());
            int rs = pstmt.executeUpdate();
            System.out.println((rs==1)?"입력성공":"입력실패");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
