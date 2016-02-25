import java.awt.*;
import javax.swing.*;

class TabbedDemo extends JFrame
{
	Container cp;
	JButton b1,b2,b3;
	
	public TabbedDemo()
	{
		cp=getContentPane();
		JPanel p1=new JPanel();
		p1.setBackground(Color.orange);
		
		JPanel p2=new JPanel();
		p2.setBackground(Color.cyan);
		
		JPanel p3=new JPanel();
		p3.setBackground(Color.green);
		
		
		
		//Tabbed Pane consists of multiple tabs (Panels)
		JTabbedPane tb=new JTabbedPane();
		tb.addTab("First",p1);
		tb.addTab("Second",p2);
		tb.addTab("Third",p3);
		cp.add(tb);
		
		
		setSize(400,400);
		setVisible(true);

	}
	public static void main(String a[])
	{
		new TabbedDemo();
	}
}