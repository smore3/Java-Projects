import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
public class AdapterDemo extends JFrame{
	Container cp;
	public AdapterDemo()
	{
		cp=getContentPane();
		//cp.addMouseListener(new ABC(this));
		cp.addMouseListener(new PQR(this));
						
		setSize(600,600);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		AdapterDemo fr=new AdapterDemo();
	}
}


//using Listener Interface
class ABC implements MouseListener 
{
	AdapterDemo parent;

	public ABC(AdapterDemo pref)
	{
		parent=pref;		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		parent.cp.setBackground(Color.red);		
	}

	//unwanted methods needs to be implemented
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


//using Adapter Class (Programmer gets rid of implementing unwanted methods)
class PQR extends MouseAdapter
{
	AdapterDemo parent;

	public PQR(AdapterDemo pref)
	{
		parent=pref;		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		parent.cp.setBackground(Color.green);		
	}
}

