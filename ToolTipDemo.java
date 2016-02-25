import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
public class ToolTipDemo extends JFrame{
	
	JButton b;
	Container cp;
	
	public ToolTipDemo()
	{
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		b = new JButton("Hello, World");	    
	    b.setToolTipText("This is hello button");
	    cp.add(b,"Center");
	    
	    setSize(300, 200);
	    setVisible(true);		
	}
	
  public static void main(String args[]) {
	  ToolTipDemo frame = new ToolTipDemo();
   
    
  }
}