import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JToolBar;


public class ToolBarDemo extends JFrame implements ActionListener{

	JToolBar tool;
	JButton New,Open,Change,Search;
	Container cp;

	public ToolBarDemo()
	{
		cp=getContentPane();
		
		New=new JButton("New");
		Open=new JButton("Open");
		Change=new JButton("Change");
		Change.setToolTipText("Change Background Color");
		Search=new JButton(new ImageIcon("search.jpg"));
		
		//create a Toolbar
		tool=new JToolBar();
		tool.setFloatable(true);//user can drag the toolbar anywhere
	
		//add buttons to the toolbar
		tool.add(New);
		tool.addSeparator();
		tool.add(Open);
		tool.addSeparator();
		tool.add(Change);
		tool.addSeparator();
		tool.add(Search);
		//add the toolbar to the frame
		add(tool,"North");
		
		
		Change.addActionListener(this);
		
		
		setSize(500,500);
		setTitle("Toolbar demo");
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToolBarDemo fr=new ToolBarDemo();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==Change)
		{
			Color clr=JColorChooser.showDialog(this, "My Color Box", null);
			cp.setBackground(clr);
		}
		
	}

}
