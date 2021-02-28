package enshu2_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class Multiplelines extends Figure {
	int xPoints[] = new int[10];
	int yPoints[] = new int[10];
	

	Multiplelines(){}
	@Override public void paint(Graphics g) {
		Color color= new Color(red,green,blue);
		g.setColor(color);
		
			xPoints[count] = x;
			yPoints[count] = y;
		
		g.drawPolyline(xPoints, yPoints, count+1);
	}
}
