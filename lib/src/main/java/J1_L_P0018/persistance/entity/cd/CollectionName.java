package J1_L_P0018.persistance.entity.cd;


// enum for collection name
public enum CollectionName
{
	// collection names
	GAME("game"),
	MOVIE("movie"),
	MUSIC("music"),
	UNKNOWN("unknown");
	
	
	// field for collection name as string
	private String collectionName;
	
	
	// constructor
	private CollectionName(String collectionName)
	{
		this.collectionName = collectionName;
	}
	
	
	// turns collection name into string
	@Override
	public final String toString()
	{
		return this.collectionName;
	}
}
