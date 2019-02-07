package enums;

public enum CustomerSQL {

	SIGNIN, SIGNUP;

	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,ADDRESS,CITY,POSTALCODE,SSN)"
					+ "VALUES( ?, ?, ?, ?, ?,?,?)");
			break;
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			
			break;
		default:
			break;
		}
		
		return query.toString();
	}
}
