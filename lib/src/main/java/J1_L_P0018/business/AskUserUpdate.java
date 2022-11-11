package J1_L_P0018.business;

import java.time.LocalDate;

import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd.CDCollectionName;
import J1_L_P0018.persistance.entity.cd.CDType;

public class AskUserUpdate {
	public static final void ask(CD cd) {
		Logger.log("Updating CD...");
		
		CD tmp = cd.clone();
		
		// get ID
		String ID = AskUserID.ask();

		if (ID != null) {
			tmp.setId(ID);
		}

		// get collection name
		CDCollectionName collectionName = AskUserCollectionName.ask();

		if (collectionName != null) {
			tmp.setCollectionName(collectionName);
		}

		// get type
		CDType type = AskUserType.ask();

		if (type != null) {
			tmp.setType(type);
		}

		// get title
		String title = AskUserTitle.ask();

		if (title != null) {
			tmp.setTitle(title);
		}

		// get price
		float price = AskUserPrice.ask();

		if (price != -1.0f) {
			tmp.setPrice(price);
		}

		// get year
		int year = AskUserYear.ask();

		if (year != LocalDate.MIN.getYear()) {
			tmp.setYear(year);
		}

		if (tmp.check() != true) {
			Logger.log("Invalid CD");
			Logger.log("Cancelled");
			return;
		}
		
		cd.setId(tmp.getId());
		cd.setCollectionName(tmp.getCollectionName());
		cd.setType(tmp.getType());
		cd.setTitle(tmp.getTitle());
		cd.setPrice(tmp.getPrice());
		cd.setYear(tmp.getYear());
		
		Logger.log("CD updated");
		System.out.println("CD updated");
	}
}
