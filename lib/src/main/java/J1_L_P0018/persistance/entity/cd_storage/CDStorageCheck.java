package J1_L_P0018.persistance.entity.cd_storage;

import java.util.Arrays;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;

// class to check CD storage, only logs the states
class CDStorageCheck {
	// checks the integrity of the storage
	public static final boolean check(CDStorage storage) {
		Logger.log("Checking CD storage's integrity...");

		// null storage
		if (storage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		CD[] tmpStorage = storage.getStorage();
		int tmpSize = storage.getSize();

		// null CD array
		if (tmpStorage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		// invalid storage size
		if (tmpSize < 0 || CDStorage.MAX_SIZE < tmpSize) {
			Logger.log(Error.INVALID_STORAGE_SIZE.toString());
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			return false;
		}

		// checks if there's null value in array while walking through
		// the array and the max index (MAX_SIZE - 1) hasn't been reached
		for (int i = 0; i < tmpSize; i++) {
			if (tmpStorage[i] == null) {
				Logger.log(Error.CORRUPTED_STORAGE.toString());
				return false;
			}
		}

		// sort the array for second step
		Arrays.sort(tmpStorage, 0, tmpSize);

		// check for duplicate CD
		if (CDStorageCheckDuplicate.check(storage) != true) {
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			return false;
		}

		Logger.log("CD storage is fine");
		return true;
	}
}
