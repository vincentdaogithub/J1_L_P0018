package J1_L_P0018.persistance.operations;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

class DeleteCDFromStorage {
	// delete CD from storage
	public static final void delete(CDStorage storage, String id) {
		Logger.log("Deleting CD...");

		if (storage == null || id == null) {
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

		// check storage's integrity
		if (storage.check() != true) {
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			System.out.println(Error.CORRUPTED_STORAGE.toString());
			return;
		}

		// check if the storage is empty
		if (tmpSize <= 0) {
			Logger.log(Error.EMPTY_STORAGE.toString());
			System.out.println(Error.EMPTY_STORAGE.toString());
			return;
		}

		// search for the CD
		for (int i = 0; i < tmpSize; i++) {
			// found
			if (tmpStorage[i].getId().equals(id)) {
				for (int j = i; j + 1 < tmpSize; j++) {
					tmpStorage[j] = tmpStorage[j + 1];
				}

				tmpStorage[--tmpSize] = null;
				storage.setSize(tmpSize);

				// check storage again
				if (storage.check() != true) {
					Logger.log(Error.CORRUPTED_STORAGE.toString());
					throw new RuntimeException(Error.CORRUPTED_STORAGE.toString());
				}

				Logger.log("CD deleted");
				System.out.println("CD deleted");

				return;
			}
		}

		// not found
		Logger.log("CD not found");
		System.out.println("CD not found");
	}
}
