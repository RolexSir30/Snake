package Dessin;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements KeyListener{

	MyPanel panel;
	Bonbon bonbon;
	//Bonbon bonbon;
	public MyFrame() {
		// TODO Auto-generated constructor stub
		panel = new MyPanel();
		bonbon = new Bonbon();
		
		this.setTitle("Dessin");
		//this.getContentPane().setBackground(Color.YELLOW);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.requestFocus();
		this.setSize(800,800);
		panel.setBounds(0,0,800,800);
		this.add(panel);
		
		
		this.add(bonbon);
		//this.pack();
		this.setVisible(true);
		this.addKeyListener(this);
		System.out.println("yo");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
			
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
		switch(e.getKeyCode()) {
		case 38 : 
			panel.direction=38;
			break;
		case 39 :
			panel.direction=39;
			break;
		case 40 :
			panel.direction=40;
			break;
		case 37 :
			panel.direction=37;
			break;
		case 32 :
			(panel.timer).stop();
		    break;
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
