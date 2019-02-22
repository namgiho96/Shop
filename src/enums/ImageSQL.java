package enums;

public enum ImageSQL {
	
	IMAGE_INSERT,IMAGE_SEQ;
	
	@Override
	public String toString() {
		
		StringBuffer query = new StringBuffer();
		
		switch (this) {
		case IMAGE_INSERT:
			
			query.append("INSERT INTO IMAGE(IMG_SEQ,IMG_NAME,IMG_EXTENTION,OWNER)\n" + 
					"VALUES(IMG_SEQ.NEXTVAL,?,?,?)");
			break;
		case IMAGE_SEQ:
			query.append("SELECT MAX(IMG_SEQ) IMG_SEQ \n" + 
					"FROM IMAGE \n");

			
		default:
			break;
		}
		
		
		return query.toString();
		
	}
}
	

