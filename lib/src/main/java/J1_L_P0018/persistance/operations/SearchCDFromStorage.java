package J1_L_P0018.persistance.operations;

import java.util.ArrayList;
import java.util.List;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;
import J1_L_P0018.tools.CheckFormat;

class SearchCDFromStorage {
	// search CD from storage and return its index
	public static final int searchByID(CDStorage storage, String id) {
		Logger.log("Searching CD...");

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
			throw new RuntimeException(Error.CORRUPTED_STORAGE.toString());
		}

		// search for the CD
		for (int i = 0; i < tmpSize; i++) {
			if (tmpStorage[i].getId().equals(id)) {
				Logger.log("CD founded");
				return i;
			}
		}

		// cannot find CD
		return -1;
	}

	// search by title
	public static final Integer[] searchByTitles(CDStorage storage, String title) {
		Logger.log("Searching CD...");

		if (storage == null || title == null) {
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

		// get CD's index array
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < tmpSize; i++) {
			if (CheckFormat.findFormat(tmpStorage[i].getTitle(), title) == true) {
				result.add(i);
			}
		}

		return result.isEmpty() ? null : result.toArray(new Integer[0]);
	}
}
