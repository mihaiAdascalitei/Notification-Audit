import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerInUse {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private String filepath;
	private String htmlpath;
	private String ff;

	public void setLevel() {
		LOGGER.setLevel(Level.SEVERE);
	}

	public void severe() {
		LOGGER.severe("Info Log");
	}

	public void warning() {
		LOGGER.warning("Info log");
	}

	public void info() {
		LOGGER.info("Info log");
	}

	public void finest() {
		LOGGER.finest("Finest log");
	}

	public void setupLog() {

		setLevel();
		severe();
		warning();
		info();
		finest();

		// and again for writing to our files
		LOGGER.setLevel(Level.INFO);
		LOGGER.severe("Info Log");
		LOGGER.warning("Info Log");
		LOGGER.info("Info Log");
		LOGGER.finest("Really not important");
	}

	public static void main(String[] args) {
		LoggerInUse logs = new LoggerInUse();
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Type the path for the file you want to create : ");
			logs.filepath = scan.nextLine();
			System.out.println("Type the file format for the precedent file :");
			logs.ff = scan.nextLine();
			System.out.println("Type the path for the htmlfile you want to create :");
			logs.htmlpath = scan.nextLine();
			new CsLogger(logs.filepath + "." + logs.ff, logs.htmlpath + ".html");
			System.out.println("Succesfully created!");
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating the log files");
		}
		logs.setupLog();
	}
}