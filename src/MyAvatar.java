import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
public class MyAvatar extends JApplet {
	public void paint(Graphics g){
	g.setColor(new Color(255,228,196));
	g.fillArc(300, 250,350,500, 10, -200);
	g.fillArc(295, 300,360,500,10,150);
	g.fillArc(273, 465, 50, 100,80,210);
	g.fillArc(625, 465, 50, 100,100,-210);
	g.setColor(Color.black);
	g.drawArc(300, 250,350,500, 10, -200);
	g.drawArc(625, 465, 50, 100,100,-210);
	// hair
	g.fillArc(300,250,350,400,-5,190);
	
	//nose
	g.drawArc(475, 475, 40, 100, 110, 150);
	g.drawArc(460, 585, 30, 30, 80, 80);
	
	//mouth
	g.drawArc(440, 650, 100, 10, 180,120);
	
	g.drawArc(273, 465, 50, 100,80,210);
	
	//eye
	g.drawLine(340, 470, 440, 485);
	g.drawLine(510, 485, 610, 470);
	g.setColor(Color.white);
	g.fillArc(526,443,70, 70, 9, -178);
	g.fillArc(357,443,70,70,-9,-178);
	//eye + glasses
	g.setColor(Color.red);
	g.fillOval(385, 475, 10, 20);
	g.fillOval(555, 475, 10, 20);
	g.fillRect(300, 455, 350, 10);
	g.fillRect(320, 520, 140,10);
	g.fillRect(490, 520, 140,10);
	g.fillRect(320,455,10,65);
	g.fillRect(450,455,10,65);
	g.fillRect(490,455,10,65);
	g.fillRect(620,455,10,65);
	g.setColor(Color.black);
	
	g.setColor(Color.RED);
	g.setFont(new Font("Arial",Font.BOLD,25));
	g.drawString("Tong",250, 250);
	g.setFont(new Font("Arial",Font.BOLD,50));
	g.drawString("I\'M THE AUTHOR", 100, 100);
	}
}