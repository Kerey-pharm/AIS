package kz.kerey.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import kz.kerey.loaders.GoodLoader;

public class Importer {

	public static void main(String[] args) throws FileNotFoundException {
		
		GoodLoader loader = GoodLoader.getLoader();
		
		FileInputStream input = new FileInputStream(new File("bugs.txt"));
		
		
		
		
	}

}
