package J1_L_P0018.persistance.database;

import java.util.ArrayList;
import java.util.List;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

public class ConvertDatabaseToCollection {
	public static final List<CD> convert(CDStorage storage) {
		if (storage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		CD[] tmpStorage = storage.getStorage();
		int tmpSize = storage.getSize();

		// null storage
		if (tmpStorage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		List<CD> result = new ArrayList<>();

		for (int i = 0; i < tmpSize; i++) {
			result.add(tmpStorage[i]);
		}
		
		return result;
	}
}
