package enums;


public enum CustomerSQL {

	SIGNIN, SIGNUP,LIST,COUNT;

	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTALCODE,CITY,ADDRESS)"
					+ "VALUES(?, ?, ?, ?,?,?,?,?)");
			break;
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		case LIST:
			query.append(" SELECT *\r\n" + 
					" FROM(SELECT ROWNUM RNUM ,C.*  \r\n" + 
					"					 FROM CUSTOMERS C  \r\n" + 
					"					ORDER BY ROWNUM  DESC) \r\n" + 
					"					 WHERE RNUM BETWEEN ? AND ?");
			break;
		case COUNT:
			query.append("	SELECT COUNT(*) count\n" + 
					"	FROM CUSTOMERS");
		default:
			break;
		}
		
		return query.toString();
	}
}
