package kz.kerey.loaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import kz.kerey.ui.tools.ErrorDialog;

public class PropertiesLoader {

	private static Logger logger = Logger.getLogger(PropertiesLoader.class.getName());
	
	private static Properties properties = new Properties();
	
	static {
		loadProperties();
	}
	
	public static String getProperty(String name) {
		return properties.getProperty(name);
	}
	
	private static void loadProperties() {
		try {
			File propertiesFile = new File("ejb.properties");
			FileInputStream input;
			input = new FileInputStream(propertiesFile);
			properties.load(input);
		} catch (FileNotFoundException e) {
			ErrorDialog.showDialog(null, "Файл параметров не найден!");
			System.exit(0);
		} catch (IOException e) {
			ErrorDialog.showDialog(null, "Ошибка чтения параметров из файла!");
			System.exit(0);
		}
	}
	
}