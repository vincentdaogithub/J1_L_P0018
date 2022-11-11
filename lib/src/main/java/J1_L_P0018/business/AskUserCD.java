package J1_L_P0018.business;

import java.time.LocalDate;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd.CDBuilder;
import J1_L_P0018.persistance.entity.cd.CDCollectionName;
import J1_L_P0018.persistance.entity.cd.CDType;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

public class AskUserCD {
	// ask user for input (Get CD's information to add)
	public static final CD ask(CDStorage storage) {
		Logger.log("Asking user to add CD...");

		// null storage
		if (storage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		// check storage
		if (storage.check() != true) {
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			throw new RuntimeException(Error.CORRUPTED_STORAGE.toString());
		}

		int tmpSize = storage.getSize();

		// check if the storage is full
		if (tmpSize > CDStorage.MAX_SIZE) {
			Logger.log(Error.FULL_STORAGE.toString());
			System.out.println(Error.FULL_STORAGE.toString());
			return null;
		}

		// get ID
		String ID = AskUserID.ask();

		if (ID == null) {
			Logger.log("Cancelled");
			return null;
		}

		// get collection name
		CDCollectionName collectionName = AskUserCollectionName.ask();

		if (collectionName == null) {
			Logger.log("Cancelled");
			return null;
		}

		// get type
		CDType type = AskUserType.ask();

		if (type == null) {
			Logger.log("Cancelled");
			return null;
		}

		// get title
		String title = AskUserTitle.ask();

		if (title == null) {
			Logger.log("Cancelled");
			return null;
		}

		// get price
		float price = AskUserPrice.ask();

		if (price == -1.0f) {
			Logger.log("Cancelled");
			return null;
		}

		// get year
		int year = AskUserYear.ask();

		if (year == LocalDate.MIN.getYear()) {
			Logger.log("Cancelled");
			return null;
		}

		CDBuilder builder = new CDBuilder();
		CD cd = builder.setID(ID).setCollectionName(collectionName).setType(type).setTitle(title).setPrice(price)
				.setYear(year).build();

		if (cd.check() != true) {
			Logger.log("Invalid CD");
			Logger.log("Cancelled");
			return null;
		}

		return cd;
	}
}
