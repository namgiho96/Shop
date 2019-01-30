package factory;

import pool.Constant;

public class DatabaseFactory {
	public static DateBase createDatebase(
			String vender 
			) {
		DateBase base = null;
		switch(vender) {
		case "oracle":
			base = new Oracle(
					Constant.ORACLE_DRIVER,
					Constant.ORACLE_URL,
					Constant.USERNAME,
					Constant.PASSWORD);
			break;
		}
		return base;
		
	}
}
