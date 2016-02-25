import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;


public class MenuDemo extends JFrame implements ActionListener{

	JMenuBar mbar;
	JMenu Option,New,Document,Shape,Change;
	JMenuItem Quit,C,CPP,Java,BkColor;
	JCheckBoxMenuItem WordWrap,AutoIndent,AutoComplete;
	JRadioButtonMenuItem Circle,Rectangle,Square;
	Container cp;
	public MenuDemo()
	{
		cp=getContentPane();
		mbar=new JMenuBar();
		setJMenuBar(mbar);
		Option=new JMenu("Option");
		mbar.add(Option);
		
		//submenu
		New=new JMenu("New");
		Option.add(New);
		C=new JMenuItem("C");
		New.add(C);
		New.addSeparator();
		CPP=new JMenuItem("CPP");
		New.add(CPP);		
		Java=new JMenuItem("Java");
		New.add(Java);
			
		//simple menuitem
		Quit=new JMenuItem("Quit");
		Option.add(Quit);
		Quit.addActionListener(this);
		Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.SHIFT_MASK ,true));
		
		//checkboxmenuitem
		Document=new JMenu("Document");
		mbar.add(Document);
		WordWrap=new JCheckBoxMenuItem("Word-Wrap");
		Document.add(WordWrap);		
		AutoIndent=new JCheckBoxMenuItem("Auto-Indent");
		Document.add(AutoIndent);		
		AutoComplete=new JCheckBoxMenuItem("Auto-Complete");
		Document.add(AutoComplete);		
	
		//radiobutton menuitem
		Shape=new JMenu("Shape");
		mbar.add(Shape);
		
		Circle=new JRadioButtonMenuItem("Circle");
		Shape.add(Circle);
		Rectangle=new JRadioButtonMenuItem("Rectangle");
		Shape.add(Rectangle);
		Square=new JRadioButtonMenuItem("Square");
		Shape.add(Square);
		
		ButtonGroup grp=new ButtonGroup();
		grp.add(Circle);
		grp.add(Rectangle);
		grp.add(Square);
		
		Change=new JMenu("Change");
		mbar.add(Change);
		BkColor=new JMenuItem("BkColor");
		Change.add(BkColor);
		BkColor.addActionListener(this);
		
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuDemo fr=new MenuDemo();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==Quit)
		{
		int r=JOptionPane.showConfirmDialog(this, "Quit");
		if(r==0)
			this.dispose();
			//System.exit(0);		
		}
		if(ae.getSource()==BkColor)
		{
			 //  Color c =JColorChooser.showDialog(arg0, arg1, arg2)
			Color c=JColorChooser.showDialog(this,"This is my color dialog box",Color.pink);
			cp.setBackground(c);
		}	
			
	}

}