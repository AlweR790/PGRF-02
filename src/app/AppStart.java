package app;

import javax.swing.*;

import controller.Controller;
import view.AppWindow;

public class AppStart
	{
		public static void main(String[] args)
			{
				SwingUtilities.invokeLater(() ->
				{
					AppWindow window = new AppWindow();
					window.setVisible(true);
					new Controller(window);
				});
			}
	}
