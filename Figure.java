package enshu2_10_1;

import java.awt.Graphics;

public class Figure extends Coord {
	int color;
	int w,h;
	int red,green,blue;
	boolean fill;
	int count=0;
	Figure(){
		color=0;
		w=h=0;
		red=green=blue=0;
	}
	public void paint(Graphics g) {}
	public void setWH( int w, int h) {
		this.w=w;
		this.h=h;
	}
	
	
	public void setRed() {
		red=255;
		green=0;
		blue=0;
	}
	public void setGreen() {
		red=0;
		green=255;
		blue=0;
	}
	public void setBlue() {
		red=0;
		green=0;
		blue=255;
	}
	
	public void setFill(int a) {
		if(a==1) {
			fill=true;
		}else if(a==0) {
			fill=false;
		}
	}
	
	public void setCount() {
		if(count<9) {
			count++;
		}else {
			System.out.println("MAX");
		}
	}

}
