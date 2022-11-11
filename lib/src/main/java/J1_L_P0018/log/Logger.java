package J1_L_P0018.log;

// logger class
public class Logger {
	// constant log file path
	private static final String LOG_FILE_PATH = "log.log";

	// initiates log file
	public static final void initiate() {
		LoggerInitiation.initiate(LOG_FILE_PATH);
	}

	// terminates the log file
	public static final void terminate() {
		LoggerTermination.terminate(LOG_FILE_PATH);
	}

	// logs into the log file (message only)
	public static void log(String message) {
		LoggerLog.log(LOG_FILE_PATH, message);
	}

	// logs into the file with the message's location
	public static void log(String location, String message) {
		LoggerLog.log(LOG_FILE_PATH, location, message);
	}
}
