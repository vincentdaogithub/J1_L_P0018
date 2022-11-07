package J1_L_P0018.log;

import java.time.LocalDateTime;


// class to build message by adding time to it
class LoggerMessageBuilder
{
	// builds the message to log
	public static final String build(String message)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		builder.append(LocalDateTime.now().format(LoggerTimeFormat.FORMATTER));
		builder.append("] - ");
		builder.append(message);
		builder.append("\n");
		
		return builder.toString();
	}
}
