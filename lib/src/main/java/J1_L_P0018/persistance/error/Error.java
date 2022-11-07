package J1_L_P0018.persistance.error;


// enum that holds types of error encountered while using 
// the application
public enum Error
{
	// error messages
	NULL_CD("Null CD"),
	NULL_STORAGE("Null storage"),
	NULL_ID("Null ID"),
	EMPTY_STORAGE("Empty storage"),
	INVALID_STORAGE_SIZE("Invalid storage size"),
	CANNOT_ALLOCATE_STORAGE("Cannot allocate storage"),
	COMPARING_NULL_CD("Comparing null CD"),
	CORRUPTED_STORAGE("Corrupted storage");
	
	
	// error string
	private String error;
	
	
	// constructor
	private Error(String error)
	{
		this.error = error;
	}
	
	
	// turns error into its string message
	@Override
	public final String toString()
	{
		return this.error;
	}
}
