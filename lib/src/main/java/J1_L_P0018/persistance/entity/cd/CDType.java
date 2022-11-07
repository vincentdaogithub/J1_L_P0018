package J1_L_P0018.persistance.entity.cd;


// enum for CD types
public enum CDType
{
	// types
	AUDIO("audio"),
	VIDEO("video"),
	UNKNOWN("unknown");
	
	
	// field for type as string
	private String type;
	
	
	// constructor
	private CDType(String type)
	{
		this.type = type;
	}
	
	
	// turns type into string
	@Override
	public final String toString()
	{
		return this.type;
	}
}
