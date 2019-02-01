package enums;

public enum Props{
	
	DB_DRIVER("oracle.jdbc.OracleDriver"), //final static String DB_DRIVER = "aaaa"안쓴다
	DB_USER("oracle"),
	DB_PASS("password"),
	DB_URL("jdbc:oracle:thin:@localhost:1521:xe");
	
	private String value;
		
	private Props(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	
}
	
	





