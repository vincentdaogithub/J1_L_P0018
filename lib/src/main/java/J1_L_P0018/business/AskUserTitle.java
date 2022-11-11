package J1_L_P0018.business;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.tools.ReadUserInput;

public class AskUserTitle {
	public static final String ask() {
		boolean exit = false;
		String input;

		while (!exit) {
			System.out.print("Enter CD's title: ");

			try {
				input = ReadUserInput.readString();

				if (input == null) {
					Logger.log(Error.INVALID_CD_TITLE.toString());
					System.out.println(Error.INVALID_CD_TITLE.toString());
					continue;
				}
				
				if (input.isEmpty()) {
					exit = true;
					continue;
				}

				return input;
			} catch (Exception e) {
				Logger.log(Error.INVALID_CD_TITLE.toString());
				System.out.println(Error.INVALID_CD_TITLE.toString());
			}
		}

		return null;
	}
}
