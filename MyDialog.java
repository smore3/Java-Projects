import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//Dialog Class
public class MyDialog extends JDialog implements ActionListener
{
	JLabel jimage,l1,l2;
	JTextField tf1,tf2;
	JButton bOK,bCancel;
	Container cp;
	MyDialogFrame parent;
	
	public MyDialog(JFrame owner, String title, boolean modal) 
	{
		super(owner,title,modal);
		parent=(MyDialogFrame)owner;
		
		cp=getContentPane();
		
		cp.setLayout(null);

		l1=new JLabel("Enter ID to be searched  : ");
		l1.setBounds(50,50,150,30);
		cp.add(l1);

		tf1=new JTextField(25);
		tf1.setBounds(250,50,100,30);
		cp.add(tf1);
		tf2=new JTextField(25);
		tf2.setBounds(250,100,100,30);
		cp.add(tf2);


		l2=new JLabel("Name : ");
		l2.setBounds(50,100,100,30);
		cp.add(l2);

		bOK=new JButton("OK");
		bOK.setBounds(50,150,100,30);
		cp.add(bOK);
		bOK.addActionListener(this);

		bCancel=new JButton("Cancel");
		bCancel.setBounds(200,150,100,30);
		cp.add(bCancel);

		jimage=new JLabel(new ImageIcon("search.jpg"));
		jimage.setBounds(375,120,80,60);
		cp.add(jimage);
		
		setLocation(150,150);
		setSize(600,250);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Toolkit tool=Toolkit.getDefaultToolkit();
		Image img=tool.getImage("smiley.jpg");
		g.drawImage(img,400,30,this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==bOK)
			{
				parent.cp.setBackground(Color.red);
				cp.setBackground(Color.green);
				repaint();
			}
		
	}


}

