package J1_L_P0018.persistance.database;

import java.io.File;
import java.io.PrintWriter;
import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

// class to save data to database
public class SaveDatabase {
	// data file location
	private static final String FILE_PATH = DatabaseInformation.DATABASE_NAME;

	// delimiter format
	private static final String DELIM = ";";

	// saves data to database
	public static final void save(CDStorage storage) {
		Logger.log("Saving database...");
		
		// null storage
		if (storage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}

		// check storage's integrity
		if (storage.check() != true) {
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			throw new RuntimeException(Error.CORRUPTED_STORAGE.toString());
		}

		// save to database
		try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
			CD[] tmpStorage = storage.getStorage();
			int tmpSize = storage.getSize();
			
			for (int i = 0; i < tmpSize; i++) {
				StringBuilder builder = new StringBuilder();
				
				builder.append(tmpStorage[i].getId());
				builder.append(DELIM);
				builder.append(tmpStorage[i].getCollectionName());
				builder.append(DELIM);
				builder.append(tmpStorage[i].getType());
				builder.append(DELIM);
				builder.append(tmpStorage[i].getTitle());
				builder.append(DELIM);
				builder.append(String.format("%.2f", tmpStorage[i].getPrice()));
				builder.append(DELIM);
				builder.append(tmpStorage[i].getYear());
				
				writer.println(builder.toString());
			}
			
			Logger.log("Database is saved");
			System.out.println("Database is saved");
		} catch (Exception e) {
			Logger.log(Error.CANNOT_SAVE_DATABASE.toString());
			throw new RuntimeException(Error.CANNOT_SAVE_DATABASE.toString());
		}
	}
}
