package J1_L_P0018.persistance.operations;

import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;

public class OperationsDelegate {
	// add function
	public final void addCD(CDStorage storage, CD cd) {
		AddCDToStorage.add(storage, cd);
	}

	// delete function
	public final void deleteCD(CDStorage storage, String id) {
		DeleteCDFromStorage.delete(storage, id);
	}

	// search CD by ID
	public final int searchCD(CDStorage storage, String id) {
		return SearchCDFromStorage.searchByID(storage, id);
	}

	// search CD by title
	public final Integer[] searchCDByTitle(CDStorage storage, String title) {
		return SearchCDFromStorage.searchByTitles(storage, title);
	}

	// print a CD
	public final void printCD(CDStorage storage, String id) {
		PrintCD.print(storage, id);
	}

	// print a CD
	public final void printCD(CDStorage storage, int index) {
		PrintCD.print(storage, index);
	}
	
	// print a CD
	public final void printAllCDs(CDStorage storage) {
		PrintAllCDs.print(storage);
	}
}
