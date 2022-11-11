package J1_L_P0018.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class LoggerInitiation {
	// initiates the log file
	public static final void initiate(String logFilePath) {
		try {
			StringBuilder builder = new StringBuilder();

			builder.append(
					"----------------------------------------------------------------------------------------------------");
			builder.append("\n");
			builder.append(LoggerMessageBuilder.build("Generating new session..."));
			builder.append(LoggerMessageBuilder.build("New session has been generated"));

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath))) {
				writer.write(builder.toString());
			}
		} catch (IOException exception) {
			System.err.println("Cannot create log file");
			System.exit(1);
		} catch (SecurityException exception) {
			System.err.println("Cannot access log file");
			System.exit(1);
		}
	}
}
