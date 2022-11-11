package J1_L_P0018.persistance.operations;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

class PrintAllCDs {
	public static final void print(CDStorage storage) {
		Logger.log("Printing all CDs...");

		if (storage == null) {
			Logger.log(Error.NULL_ARGUMENT.toString());
			throw new NullPointerException(Error.NULL_ARGUMENT.toString());
		}

		CD[] tmpStorage = storage.getStorage();
		int tmpSize = storage.getSize();

		// null storage
		if (tmpStorage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}
		
		// check if storage is empty
		if (tmpSize <= 0) {
			Logger.log("Empty storage");
			return;
		}

		// print the CD
		for (int i = 0; i < tmpSize; i++) {
			System.out.println(GetCDInformation.get(tmpStorage[i]));
		}

		Logger.log("CDs printed");
	}
}
