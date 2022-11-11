package J1_L_P0018.tools;

import java.util.Scanner;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;

public class ReadUserInput {
	public static final String readString() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		Logger.log("Reading user input...");

		try {
			return scanner.hasNextLine() ? scanner.nextLine().trim() : null;
		} catch (Exception e) {
			Logger.log(Error.CANNOT_READ_USER_INPUT.toString());
			return null;
		}
	}
}
