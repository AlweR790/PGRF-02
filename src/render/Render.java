package render;


import model.Point;
import view.Raster;

import java.util.List;

public class Render
	{
		private Raster raster;

		public Render(Raster raster)
			{
				this.raster = raster;
			}

		public void drawPolygon(List<Point> points, boolean antiAliasing, float saturation, int color)
			{
				for (int i = 0; i < points.size() - 1; i++)
					{
						Point p1 = new Point(points.get(i).x, points.get(i).y);
						Point p2 = new Point(points.get(i + 1).x, points.get(i + 1).y);
						drawDDALine(p1, p2, color);
					}
			}

		private void drawDDALine(Point first, Point second, int color)
			{
				int x1 = first.x;
				int x2 = second.x;
				int y1 = first.y;
				int y2 = second.y;
				int dx = x2 - x1;
				int dy = y2 - y1;
				float k, g, h;

				k = dy / (float) dx;
				if (Math.abs(k) < 1)
					{
						g = 1;
						h = k;
						if (x1 > x2)
							{
								x1 = x2;
								y1 = y2;
							}
					} else
					{
						g = 1 / k;
						h = 1;
						if (y1 > y2)
							{
								x1 = x2;
								y1 = y2;
							}
					}

				float x = x1;
				float y = y1;

				for (int i = 0; i <= Math.max(Math.abs(dx), Math.abs(dy)); i++)
					{
						raster.drawPixel(Math.round(x), Math.round(y), color);
						x += g;
						y += h;
					}
			}

	}
