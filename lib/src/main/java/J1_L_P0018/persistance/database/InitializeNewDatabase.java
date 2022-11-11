package J1_L_P0018.persistance.database;

import java.io.File;
import java.io.PrintWriter;

import J1_L_P0018.log.Logger;

// class to initialize newly created database CD.dat
class InitializeNewDatabase {
	// initiates the database (i.e. add dummy data)
	public static final void initiate(String filePath) {
		try (PrintWriter writer = new PrintWriter(new File(filePath))) {
			Logger.log("Initializing database...");

			StringBuilder builder = new StringBuilder();

			// first CD
			builder.append("CD-0001");
			builder.append(";");
			builder.append("music");
			builder.append(";");
			builder.append("audio");
			builder.append(";");
			builder.append("Schubert - Serenade");
			builder.append(";");
			builder.append(10.99);
			builder.append(";");
			builder.append(1826);
			builder.append("\n");

			// second CD
			builder.append("CD-0002");
			builder.append(";");
			builder.append("music");
			builder.append(";");
			builder.append("audio");
			builder.append(";");
			builder.append("Hans Zimmer, Lisa Gerrard - Now We Are Free");
			builder.append(";");
			builder.append(9.99);
			builder.append(";");
			builder.append(1998);
			builder.append("\n");

			// third CD
			builder.append("CD-0003");
			builder.append(";");
			builder.append("music");
			builder.append(";");
			builder.append("audio");
			builder.append(";");
			builder.append("Toshifumi Hinata - Reflections");
			builder.append(";");
			builder.append(7.99);
			builder.append(";");
			builder.append(1986);
			builder.append("\n");

			// fourth CD
			builder.append("CD-0004");
			builder.append(";");
			builder.append("music");
			builder.append(";");
			builder.append("audio");
			builder.append(";");
			builder.append("Justin Hurwitz - Mia & Sebastian's Theme");
			builder.append(";");
			builder.append(5.99);
			builder.append(";");
			builder.append(2016);
			builder.append("\n");

			// fifth CD
			builder.append("CD-0005");
			builder.append(";");
			builder.append("music");
			builder.append(";");
			builder.append("video");
			builder.append(";");
			builder.append("Yung Lean - Agony");
			builder.append(";");
			builder.append(3.99);
			builder.append(";");
			builder.append(2017);
			builder.append("\n");

			writer.print(builder.toString());
			Logger.log("Initialized");
		} catch (Exception e) {
			Logger.log("Cannot initiate database");
		}
	}
}
