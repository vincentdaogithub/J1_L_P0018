package J1_L_P0018.business;

import java.time.LocalDate;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.tools.ConvertUserInput;
import J1_L_P0018.tools.ReadUserInput;

public class AskUserYear {
	public static final int ask() {
		boolean exit = false;
		String input;

		while (!exit) {
			System.out.print("Enter CD's year: ");

			try {
				input = ReadUserInput.readString();
				
				if (input == null) {
					Logger.log(Error.INVALID_CD_YEAR.toString());
					System.out.println(Error.INVALID_CD_YEAR.toString());
					continue;
				}

				// check empty
				if (input.isEmpty()) {
					exit = true;
					continue;
				}

				Integer year = ConvertUserInput.toInt(input);

				// check year
				if (year == null || year < 0 || LocalDate.now().getYear() < year) {
					throw new Exception();
				}

				return year;
			} catch (Exception e) {
				Logger.log(Error.INVALID_CD_YEAR.toString());
				System.out.println(Error.INVALID_CD_YEAR.toString());
			}
		}

		return LocalDate.MIN.getYear();
	}
}
