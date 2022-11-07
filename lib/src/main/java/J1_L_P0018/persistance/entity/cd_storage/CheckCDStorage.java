package J1_L_P0018.persistance.entity.cd_storage;

import J1_L_P0018.persistance.error.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;


class CheckCDStorage
{
	// class name
	private static final String CLASS_NAME = CheckCDStorage.class.getName();
	
	
	// checks the integrity of the storage
	public static final boolean CheckIntegrity(CD[] storage, int size)
	{
		Logger.log("Checking CD storage's integrity...");
		
		// null storage
		if (storage == null)
		{
			Logger.log(CLASS_NAME, Error.NULL_STORAGE.toString());
			throw new NullPointerException(Error.NULL_STORAGE.toString());
		}
		
		// invalid storage size
		if (size < 0 || CDStorage.MAX_SIZE < size)
		{
			Logger.log(Error.INVALID_STORAGE_SIZE.toString());
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			
			return false;
		}
		
		// checks if there's null value in array while walking through 
		// the array and the max index (MAX_SIZE - 1) hasn't been reached
		for (int i = 0; i < size; i++)
		{
			if (storage[i] == null)
			{
				Logger.log(Error.INVALID_STORAGE_SIZE.toString());
				Logger.log(Error.CORRUPTED_STORAGE.toString());
				
				return false;
			}
		}
		
		Logger.log("CD storage is fine");
		return true;
	}
}
