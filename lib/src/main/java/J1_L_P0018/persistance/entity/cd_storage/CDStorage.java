package J1_L_P0018.persistance.entity.cd_storage;

import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.entity.cd.CD;

public class CDStorage {
	// max storage size
	public static final int MAX_SIZE = 1000;

	// CD storage
	private final CD[] storage;

	// size of the CD storage
	private int size;

	// empty constructor
	public CDStorage() {
		this.storage = new CD[MAX_SIZE];
		this.size = 0;
	}

	// constructor that defines storage
	public CDStorage(CD[] storage, int size) {
		// null storage
		if (storage == null) {
			Logger.log(Error.NULL_STORAGE.toString());
			throw new RuntimeException(Error.NULL_STORAGE.toString());
		}

		// invalid storage size
		if (storage.length != MAX_SIZE || size < 0 || MAX_SIZE < size) {
			Logger.log(Error.INVALID_STORAGE_SIZE.toString());
			throw new RuntimeException(Error.INVALID_STORAGE_SIZE.toString());
		}

		this.storage = storage;
		this.size = size;

		// storage's integrity does not hold
		if (this.check() != true) {
			Logger.log(Error.CORRUPTED_STORAGE.toString());
			throw new RuntimeException(Error.CORRUPTED_STORAGE.toString());
		}
	}

	// gets, sets size
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// gets CD storage
	public CD[] getStorage() {
		return storage;
	}

	// checks CD storage
	public final boolean check() {
		return CDStorageCheck.check(this);
	}
}
