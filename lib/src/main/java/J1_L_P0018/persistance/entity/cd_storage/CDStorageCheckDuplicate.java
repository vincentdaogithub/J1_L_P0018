package J1_L_P0018.persistance.entity.cd_storage;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;

class CDStorageCheckDuplicate {
	public static final boolean check(CDStorage storage) {
		Logger.log("Checking CD storage's duplication...");

		// null storage
		if (storage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		CD[] tmpStorage = storage.getStorage();
		int tmpSize = storage.getSize();

		// check duplicate CD's ID
		for (int i = 0; i + 1 < tmpSize; i++) {
			if (tmpStorage[i].getId().equals(tmpStorage[i + 1].getId())) {
				Logger.log(Error.DUPLICATE_CD.toString());
				return false;
			}
		}

		// no duplicate CD
		Logger.log("No duplicate CD");
		return true;
	}
}
