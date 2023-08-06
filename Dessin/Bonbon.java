package Dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Bonbon  extends JPanel implements ActionListener{
    
	public Bonbon() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new  Dimension(800,800));
		this.setBackground(Color.RED);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillRect(20,20, 20, 20);
		
	}

}
