package enshu2_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class Dot extends Figure{
	int size;
	Dot(){
		size=10;
	}
	@Override public void paint(Graphics g) {
		Color color= new Color(red,green,blue);
		g.setColor(color);
		if(fill) {
			g.fillOval(x-size/2, y-size/2, size, size);
		}else {
			g.drawOval(x-size/2, y-size/2, size, size);
		}
	}

}
