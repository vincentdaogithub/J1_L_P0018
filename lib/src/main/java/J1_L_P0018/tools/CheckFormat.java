package J1_L_P0018.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;

public class CheckFormat {
	public static final boolean check(String toCheck, String format) {
		try {
			Pattern pattern = Pattern.compile(format.toUpperCase());
			Matcher matcher = pattern.matcher(toCheck.toUpperCase());
			
			return matcher.matches();
		} catch (Exception e) {
			Logger.log(Error.CANNOT_CHECK_FORMAT.toString());
			throw new RuntimeException(Error.CANNOT_CHECK_FORMAT.toString());
		}
	}
}
