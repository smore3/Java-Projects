import javax.swing.*;
import java.awt.*;
class JColorChooserDemo extends JFrame
{
		Container cp;
		public JColorChooserDemo()
		{
			cp=getContentPane();			
					
			Color clr=JColorChooser.showDialog(this,"color",Color.blue);
			cp.setBackground(clr);
			
			setSize(500,500);
			setVisible(true);
			
			
			
		}
		public static void main(String a[])
	    {
			new JColorChooserDemo();
	     }

};