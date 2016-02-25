/*
A Simple Frame Window 
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  MyDialogFrame extends JFrame implements ActionListener
{
	Container cp;
	JButton bShow;
	MyDialog dlg;

	public MyDialogFrame()
	{
		
		cp=getContentPane();
		cp.setLayout(new FlowLayout());

		bShow=new JButton("Show");
		cp.add(bShow);
		bShow.addActionListener(this);

		
		setSize(400,400);
		setLocation(150,150);
		setVisible(true);
 	}

	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==bShow)
		{
			dlg=new MyDialog(this,"My Dialog Box",false);

		}
	}
	public static void main(String[] args) 
	{
		MyDialogFrame f=new MyDialogFrame();
		
	}
}

