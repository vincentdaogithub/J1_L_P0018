package J1_L_P0018.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class LoggerLog {
	// logs the state of program (message only)
	public static final void log(String logFilePath, String message) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
			writer.write(LoggerMessageBuilder.build(message));
		} catch (IOException exception) {
			System.err.println("Cannot write to log file");
		}
	}

	// logs the state of program with the message's location
	public static final void log(String logFilePath, String location, String message) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(location);
		builder.append(" - ");
		builder.append(message);

		log(logFilePath, builder.toString());
	}
}
