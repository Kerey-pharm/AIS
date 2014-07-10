package kz.kerey.ui.tools;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class WindowTool {

	private static Toolkit toolkit = Toolkit.getDefaultToolkit();

	public static void setWindowDimensions(Window frame, Integer width,
			Integer height) {
		frame.setSize(width, height);
	}

	public static void setWindowAtCenter(Window frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		frame.setLocation(x, y);
	}

}