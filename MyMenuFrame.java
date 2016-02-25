import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

class  MyMenuFrame extends JFrame implements ActionListener
{
	Container cp;
	JMenuBar mbar;
	JMenu  Option,Change,New,Document,Shape;
	JMenuItem Quit,BkColor,C,CPP,Java;
	JCheckBoxMenuItem WordWrap,AutoIndent,AutoComplete;
	JRadioButtonMenuItem Circle,Rectangle,Square;

	
	
	public MyMenuFrame(String title)
	{
		super(title);
		cp=getContentPane();
		//cp.setLayout(new FlowLayout());
		mbar=new JMenuBar();
		setJMenuBar(mbar);
		Option=new JMenu("Option");
		mbar.add(Option);
		
		//submenu
		New=new JMenu(" New ");
		Option.add(New);
		
		C=new JMenuItem("C");		
		New.add(C);
		New.addSeparator();
		CPP=new JMenuItem("C++");
		New.add(CPP);
		
		Java=new JMenuItem("Java");
		New.add(Java);
		
						
		Quit=new JMenuItem("Quit");
		//menu shortcut key
		Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.SHIFT_MASK ,false));
		Option.add(Quit);
		Quit.addActionListener(this);

		Change=new JMenu("Change");
		mbar.add(Change);
		BkColor=new JMenuItem("BkColor");
		Change.add(BkColor);
		BkColor.addActionListener(this);
		
		//checkbox menuitem
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
				
		
		setSize(500,500);
		setVisible(true);
	
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Quit)
		{
			int x=JOptionPane.showConfirmDialog(this,"QUIT","Are You Sure",JOptionPane.YES_NO_OPTION ,JOptionPane.ERROR_MESSAGE);			
			if(x==0)
				this.dispose();
		}
		if(ae.getSource()==BkColor)
		{
			Color c=JColorChooser.showDialog(this,"This is my color dialog box",null);
			cp.setBackground(c);
		}			
	}

	public static void main(String[] args) 
	{
		MyMenuFrame f=new MyMenuFrame("MENU FRAME");
		
	}
}
