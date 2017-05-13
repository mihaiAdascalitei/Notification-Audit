import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CsLogger {
	private FileHandler fileTxt;
	private SimpleFormatter formatterTxt;

	private FileHandler fileHTML;
	private Formatter formatterHTML;

	public CsLogger(String filepath, String htmlpath) throws IOException {

		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		Logger rootLogger = Logger.getLogger("");
		Handler[] handlers = rootLogger.getHandlers();
		if (handlers[0] instanceof ConsoleHandler) {
			rootLogger.removeHandler(handlers[0]);
		}

		logger.setLevel(Level.INFO);
		fileTxt = new FileHandler(filepath);
		fileHTML = new FileHandler(htmlpath);

		formatterTxt = new SimpleFormatter();
		fileTxt.setFormatter(formatterTxt);
		logger.addHandler(fileTxt);

		formatterHTML = new FileHTMLFormat();
		fileHTML.setFormatter(formatterHTML);
		logger.addHandler(fileHTML);
	}
}