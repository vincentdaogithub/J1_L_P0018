package J1_L_P0018.business;

import java.io.IOException;
import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.tools.CheckFormat;
import J1_L_P0018.tools.ReadUserInput;

public class AskUserID {
	// ask user for input (Get ID to delete)
	public static final String ask() {
		boolean exit = false;
		String input;

		while (!exit) {
			System.out.print("Enter CD's ID: ");

			try {
				input = ReadUserInput.readString();

				if (input == null) {
					Logger.log(Error.INVALID_CD_ID.toString());
					System.out.println(Error.INVALID_CD_ID.toString());
					continue;
				}

				// check empty
				if (input.isEmpty()) {
					exit = true;
					continue;
				}

				// check format
				if (CheckFormat.check(input, CD.ID_FORMAT) != true) {
					throw new Exception();
				}

				return input;
			} catch (IOException e) {
				Logger.log(Error.CANNOT_READ_USER_INPUT.toString());
				throw new RuntimeException(Error.CANNOT_READ_USER_INPUT.toString());
			} catch (Exception e) {
				Logger.log(Error.INVALID_CD_ID.toString());
				System.out.println(Error.INVALID_CD_ID.toString());
			}
		}

		return null;
	}
}
