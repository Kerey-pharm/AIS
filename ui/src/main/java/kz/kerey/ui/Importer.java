package kz.kerey.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.UUID;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.loaders.GoodLoader;

public class Importer {

	private static FileInputStream input;
	private static GoodLoader loader;

	public static void main(String[] args) throws IOException {
		
		loader = GoodLoader.getLoader();
		
		input = new FileInputStream(new File("bugs.txt"));
		
		byte[] data = new byte[input.available()];
		input.read(data);
		String text = new String(data);
		String[] d1 = text.split("',\\s'|\\r\\n'",-1);
		
		for (int i=0; i<d1.length; i+=4) {
			String id = d1[i].substring(1, d1[i].length()-1);
			String name = d1[i+1].trim();
			String barcode = d1[i+2].trim();
			
			try {
				UUID.fromString(id);
				GoodWrapper good = new GoodWrapper();
				good.setName(name);
				good.setPrimaryBarcode(barcode);
				good.setCountPerBox(0L);
				good.setCountSellable(0L);
				good.setPartialSelling(false);
				loader.saveElement(good);
				System.out.println(i/4+1);
			}
			catch (Exception ex) {
				System.out.println(i/4+1 + " Same name");
			}
		}
				
	}

}
