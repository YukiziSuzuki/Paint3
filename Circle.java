package enshu2_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Figure {
	Circle(){}
	@Override public void paint(Graphics g) {
		Color color= new Color(red,green,blue);
		g.setColor(color);
		int r=(int)Math.sqrt((double)(w*w+h*h));
		if(fill) {
			g.fillOval(x-r, y-r, r*2, r*2);
		}else {
			g.drawOval(x-r, y-r, r*2, r*2);
		}
	}

}
