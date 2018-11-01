package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Raster extends JPanel
	{
		private BufferedImage img;
		public static final int HEIGHT = 1900;
		public static final int WIDTH = 1000;
		private static final int FPS = 1000/144;

		public Raster()
			{
				img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
				setTimer();
			}

		private void setTimer()
			{
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						repaint();
					}
				}, 0, FPS);
			}

		public void clear()
			{
				Graphics g = img.getGraphics();
				g.setColor(Color.BLACK);
				g.fillRect(0,0, WIDTH,HEIGHT);
			}
		public void drawPixel(int x, int y, int color)
			{
				img.setRGB(x,y,color);
			}
		public int getPixelColor(int x, int y)
			{
				return img.getRGB(x,y);
			}
	}
