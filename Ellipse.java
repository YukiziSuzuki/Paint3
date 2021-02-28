package enshu2_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Figure {
	Ellipse(){}
	
	@Override public void paint(Graphics g) {
		Color color= new Color(red,green,blue);
		g.setColor(color);
		//g.drawOval((int)(x-Math.sqrt((double)(2))*w),(int)(y-Math.sqrt((double)(2))*h),(int)(Math.sqrt((double)(2))*2*w),(int)(Math.sqrt((double)(2))*2*h));
		
		if(fill) {
			if(w>0 && h>0) {
				g.fillOval((int)(x-Math.sqrt((double)(2))*w),(int)(y-Math.sqrt((double)(2))*h),(int)(Math.sqrt((double)(2))*2*w),(int)(Math.sqrt((double)(2))*2*h));
			}else if(w<0 && h>0) {
				g.fillOval((int)(x-Math.sqrt((double)(2))*w)+(int)(Math.sqrt((double)(2))*2*w),(int)(y-Math.sqrt((double)(2))*h),-(int)(Math.sqrt((double)(2))*2*w),(int)(Math.sqrt((double)(2))*2*h));
			}else if(w>0 && h<0) {
				g.fillOval((int)(x-Math.sqrt((double)(2))*w),(int)(y-Math.sqrt((double)(2))*h)+(int)(Math.sqrt((double)(2))*2*h),(int)(Math.sqrt((double)(2))*2*w),-(int)(Math.sqrt((double)(2))*2*h));
			}else if(w<0 && h<0) {
				g.fillOval((int)(x-Math.sqrt((double)(2))*w)+(int)(Math.sqrt((double)(2))*2*w),(int)(y-Math.sqrt((double)(2))*h)+(int)(Math.sqrt((double)(2))*2*h),-(int)(Math.sqrt((double)(2))*2*w),-(int)(Math.sqrt((double)(2))*2*h));
			}
		} else{
			if(w>0 && h>0) {
				g.drawOval((int)(x-Math.sqrt((double)(2))*w),(int)(y-Math.sqrt((double)(2))*h),(int)(Math.sqrt((double)(2))*2*w),(int)(Math.sqrt((double)(2))*2*h));
			}else if(w<0 && h>0) {
				g.drawOval((int)(x-Math.sqrt((double)(2))*w)+(int)(Math.sqrt((double)(2))*2*w),(int)(y-Math.sqrt((double)(2))*h),-(int)(Math.sqrt((double)(2))*2*w),(int)(Math.sqrt((double)(2))*2*h));
			}else if(w>0 && h<0) {
				g.drawOval((int)(x-Math.sqrt((double)(2))*w),(int)(y-Math.sqrt((double)(2))*h)+(int)(Math.sqrt((double)(2))*2*h),(int)(Math.sqrt((double)(2))*2*w),-(int)(Math.sqrt((double)(2))*2*h));
			}else if(w<0 && h<0) {
				g.drawOval((int)(x-Math.sqrt((double)(2))*w)+(int)(Math.sqrt((double)(2))*2*w),(int)(y-Math.sqrt((double)(2))*h)+(int)(Math.sqrt((double)(2))*2*h),-(int)(Math.sqrt((double)(2))*2*w),-(int)(Math.sqrt((double)(2))*2*h));
			}
		}
	}

}
