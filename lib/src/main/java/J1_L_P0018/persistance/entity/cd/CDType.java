package J1_L_P0018.persistance.entity.cd;

import J1_L_P0018.errors.Error;

// enum for CD types
public enum CDType {
	// types
	AUDIO("audio"), VIDEO("video"), UNKNOWN("unknown");

	// field for type as string
	private String type;

	// constructor
	private CDType(String type) {
		this.type = type;
	}

	// turns type into string
	@Override
	public final String toString() {
		return this.type;
	}

	// returns type based on string value
	public static final CDType stringToType(String type) {
		// null string type
		if (type == null) {
			throw new NullPointerException(Error.NULL_ARGUMENT.toString());
		}

		// search
		for (CDType item : CDType.values()) {
			if (type.equals(item.toString())) {
				return item;
			}
		}

		// unable to find
		throw new RuntimeException(Error.CANNOT_GET_ENUM.toString());
	}
}
