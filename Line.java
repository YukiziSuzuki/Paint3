package enshu2_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Figure{
	Line(){}
	@Override public void paint(Graphics g) {
		Color color= new Color(red,green,blue);
		g.setColor(color);
		g.drawLine(x, y, x+w, y+h);
	}

}
