package view;

import javax.swing.*;

		public class AppWindow extends JFrame
			{
				public AppWindow()
					{
						setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						setSize(Raster.WIDTH, Raster.HEIGHT);
						setLocationRelativeTo(null);
						setTitle("PGRF1 - 02");
					}
			}
