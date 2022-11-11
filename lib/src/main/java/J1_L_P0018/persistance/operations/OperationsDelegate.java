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

	// search function
	public final int searchCD(CDStorage storage, String id) {
		return SearchCDFromStorage.search(storage, id);
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
