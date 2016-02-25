import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Animation extends JFrame implements Runnable {
	Thread t1,t2;
Image i[]= new Image[3];
Toolkit tool;
int x1,y1,c;

	/**
	 * @param args
	 */
public Animation()
{
setSize(400, 400);
setLayout(null);
t1=new Thread(this);
t1.start();
t2=new Thread(this);
t2.start();

tool=Toolkit.getDefaultToolkit();
i[0]=tool.getImage("411.png");
i[1]=tool.getImage("412.png");
i[2]=tool.getImage("413.png");
//i[3]=tool.getImage("4.jpg");
//i[4]=tool.getImage("5.jpg");


setLocation(150, 150);
setVisible(true);
}
public void paint(Graphics g)
{
super.paint(g);
g.setFont(new Font("Arial",Font.BOLD,50));
g.drawString("I am smart", 100, 100);
g.drawImage(i[c], 200, 200, this);
}

@Override
public void run() {
	// TODO Auto-generated method stub
Thread tcurr=Thread.currentThread();

if(tcurr==t1)
{
blink();	
}
if(tcurr==t2)
{
	animate();
}
}
public void blink()
{
	repaint();}

public void animate()
{
	try
	{
while(true)
{
if(c==2)
	c=0;
else
	c++;
Thread.sleep(500);
 repaint();                                                                              
}

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Animation a=new Animation();
	}

}
