package J1_L_P0018.persistance.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.FileAlreadyExistsException;
import java.util.StringTokenizer;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd.CDBuilder;
import J1_L_P0018.persistance.entity.cd.CDType;
import J1_L_P0018.persistance.entity.cd.CDCollectionName;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;
import J1_L_P0018.tools.ConvertUserInput;

// class to read database file CD.dat
public class ReadDatabase {
	// data file location
	private static final String FILE_PATH = DatabaseInformation.DATABASE_NAME;

	// delimiter format
	private static final String DELIM = ";";

	// max size of the storage
	private static final int MAX_SIZE = CDStorage.MAX_SIZE;

	// reads the database file
	public static final CDStorage read() {
		Logger.log("Reading database...");

		try {
			File file = new File(FILE_PATH);

			if (file.exists() != true) {
				Logger.log("Database is not found. Creating one...");

				if (file.createNewFile() != true) {
					Logger.log(Error.CANNOT_CREATE_DATABASE.toString());
					throw new FileAlreadyExistsException(FILE_PATH);
				} else {
					InitializeNewDatabase.initiate(FILE_PATH);
					Logger.log("Database created");
				}
			}

			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				CD[] storage = new CD[MAX_SIZE];
				int size = 0;

				CDBuilder cdBuilder = new CDBuilder();
				String line;

				while ((line = reader.readLine()) != null) {
					if (size >= MAX_SIZE) {
						Logger.log(Error.FULL_STORAGE.toString());
						break;
					}

					StringTokenizer tokenizer = new StringTokenizer(line, DELIM);

					String id = tokenizer.nextToken().trim().toUpperCase();
					CDCollectionName cDCollectionName = CDCollectionName.stringToCollectionName(tokenizer.nextToken().trim());
					CDType type = CDType.stringToType(tokenizer.nextToken().trim());
					String title = tokenizer.nextToken().trim();
					float price = ConvertUserInput.toFloat(tokenizer.nextToken().trim());
					Integer year = ConvertUserInput.toInt(tokenizer.nextToken().trim());

					CD cd = cdBuilder.setID(id).setCollectionName(cDCollectionName).setType(type).setTitle(title)
							.setPrice(price).setYear(year).build();

					if (cd.check() != true) {
						throw new RuntimeException();
					}

					storage[size++] = cd;
				}

				Logger.log("Database is read");
				CDStorage tmp = new CDStorage(storage, size);

				if (tmp.check() != true) {
					throw new RuntimeException();
				}

				return tmp;
			}
		} catch (Exception e) {
			Logger.log(Error.CORRUPTED_DATABASE.toString());
			throw new RuntimeException(Error.CORRUPTED_DATABASE.toString());
		}
	}
}
