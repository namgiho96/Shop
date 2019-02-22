package enums;
public enum EmployeeSQL {
	REGISTER,ACCESS;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case REGISTER:
			query.append(" INSERT INTO EMPLOYEES(EMPLOYEE_ID,\n" + 
					"					MANAGER,\n" + 
					"					NAME,\n" + 
					"					BIRTH_DATE,\n" + 
					"					PHOTO,\n" + 
					"					NOTES) VALUES(EMP_SEQ.NEXTVAL,?,?,?,'1036',?)");
			break;
		case ACCESS:
			query.append("SELECT NAME \n" + 
					"FROM EMPLOYEES E\r\n" + 
					"WHERE  EMPLOYEE_ID LIKE ? AND NAME LIKE ?"); // ? 는 카운트다

			break;
		}
		return query.toString();
	}
 
}
