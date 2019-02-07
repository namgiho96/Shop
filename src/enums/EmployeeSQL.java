package enums;
/*
 *  employee  
 *  employeeID,
 *  manager
 *  ,name
 *  ,BirthDate
 *  ,photo
 *  ,notes;
 *  
 *  
 * */
public enum EmployeeSQL {
	REGISTER,ACCESS;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES(EMPLOYEE_ID,MANAGER,NAME,BIRTH_DATE,PHOTO,NOTES) VALUES(EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
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
