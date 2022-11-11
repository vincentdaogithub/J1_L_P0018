package J1_L_P0018.persistance.entity.cd;

import J1_L_P0018.errors.Error;

// enum for collection name
public enum CDCollectionName {
	// collection names
	GAME("game"), MOVIE("movie"), MUSIC("music"), UNKNOWN("unknown");

	// field for collection name as string
	private String collectionName;

	// constructor
	private CDCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	// turns collection name into string
	@Override
	public final String toString() {
		return this.collectionName;
	}

	// returns collection name based on string value
	public static final CDCollectionName stringToCollectionName(String collectionName) {
		// null string type
		if (collectionName == null) {
			throw new NullPointerException(Error.NULL_ARGUMENT.toString());
		}

		// search
		for (CDCollectionName item : CDCollectionName.values()) {
			if (collectionName.equals(item.toString())) {
				return item;
			}
		}

		// unable to find
		throw new RuntimeException(Error.CANNOT_GET_ENUM.toString());
	}
}
