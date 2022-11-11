package J1_L_P0018;

import java.util.Collections;
import java.util.List;

import J1_L_P0018.business.AskUserCD;
import J1_L_P0018.business.AskUserID;
import J1_L_P0018.business.AskUserTitle;
import J1_L_P0018.business.AskUserUpdate;
import J1_L_P0018.errors.Error;
import J1_L_P0018.log.Logger;
import J1_L_P0018.persistance.database.ConvertDatabaseToCollection;
import J1_L_P0018.persistance.database.ReadDatabase;
import J1_L_P0018.persistance.database.SaveDatabase;
import J1_L_P0018.persistance.entity.cd.CD;
import J1_L_P0018.persistance.entity.cd_storage.CDStorage;
import J1_L_P0018.persistance.operations.GetCDInformation;
import J1_L_P0018.persistance.operations.OperationsDelegate;
import J1_L_P0018.presentation.MainMenu;
import J1_L_P0018.tools.CheckFormat;
import J1_L_P0018.tools.ConvertUserInput;
import J1_L_P0018.tools.ReadUserInput;

public class App {
	public static void main(String[] args) {
		Logger.initiate();
		CDStorage storage = ReadDatabase.read();
		OperationsDelegate delegate = new OperationsDelegate();
		MainMenu menu = new MainMenu();

		System.out.println(CheckFormat.checkFormat("fuckyou abc", "[a]"));

		while (true) {
			menu.print();
			System.out.print("Enter your option: ");
			Integer option = ConvertUserInput.toInt(ReadUserInput.readString());

			if (option == null) {
				Logger.log("Invalid option from user");
				System.out.println("Invalid input");
				System.out.println();
				continue;
			}

			System.out.println();

			switch (option) {
				case 1 -> {
					Logger.log("Asking to add CD...");
					CD add = AskUserCD.ask(storage);

					if (add == null) {
						System.out.println("Cancelled");
						System.out.println();
						break;
					}

					delegate.addCD(storage, add);
					System.out.println();
				}

				case 2 -> {
					Logger.log("Asking to search CD by titles...");
					if (storage.getSize() <= 0) {
						Logger.log(Error.EMPTY_STORAGE.toString());
						System.out.println(Error.EMPTY_STORAGE.toString());
						System.out.println();
						break;
					}

					String title = AskUserTitle.ask();

					if (title == null) {
						System.out.println("Cancelled");
						System.out.println();
						break;
					}

					System.out.println();

					Integer[] titles = delegate.searchCDByTitle(storage, title);

					if (titles == null) {
						Logger.log(Error.CANNOT_FIND_CD.toString());
						System.out.println(Error.CANNOT_FIND_CD.toString());
						System.out.println();
						break;
					}

					CD[] tmpStorage = storage.getStorage();

					for (int index : titles) {
						System.out.println(GetCDInformation.get(tmpStorage[index]));
					}

					System.out.println();
				}

				case 3 -> {
					Logger.log("Asking to print CDs in program...");

					System.out.println("Number of CD: " + storage.getSize());
					delegate.printAllCDs(storage);
					System.out.println();
				}

				case 4 -> {
					System.out.println("1. Update");
					System.out.println("2. Delete");
					System.out.print("Enter your option: ");

					Integer updateOption = ConvertUserInput.toInt(ReadUserInput.readString());

					if (updateOption == null) {
						Logger.log("Invalid option from user");
						System.out.println("Invalid input");
						break;
					}

					System.out.println();

					switch (updateOption) {
						case 1 -> {
							Logger.log("Asking to update CD...");

							String id = AskUserID.ask();

							if (id == null) {
								Logger.log("Cancelled");
								System.out.println("Cancelled");
								System.out.println();
								break;
							}

							int index = delegate.searchCD(storage, id);

							if (index == -1) {
								Logger.log(Error.CANNOT_FIND_CD.toString());
								System.out.println(Error.CANNOT_FIND_CD.toString());
								break;
							}

							System.out.println("Update start...");
							AskUserUpdate.ask(storage.getStorage()[index]);
							System.out.println();

							boolean ask = askToContinue();

							if (ask != true) {
								System.out.println("Exiting program...");
								Logger.log("Exiting program");
								System.exit(0);
							}
						}

						case 2 -> {
							Logger.log("Asking to delete CD...");

							String id = AskUserID.ask();

							if (id == null) {
								Logger.log("Cancelled");
								System.out.println("Cancelled");
								System.out.println();
								break;
							}

							delegate.deleteCD(storage, id);
							System.out.println();

							boolean ask = askToContinue();

							if (ask != true) {
								System.out.println("Exiting program...");
								Logger.log("Exiting program");
								System.exit(0);
							}
						}

						default -> {
							Logger.log("Invalid option from user");
							System.out.println("Invalid input");
							break;
						}
					}
				}

				case 5 -> {
					Logger.log("Asking to save database...");

					SaveDatabase.save(storage);

					boolean ask = askToContinue();

					if (ask != true) {
						System.out.println("Exiting program...");
						Logger.log("Exiting program");
						System.exit(0);
					}
				}

				case 6 -> {
					Logger.log("Asking to print CDs from database...");

					List<CD> list = ConvertDatabaseToCollection.convert(ReadDatabase.read());

					Collections.sort(list, (CD cd1, CD cd2) -> {
						return cd1.getTitle().compareTo(cd2.getTitle());
					});

					for (CD item : list) {
						System.out.println(GetCDInformation.get(item));
					}

					System.out.println();

					boolean ask = askToContinue();

					if (ask != true) {
						System.out.println("Exiting program...");
						Logger.log("Exiting program");
						System.exit(0);
					}
				}

				default -> {
					Logger.log("Exiting program");
					System.out.println("Exiting program...");
					System.exit(0);
					break;
				}
			}
		}
	}

	private static final boolean askToContinue() {
		while (true) {
			System.out.println("1. Continue");
			System.out.println("2. Exit program");
			System.out.print("Do you want to continue? ");

			Integer option = ConvertUserInput.toInt(ReadUserInput.readString());

			if (option == null) {
				Logger.log("Invalid option from user");
				System.out.println("Invalid input");
				continue;
			}

			System.out.println();

			switch (option) {
				case 1 -> {
					return true;
				}

				case 2 -> {
					return false;
				}

				default -> {
					Logger.log("Invalid option from user");
					System.out.println("Invalid input");
					break;
				}
			}
		}
	}
}
