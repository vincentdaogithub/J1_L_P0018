package J1_L_P0018.tools;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;

public class ConvertUserInput {
	// convert to int
	public static final Integer toInt(String input) {
		if (input == null) {
			Logger.log(Error.NULL_ARGUMENT.toString());
			return null;
		}

		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			Logger.log(Error.CANNOT_CONVERT_TO_INT.toString());
			return null;
		}
	}

	// convert to float
	public static final float toFloat(String input) {
		if (input ==  null) {
			Logger.log(Error.NULL_ARGUMENT.toString());
			return Float.NaN;
		}
		
		try {
			return Float.parseFloat(input);
		} catch (Exception e) {
			Logger.log(Error.CANNOT_CONVERT_TO_FLOAT.toString());
			return Float.NaN;
		}
	}
}
