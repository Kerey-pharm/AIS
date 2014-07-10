package kz.kerey.loaders;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public class LoggerManager {

	private static Handler handler = null;

	public static Handler getFileHandler() {
		if (handler == null) {
			Date today = new Date();
			String year = String.valueOf(today.getYear());
			String month = String.valueOf(today.getMonth());
			String day = String.valueOf(today.getDate());
			String fileName = year + "-" + month + "-" + day + ".log";
			try {
				handler = new FileHandler(fileName);
			} catch (SecurityException | IOException e) {
				e.printStackTrace();
			}
		}
		return handler;
	}

}