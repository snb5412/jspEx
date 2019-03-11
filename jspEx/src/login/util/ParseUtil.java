package login.util;

public class ParseUtil {
	public static int parseInt(String value) {
		return parseInt(value, 1);
	}

	public static int parseInt(String value, int def) {
		int num = def;
		if(value != null) {
			try {
				num = Integer.parseInt(value);				
			} catch (Exception e) {

			}
		}
		return num;
	}
}
