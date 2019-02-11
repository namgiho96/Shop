package enums;

public enum CustomerSQL {

	SIGNIN, SIGNUP,LIST;

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
			query.append("SELECT * FROM CUSTOMERS");
		default:
			break;
		}
		
		return query.toString();
	}
}
