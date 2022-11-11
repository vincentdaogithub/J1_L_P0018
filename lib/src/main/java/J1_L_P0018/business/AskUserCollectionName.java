package J1_L_P0018.business;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CDCollectionName;
import J1_L_P0018.tools.ReadUserInput;

public class AskUserCollectionName {
	public static final CDCollectionName ask() {
		boolean exit = false;
		String input;

		while (!exit) {
			System.out.print("Enter CD's collection name (Enter without input to exit): ");

			try {
				input = ReadUserInput.readString();

				if (input == null) {
					Logger.log(Error.INVALID_CD_COLLECTION_NAME.toString());
					System.out.println(Error.INVALID_CD_COLLECTION_NAME.toString());
					continue;
				}

				if (input.isEmpty()) {
					exit = true;
				}

				return CDCollectionName.stringToCollectionName(input);
			} catch (Exception e) {
				Logger.log(Error.INVALID_CD_ID.toString());
				System.out.println(Error.INVALID_CD_ID.toString());
			}
		}

		return null;
	}
}
