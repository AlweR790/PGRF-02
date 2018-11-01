package render;


import view.Raster;

import java.util.List;

public class Render
	{
		private Raster raster;

		public Render (Raster raster)
			{
				this.raster = raster;
			}
		public void drawPolygon(List<Point> points, boolean antiAliasing, float saturation, int color)
			{
				for (int i = 0; i < points.size() - 1; i++)
					{
						Point p1 = new Point(points.get(i).getX(), points.get(i).getY());
						Point p2 = new Point(points.get(i + 1).getX(), points.get(i + 1).getY());

						if(antiAliasing)
							drawXiaolinWuLine(p1, p2, saturation);
						else
							drawDDALine(p1, p2, color);
					}
			}

	}
