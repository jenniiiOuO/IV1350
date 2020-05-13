package integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
	
	/*
	 * Creates a new instance.
	 */
	public Logger() {
		
	}
	
	/*
	 * Prints the specified message to the log file.
	 * @param exc - the exception that will be printed to the log file.
	 */
	public void log(Exception exc) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("--------LOG--------");
		builder.append("\n");
		builder.append("Exception thrown\n");
		builder.append(exc.toString());
		builder.append("\n");
		builder.append("--------END--------");
		
		System.out.println(builder);
		
	}
}
