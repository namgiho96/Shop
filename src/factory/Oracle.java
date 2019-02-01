package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import enums.Props;
import lombok.Data;

@Data
public class Oracle implements Database {

	private Connection conn;
	private String driver, url, user, password;

	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(Props.DB_DRIVER.getValue());// 드라이버를 불러온다
			conn = DriverManager.getConnection(Props.DB_URL.getValue(), Props.DB_USER.getValue(),
					Props.DB_PASS.getValue());// 오라클드라이버 매니저를 불러온다
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}
