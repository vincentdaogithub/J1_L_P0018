package J1_L_P0018.persistance.entity.cd_storage;

import J1_L_P0018.persistance.error.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;


public class CDStorage
{
	// max storage size
	public static final int MAX_SIZE = 1000;
	
	
	// CD storage
	private final CD[] storage;
	
	
	// size of the CD storage
	private int size;
	
	
	// empty constructor
	public CDStorage()
	{
		this.storage = new CD[MAX_SIZE];
		this.size = 0;
	}
	
	
	// constructor that defines storage
	public CDStorage(CD[] cdStorage, int size)
	{
		if (size < 0 || MAX_SIZE < size)
		{
			Logger.log(Error.INVALID_STORAGE_SIZE.toString());
			throw new RuntimeException(Error.INVALID_STORAGE_SIZE.toString());
		}
		
		this.storage = cdStorage;
		this.size = size;
	}
}
