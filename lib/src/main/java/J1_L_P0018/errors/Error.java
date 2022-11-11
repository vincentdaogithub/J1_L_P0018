package J1_L_P0018.errors;

// enum that holds types of error encountered while using 
// the application
public enum Error {
	// error messages
	NULL_CD("Null CD"), NULL_STORAGE("Null storage"), NULL_ID("Null ID"), EMPTY_STORAGE("Empty storage"),
	INVALID_STORAGE_SIZE("Invalid storage size"), CANNOT_ALLOCATE_STORAGE("Cannot allocate storage"),
	COMPARING_NULL_CD("Comparing null CD"), CORRUPTED_STORAGE("Corrupted storage"), FULL_STORAGE("Storage is full"),
	CANNOT_CREATE_DATABASE("Cannot create database"), CANNOT_CHECK_FORMAT("Cannot check format"),
	CORRUPTED_DATABASE("Corrupted database"), CANNOT_GET_ENUM("Cannot get enum value"), NULL_ARGUMENT("Null argument"),
	CANNOT_SAVE_DATABASE("Cannot save database"), DUPLICATE_CD("Duplicate CD"), CANNOT_DELEGATE("Cannot delegate"),
	NULL_DELEGATE("Null delegate type"), CANNOT_READ_USER_INPUT("Cannot read user input"),
	CANNOT_CONVERT_TO_INT("Cannot convert to int"), CANNOT_CONVERT_TO_FLOAT("Cannot convert to float"),
	INVALID_CD_ID("Invalid CD's ID"), INVALID_CD_COLLECTION_NAME("Invalid CD's collection name"),
	INVALID_CD_TYPE("Invalid CD's type"), INVALID_CD_TITLE("Invalid CD's title"),
	INVALID_CD_PRICE("Invalid CD's price"), INVALID_CD_YEAR("Invalid CD's year"),
	CANNOT_CREATE_OPERATIONS_DELEGATE("Cannot create operations delegate"), CANNOT_FIND_CD("Cannot find CD");

	// error string
	private String error;

	// constructor
	private Error(String error) {
		this.error = error;
	}

	// turns error into its string message
	@Override
	public final String toString() {
		return this.error;
	}
}
