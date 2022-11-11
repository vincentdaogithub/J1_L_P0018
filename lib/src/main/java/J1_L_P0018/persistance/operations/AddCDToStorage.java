package J1_L_P0018.persistance.operations;

import java.util.Arrays;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

class AddCDToStorage {
	// adds CD to the storage
	public static final void add(CDStorage storage, CD cdToAdd) {
		Logger.log("Adding CD...");

		if (storage == null || cdToAdd == null) {
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
			throw new RuntimeException(Error.CORRUPTED_STORAGE.toString());
		}

		// check if the storage is full
		if (tmpSize >= CDStorage.MAX_SIZE) {
			Logger.log(Error.FULL_STORAGE.toString());
			System.out.println(Error.FULL_STORAGE.toString());
			return;
		}
		
		// check duplicate
		for (int i = 0; i < tmpSize; i++) {
			if (cdToAdd.compareTo(tmpStorage[i]) == 0) {
				Logger.log(Error.DUPLICATE_CD.toString());
				System.out.println(Error.DUPLICATE_CD.toString());
				return;
			}
		}

		tmpStorage[tmpSize++] = cdToAdd;
		storage.setSize(tmpSize);
		Arrays.sort(tmpStorage, 0, tmpSize);

		// check storage again
		if (storage.check() != true) {
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			throw new RuntimeException(Error.CORRUPTED_STORAGE.toString());
		}

		Logger.log("CD added");
		System.out.println("CD added");
	}
}
