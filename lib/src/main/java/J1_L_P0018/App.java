package J1_L_P0018;

import java.util.Collections;
import java.util.List;

import J1_L_P0018.business.AskUserCD;
import J1_L_P0018.business.AskUserID;
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
import J1_L_P0018.tools.ConvertUserInput;
import J1_L_P0018.tools.ReadUserInput;

public class App {
	public static void main(String[] args) {
		Logger.initiate();
		CDStorage storage = ReadDatabase.read();
		OperationsDelegate delegate = new OperationsDelegate();
		MainMenu menu = new MainMenu();

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
				case 1:
					CD tmp = AskUserCD.ask(storage);

					if (tmp == null) {
						System.out.println("Cancelled");
						System.out.println();
						break;
					}

					delegate.addCD(storage, tmp);
					System.out.println();
					break;

				case 2:
					String tmp4 = AskUserID.ask();

					if (tmp4 == null) {
						System.out.println("Cancelled");
						System.out.println();
						break;
					}

					System.out.println();

					int index = delegate.searchCD(storage, tmp4);

					if (index == -1) {
						Logger.log(Error.CANNOT_FIND_CD.toString());
						System.out.println(Error.CANNOT_FIND_CD.toString());
						System.out.println();
						break;
					}

					delegate.printCD(storage, index);
					System.out.println();
					break;

				case 3:
					System.out.println("Number of CD: " + storage.getSize());
					delegate.printAllCDs(storage);
					System.out.println();
					break;

				case 4:
					System.out.println("1. Update");
					System.out.println("2. Delete");
					System.out.print("Enter your option: ");

					Integer tmp1 = ConvertUserInput.toInt(ReadUserInput.readString());

					if (tmp1 == null) {
						Logger.log("Invalid option from user");
						System.out.println("Invalid input");
						break;
					}

					System.out.println();

					switch (tmp1) {
						case 1:
							String tmp2 = AskUserID.ask();

							if (tmp2 == null) {
								Logger.log("Cancelled");
								System.out.println("Cancelled");
								System.out.println();
								break;
							}

							int index1 = delegate.searchCD(storage, tmp2);

							if (index1 == -1) {
								Logger.log(Error.CANNOT_FIND_CD.toString());
								System.out.println(Error.CANNOT_FIND_CD.toString());
								break;
							}

							System.out.println("Update start...");
							AskUserUpdate.ask(storage.getStorage()[index1]);
							System.out.println();

							boolean ask = askToContinue();

							if (ask != true) {
								System.out.println("Exiting program...");
								Logger.log("Exiting program");
								System.exit(0);
							}

							break;

						case 2:
							String tmp3 = AskUserID.ask();

							if (tmp3 == null) {
								Logger.log("Cancelled");
								System.out.println("Cancelled");
								System.out.println();
								break;
							}

							delegate.deleteCD(storage, tmp3);
							System.out.println();

							boolean ask1 = askToContinue();

							if (ask1 != true) {
								System.out.println("Exiting program...");
								Logger.log("Exiting program");
								System.exit(0);
							}

							break;

						default:
							Logger.log("Invalid option from user");
							System.out.println("Invalid input");
							break;
					}

					break;

				case 5:
					SaveDatabase.save(storage);

					boolean ask2 = askToContinue();

					if (ask2 != true) {
						System.out.println("Exiting program...");
						Logger.log("Exiting program");
						System.exit(0);
					}

					break;

				case 6:
					List<CD> list = ConvertDatabaseToCollection.convert(ReadDatabase.read());

					Collections.sort(list, (CD cd1, CD cd2) -> {
						return cd1.getTitle().compareTo(cd2.getTitle());
					});

					for (CD item : list) {
						System.out.println(GetCDInformation.get(item));
					}

					System.out.println();

					boolean ask3 = askToContinue();

					if (ask3 != true) {
						System.out.println("Exiting program...");
						Logger.log("Exiting program");
						System.exit(0);
					}

					break;

				default:
					System.out.println("Exiting program...");
					Logger.log("Exiting program");
					System.exit(0);
					break;
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
				case 1:
					return true;

				case 2:
					return false;

				default:
					Logger.log("Invalid option from user");
					System.out.println("Invalid input");
					break;
			}
		}
	}
}
