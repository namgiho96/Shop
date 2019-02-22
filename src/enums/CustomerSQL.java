package enums;


public enum CustomerSQL {

	SIGNIN, SIGNUP,LIST,ROW_COUNT,PHONE_LIST,CUST_RETRIEVE,CUST_UPDATE, UPDATE_PROFILE_IMG, CUST_REMOVE;

	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS("
					+ "CUSTOMER_ID,"
					+ "CUSTOMER_NAME,"
					+ "PASSWORD,"
					+ "SSN,"
					+ "PHONE,"
					+ "POSTALCODE,"
					+ "CITY,"
					+ "ADDRESS,"
					+ "PHOTO)"
					+ "VALUES(?, ?, ?, ?,?,?,?,?,'1020')");
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
			break;
		case PHONE_LIST:
			query.append("SELECT CUSTOMER_NAME,PHONE,CUSTOMER_ID \n" + 
					"FROM CUSTOMERS C");
			break;
		case CUST_RETRIEVE:
			query.append("SELECT CUSTOMER_ID,CUSTOMER_NAME,SSN,PHONE,POSTALCODE,CITY,ADDRESS,PASSWORD \n" + 
					"FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
	case CUST_UPDATE:
			query.append("UPDATE\n" + 
					"(select *\n" + 
					"from customers\n" + 
					"where CUSTOMER_ID like ?)\n" + 
					"set password = ?, phone = ?,\n" + 
					"city = ?,\n" + 
					"address = ?, POSTALCODE = ?\n" + 
					"");
			break;
	case UPDATE_PROFILE_IMG:
		query.append("");
		
		break;
	case CUST_REMOVE:
		query.append("DELETE FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
		
		break;
		default:
			break;
		}
		
		return query.toString();
	}
}
