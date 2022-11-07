package J1_L_P0018.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


// class to end the logging session
public class LoggerTermination
{
	// terminates the log
	public static final void terminate(String logFilePath)
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true)))
		{
			StringBuilder builder = new StringBuilder();
			
			builder.append(LoggerMessageBuilder.build("Closing program..."));
			builder.append("----------------------------------------------------------------------------------------------------");
			builder.append("\n");
			
			writer.write(builder.toString());
		}
		catch (IOException exception)
		{
			System.err.println("Cannot close the Logger");
			System.exit(1);
		}
	}
}
