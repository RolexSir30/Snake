package Dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {
	static ActionEvent g;
	int scoremax=1000; //score maximum
	static int score=0;
	static int x=400;
	static int y=400;
	int vx =1;
	int vy=1;
	Graphics r;
	static int qx;
	static int qy;
	static ArrayList<Integer> xcoor = new ArrayList<Integer>(); //Enregistre les positions x de la tête.
	static ArrayList<Integer> ycoor = new ArrayList<Integer>(); //Enregistre les positions y de la tête.
	
	int bonbonx=(int) (Math.random()*780);
	int bonbony=(int) (Math.random()*780);
	Timer timer;
	Timer dir;
	int temps=50; //temps du timer en ms
	int direction;
	JLabel bonbon;
	public MyPanel() {
		// TODO Auto-generated constructor stub
		//bonbon = new JLabel("fefenfjen");
		//bonbon.setSize(new Dimension(20,20));
		//bonbon.setHorizontalAlignment(20);
		//bonbon.setBounds(0,0,20,20);
		//bonbon.setBackground(Color.RED);
		for(int i =0;i<22;i++) {
		xcoor.add(0);
		xcoor.add(1);
		ycoor.add(0);
		ycoor.add(1);}
		this.setPreferredSize(new  Dimension(800,800));
		this.setBackground(Color.BLACK);
		System.out.println("bonbonx : "+bonbonx +" bonbony : "+bonbony);
		//this.add(bonbon);
		//this.addActionListener(this);
		
	}

	public void paint(Graphics g) {
		
		Graphics2D g2D =(Graphics2D) g;
		super.paint(g);
		Graphics2D bonbon =(Graphics2D) g;
		bonbon.setColor(Color.RED);
		bonbon.fillOval(bonbonx, bonbony, 20, 20);
		g2D.setColor(Color.GREEN);
		//g2D.drawRect(0, 0, 200, 200);
		g2D.fillRect(x,y, 20, 20);
		//g2D.drawLine(0,400,400,0);
		Graphics2D scor =(Graphics2D) g;
		scor.setColor(Color.CYAN);
		scor.setFont(new Font("InkFree",Font.BOLD,20));
		scor.drawString("Voici le score : "+score,300,20);
		
		
		    queue(g,score);
		
	    timer=new Timer(temps,this);
		timer.start();
		
		
		}
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		int direction;
		// TODO Auto-generated method stub
		move();
		repaint();
		
		if((x-20<bonbonx )&& (bonbonx<x+20) && (y-20<bonbony)&&(bonbony< y+20)) {
			System.out.println("MIAM");
			bonbonx=(int) (Math.random()*700);
			bonbony=(int) (Math.random()*700);	
			System.out.println("bonbonx : "+bonbonx +" bonbony : "+bonbony);
			score++;	
			for(int i =0;i<22;i++) {
				xcoor.remove(0);
				xcoor.remove(1);
				ycoor.remove(0);
				ycoor.remove(1);}
			//i++;
			//System.out.println("i : "+ i);
       // System.out.println("vx :" + vx+" vy : "+vy + " x : "+x +" y : "+y);
		}
		if(perdu()) {
			System.out.println("perdu ! ");
			
		}
		//((Component) frame).setFocusable(true);
		if(score%5==0) {
			temps=temps-2;
		}
		
			
	}


public void queue(Graphics g,int score ) {
	
	Graphics2D gp = (Graphics2D) g;
	 for(int j =0;j<scoremax;j++){
	 if(score>j) {
		int qx=xcoor.get((xcoor.size()-2)-22*(j)-20);
		int qy=ycoor.get((ycoor.size()-2)-22*(j)-20);
		Graphics2D queue = (Graphics2D) g;
		queue.setColor(new Color(0,150,0));
		
		queue.fillRect(qx,qy,20,20);
		if(perdu()) {
			
		gp.setColor(Color.BLUE);
		gp.drawLine(0,0, 800, 800);
		gp.drawLine(0, 800, 800, 0);
	 }
	 }}
}


public static void arret(Graphics y ) {
	Graphics2D fin =(Graphics2D) y;
	fin.setColor(Color.RED);
	fin.setFont(new Font("InkFree",Font.BOLD,20));
	fin.drawString("Vous avez perdu ! ",380,200);
	fin.drawString("Voici le score : "+score,380,380);
	
}

public void move() {
	  
	switch(direction) {
	  case 39 : //right
		  xcoor.add(x);
		  ycoor.add(y);
		  x=(x+vx)%800;
		
		  
		  break;
	  case 37: //left
		  xcoor.add(x);
		  ycoor.add(y);
		  x=(x-vx)%800;
		  if(x==0) {
			  x=800;
		  }
		  
		  break;
	  case 38:  //up
		  xcoor.add(x);
		  ycoor.add(y);
		  y=(y-vx)%800;
		  if(y==0) {
			  y=800;
		  }
		 // x=x;
	      break;
	  case 40 ://down
		  xcoor.add(x);
		  ycoor.add(y);
		  y=(y+vx)%800;
		 
		  //x=x;
	      break;
	
	  
	  }
	}

public static boolean perdu() {
	return (qx-20<x)&&(x<qx+20)&&(qy-20<y)&&(y<qy+20)&&(score<0);
}


	
	
}
