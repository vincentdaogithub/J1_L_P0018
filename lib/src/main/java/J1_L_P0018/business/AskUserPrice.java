package J1_L_P0018.business;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.tools.ConvertUserInput;
import J1_L_P0018.tools.ReadUserInput;

public class AskUserPrice {
	public static final float ask() {
		boolean exit = false;
		String input;

		while (!exit) {
			System.out.print("Enter CD's price: ");

			try {
				input = ReadUserInput.readString();

				if (input == null) {
					Logger.log(Error.INVALID_CD_PRICE.toString());
					System.out.println(Error.INVALID_CD_PRICE.toString());
					continue;
				}

				// check empty
				if (input.isEmpty()) {
					exit = true;
					continue;
				}

				float tmp = ConvertUserInput.toFloat(input);

				if (tmp < 0.0f || Float.isNaN(tmp)) {
					throw new Exception();
				}

				return tmp;
			} catch (Exception e) {
				Logger.log(Error.INVALID_CD_PRICE.toString());
				System.out.println(Error.INVALID_CD_PRICE.toString());
			}
		}

		return -1.0f;
	}
}
