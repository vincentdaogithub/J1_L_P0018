package J1_L_P0018.persistance.operations;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

class PrintCD {
	// print CD
	public static final void print(CDStorage storage, String id) {
		Logger.log("Printing CD...");

		if (storage == null || id == null) {
			Logger.log(Error.NULL_ARGUMENT.toString());
			throw new NullPointerException(Error.NULL_ARGUMENT.toString());
		}

		CD[] tmpStorage = storage.getStorage();

		// null storage
		if (tmpStorage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		// print the CD
		int index = SearchCDFromStorage.search(storage, id);

		if (index == -1) {
			Logger.log(Error.CANNOT_FIND_CD.toString());
			System.out.println(Error.CANNOT_FIND_CD.toString());
			return;
		}

		System.out.println(GetCDInformation.get(tmpStorage[index]));
		Logger.log("CD printed");
	}
	
	// print CD with specified index
	public static final void print(CDStorage storage, int index) {
		Logger.log("Printing CD...");
		
		if (storage == null || index == -1) {
			Logger.log(Error.NULL_ARGUMENT.toString());
			throw new NullPointerException(Error.NULL_ARGUMENT.toString());
		}
		
		CD[] tmpStorage = storage.getStorage();
		
		// null storage
		if (tmpStorage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}
		
		System.out.println(GetCDInformation.get(tmpStorage[index]));
		Logger.log("CD printed");
	}

	
}
