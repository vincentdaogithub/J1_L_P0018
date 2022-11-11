package J1_L_P0018.persistance.entity.cd;

import java.time.LocalDate;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.tools.CheckFormat;

class CDCheck {
	// constant year format
	private static final int CURRENT_YEAR = LocalDate.now().getYear();

	// check integrity of CD
	public static final boolean check(CD cd) {
		// null CD
		if (cd == null) {
			Logger.log(Error.NULL_CD.toString());
			throw new NullPointerException(Error.NULL_CD.toString());
		}

		// check ID
		if (CheckFormat.check(cd.getId(), CD.ID_FORMAT) != true) {
			Logger.log(Error.INVALID_CD_ID.toString());
			return false;
		}

		// check collection name
		if (cd.getCollectionName() == null) {
			Logger.log(Error.INVALID_CD_COLLECTION_NAME.toString());
			return false;
		}

		// check type
		if (cd.getType() == null) {
			Logger.log(Error.INVALID_CD_TYPE.toString());
			return false;
		}

		// check title
		if (cd.getTitle() == null || cd.getTitle().isBlank()) {
			Logger.log(Error.INVALID_CD_TITLE.toString());
			return false;
		}

		// check price
		if (cd.getPrice() < 0.0f || Float.isNaN(cd.getPrice())) {
			Logger.log(Error.INVALID_CD_PRICE.toString());
			return false;
		}

		// check year
		if (cd.getYear() < 0 || CURRENT_YEAR < cd.getYear()) {
			Logger.log(Error.INVALID_CD_YEAR.toString());
			return false;
		}

		// all are checked
		return true;
	}
}
