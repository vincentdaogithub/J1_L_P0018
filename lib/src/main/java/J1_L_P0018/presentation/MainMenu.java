package J1_L_P0018.presentation;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
	// main menu list
	private final List<String> mainMenuList = new ArrayList<>();

	// constructor
	public MainMenu() {
		mainMenuList.add("1. Add CD to the catalog.");
		mainMenuList.add("2. Search CD by CD title.");
		mainMenuList.add("3. Display the catalog.");
		mainMenuList.add("4. Update CD.");
		mainMenuList.add("5. Save account to file.");
		mainMenuList.add("6. Print list CDs from file.");
		mainMenuList.add("Others. Quit.");
	}

	// prints the menu
	public final void print() {
		for (String string : mainMenuList) {
			System.out.println(string);
		}

		System.out.println();
	}
}
