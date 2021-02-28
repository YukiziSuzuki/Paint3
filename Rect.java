package enshu2_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Figure{
	Rect(){}
	@Override public void paint(Graphics g) {
		Color color= new Color(red,green,blue);
		g.setColor(color);
		if(fill) {
			if(w>0 && h>0) {
				g.fillRect(x, y, w, h);
			}else if(w<0 && h>0) {
				g.fillRect(x+w, y, -w, h);
			}else if(w>0 && h<0) {
				g.fillRect(x, y+h, w, -h);
			}else if(w<0 && h<0) {
				g.fillRect(x+w, y+h, -w, -h);
			}
		}else {
			if(w>0 && h>0) {
				g.drawRect(x, y, w, h);
			}else if(w<0 && h>0) {
				g.drawRect(x+w, y, -w, h);
			}else if(w>0 && h<0) {
				g.drawRect(x, y+h, w, -h);
			}else if(w<0 && h<0) {
				g.drawRect(x+w, y+h, -w, -h);
			}
		}
	}

}
