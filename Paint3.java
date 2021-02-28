package enshu2_10_1;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Paint3 extends Frame implements MouseListener,MouseMotionListener, ActionListener{
	int x, y;
	ArrayList<Figure> objList;
	ArrayList<Figure> redoList;
	CheckboxGroup cbg;
	Checkbox c1, c2, c3, c4, c5, c6;
	CheckboxGroup rgb;
	Checkbox a1, a2, a3;
	CheckboxGroup fill;
	Checkbox b1,b2;
	Button end;
	Button redo;
	Button undo;
	int mode = 0;
	boolean multi=false;
	Figure obj;
	public static void main(String args[]) {
		Paint3 f = new Paint3();
		f.setSize(640, 480);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);
	}
	Paint3(){
		objList = new ArrayList<Figure>();
		redoList = new ArrayList<Figure>();
		//画面作成
		setLayout(null);
		cbg = new CheckboxGroup();
		c1 = new Checkbox("丸", cbg, true);
		c1.setBounds(540, 30, 30, 30);
		add(c1);
		c2 = new Checkbox("円", cbg, false);
		c2.setBounds(540, 60, 60, 30);
		add(c2);
		c3 = new Checkbox("四角", cbg, false);
		c3.setBounds(540, 90, 60, 30);
		add(c3);
		c4 = new Checkbox("線", cbg, false);
		c4.setBounds(540, 120, 30, 30);
		add(c4);
		c5 = new Checkbox("楕円", cbg, false); 
		c5.setBounds(540, 150, 60, 30);
		add(c5);
		c6 = new Checkbox("折れ線", cbg, false);
		c6.setBounds(540,180,60,30);
		add(c6);
		
		undo = new Button("Undo");
		undo.setBounds(540, 360, 60, 30);
		undo.setActionCommand("undo");
		add(undo);
		redo = new Button("Redo");
		redo.setBounds(540, 390, 60, 30);
		redo.setActionCommand("redo");
		add(redo);
		end = new Button("終了");
		end.setBounds(540, 420, 60, 30);
		end.setActionCommand("end");
		add(end);
		
		fill = new CheckboxGroup();
		b1 = new Checkbox("塗りつぶす", fill, false);
		b1.setBounds(540,300, 90, 30);
		add(b1);
		b2 = new Checkbox("枠線のみ", fill, true);
		b2.setBounds(540,330,90,30);
		add(b2);
		
		rgb = new CheckboxGroup();
		a1=new Checkbox("赤", rgb, true);
		a1.setBounds(540, 210, 30, 30);
		add(a1);
		a2=new Checkbox("緑", rgb, false);
		a2.setBounds(540, 240, 30, 30);
		add(a2);
		a3=new Checkbox("青", rgb, false);
		a3.setBounds(540, 270, 30, 30);
		add(a3);
		
		
		//マウス処理の登録
		addMouseListener(this);
		addMouseMotionListener(this);
		//終了ボタン処理の登録
		end.addActionListener(this);
		redo.addActionListener(this);
		undo.addActionListener(this);
	}
	@Override public void paint(Graphics g) {
		Dimension size=getSize();
		c1.setBounds(size.width-100, 30, 30, 30);
		c2.setBounds(size.width-100, 60, 60, 30);
		c3.setBounds(size.width-100, 90, 60, 30);
		c4.setBounds(size.width-100, 120, 30, 30);
		c5.setBounds(size.width-100, 150, 60, 30);
		c6.setBounds(size.width-100, 180, 60, 30);
		undo.setBounds(size.width-100, 360, 60, 30);
		redo.setBounds(size.width-100, 390, 60, 30);
		end.setBounds(size.width-100, 420, 60, 30);
		a1.setBounds(size.width-100, 210, 30, 30);
		a2.setBounds(size.width-100, 240, 30, 30);
		a3.setBounds(size.width-100, 270, 30, 30);
		b1.setBounds(size.width-100, 300, 90, 30);
		b2.setBounds(size.width-100, 330,90,30);
		
		Figure f;
		for(int i = 0; i<objList.size(); i++) {
			f = objList.get(i);
			f.paint(g);
		}
		if(mode >= 1)obj.paint(g);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();
		if(cmd.equals("end")) {
			System.exit(0);
		}else if(cmd.equals("undo")) {
			if(objList.size()>0) {
				redoList.add(objList.get(objList.size()-1));
				objList.remove(objList.size()-1);
				repaint();
			}
		}else if(cmd.equals("redo")) {
			if(redoList.size()>0) {
				objList.add(redoList.get(redoList.size()-1));
				redoList.remove(redoList.size()-1);
				repaint();
			}
		}
	}
	
	@Override public void mousePressed(MouseEvent e) {
		Checkbox c;
		Checkbox a;
		Checkbox b;
		x=e.getX();
		y=e.getY();
		c=cbg.getSelectedCheckbox();
		a=rgb.getSelectedCheckbox();
		b=fill.getSelectedCheckbox();
		if(multi==true) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				obj.setCount();
				obj.moveto(x, y);
			}else {
				multi=false;
				obj.setCount();
				obj.moveto(x, y);
			}
			repaint();
		}else {
			obj = null;
			if(c == c1) {
				mode = 1;
				obj = new Dot();
			}else if(c == c2) {
				mode = 2;
				obj = new Circle();
			}else if(c == c3) {
				mode = 2;
				obj = new Rect();
			}else if(c == c4) {
				mode = 2;
				obj = new Line();
			}else if(c == c5) {
				mode = 2;
				obj = new Ellipse();
			}else if(c == c6) {
				mode = 1;
				obj = new Multiplelines();
				multi=true;
			}
			if(obj != null) {
				obj.moveto(x, y);
				repaint();
			}
			if(a==a1) {
				obj.setRed();
			}else if(a==a2) {
				obj.setGreen();
			}else if(a==a3) {
				obj.setBlue();
			}
			if(b==b1) {
				obj.setFill(1);
			}else if(b==b2) {
				obj.setFill(0);
			}
		}
	}
	@Override public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(mode == 1)			obj.moveto(x,  y);
		else if(mode == 2)		obj.setWH(x-obj.x, y-obj.y);
		if(multi==false) {
			if(mode >= 1) {
			objList.add(obj);
			obj = null;
			mode=0;
			}
		}
		repaint();
	}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		if(mode == 1) {
			obj.moveto(x, y);
		}else if(mode == 2) {
			obj.setWH(x-obj.x, y-obj.y);
		}
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}

}

