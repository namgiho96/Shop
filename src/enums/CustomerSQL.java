package enums;


public enum CustomerSQL {

	SIGNIN, SIGNUP,LIST,ROW_COUNT;

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
			query.append("select *\r\n" + 
					"from (select  rownum r2 ,t.*\r\n" + 
					"            from (SELECT ROWNUM RNUM ,C.*  \r\n" + 
					"                        FROM CUSTOMERS C  \r\n" + 
					"                        ORDER BY RNUM desc) t)\r\n" + 
					"where r2 between ? and ?");
			break;
		case ROW_COUNT:
			query.append("	SELECT COUNT(*) count\n" + 
					"	FROM CUSTOMERS");
		default:
			break;
		}
		
		return query.toString();
	}
}
