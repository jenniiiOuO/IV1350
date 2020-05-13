package integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LogHandler {
	private PrintWriter logStream;
	
	/*
	 * Creates a new instance and a new file to log.
	 */
	public LogHandler() throws IOException {
		try{
			logStream = new PrintWriter(new FileWriter("log.txt"), true);
		}catch(IOException ioe){
			System.out.println("LOG FALIED");
			ioe.printStackTrace();
		}
	}
	
	/*
	 * Prints the specified message to the log file.
	 * @param exc - the exception that will be printed to the log file.
	 */
	public void logException(String msg) {
		/*LocalDateTime now = LocalDateTime.now();
		
		StringBuilder builder = new StringBuilder();
		builder.append("--------LOG--------");
		builder.append(now.toLocalDate().toString());
		builder.append(exc.getMessage());
		builder.append("-------------------");
		logStream.println(builder);*/
		
		logStream.println(msg);
		
	}
}
