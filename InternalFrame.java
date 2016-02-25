import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class InternalFrame extends JFrame
{
	
	JDesktopPane jtp;
	JButton b1;
	
	public InternalFrame()
	{
		//Create DesktopPane
		jtp=new JDesktopPane();
		setContentPane(jtp);
		
		
		//Create an Internal Frame
		JInternalFrame jif=new JInternalFrame("Child Frame",true,false,false,true);
		jif.reshape(20,20,400,400);
		jif.show();
		//Add a Button to Internal Frame
		Container ccp=jif.getContentPane();
		ccp.setLayout(new FlowLayout());
		b1=new JButton("OK");
		ccp.add(b1);
		
		//Add the Internal Frame to the Desktop Frame
		jtp.add(jif);
		
		
		setSize(600,600);
		setTitle("Parent Frame");
		setVisible(true);
	

	}

	public static void main(String a[])
	{
		new InternalFrame();
	}
}