package J1_L_P0018.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;

public class CheckFormat {
	public static final boolean checkFormat(String toCheck, String format) {
		try {
			Pattern pattern = Pattern.compile(format);
			Matcher matcher = pattern.matcher(toCheck);
			
			return matcher.matches();
		} catch (Exception e) {
			Logger.log(Error.CANNOT_CHECK_FORMAT.toString());
			throw new RuntimeException(Error.CANNOT_CHECK_FORMAT.toString());
		}
	}

	public static final boolean findFormat(String toCheck, String format) {
		try {
			Pattern pattern = Pattern.compile(format);
			Matcher matcher = pattern.matcher(toCheck);
			
			return matcher.find();
		} catch (Exception e) {
			Logger.log(Error.CANNOT_CHECK_FORMAT.toString());
			throw new RuntimeException(Error.CANNOT_CHECK_FORMAT.toString());
		}
	}
}
