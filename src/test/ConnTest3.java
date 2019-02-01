package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Props;

public class ConnTest3 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(Props.DB_DRIVER.getValue());
			
			
			String sql = "SELECT COUNT(*) AS COUNT FROM EMPLOYEES";
			
			
			conn = DriverManager.getConnection(
					Props.DB_URL.getValue(),
					Props.DB_USER.getValue(),
					Props.DB_PASS.getValue());
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			String count = "";
			
			while(rs.next()) {
					count = rs.getString("COUNT");
			}
			System.out.println("카운트"+count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
