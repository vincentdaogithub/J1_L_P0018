package J1_L_P0018.business;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CDType;
import J1_L_P0018.tools.ReadUserInput;

public class AskUserType {
	public static final CDType ask() {
		boolean exit = false;
		String input;

		while (!exit) {
			System.out.print("Enter CD's type: ");

			try {
				input = ReadUserInput.readString();
				
				if (input == null) {
					Logger.log(Error.INVALID_CD_TYPE.toString());
					System.out.println(Error.INVALID_CD_TYPE.toString());
					continue;
				}

				if (input.isEmpty()) {
					exit = true;
					continue;
				}

				return CDType.stringToType(input);
			} catch (Exception e) {
				Logger.log(Error.INVALID_CD_ID.toString());
				System.out.println(Error.INVALID_CD_ID.toString());
			}
		}

		return null;
	}
}
