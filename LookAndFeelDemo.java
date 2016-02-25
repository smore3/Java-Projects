import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.*;
import javax.swing.plaf.multi.*;

class LookAndFeelDemo extends JFrame implements ActionListener
{
	LookAndFeelDemo()
	{
		Container con=getContentPane();

		con.setLayout(new FlowLayout());
		JButton system = new JButton("System");
		JButton cross = new JButton("Cross");
		JButton motif = new JButton("Motif");
		JButton metal = new JButton("Metal");
		JButton windows = new JButton("Windows");

		system.addActionListener(this);
		cross.addActionListener(this);
		motif.addActionListener(this);
		metal.addActionListener(this);
		windows.addActionListener(this);

		con.add(system);
		con.add(cross);
		con.add(motif);
		con.add(metal);
		con.add(windows);
		setSize(200,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String laf=ae.getActionCommand();
		try 
		{

		if(laf.equals("System"))
		 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		 else if(laf.equals("Cross"))
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

		 else if(laf.equals("Motif"))
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

		 else if(laf.equals("Metal"))
			 	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

		 else if(laf.equals("Windows"))
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

			SwingUtilities.updateComponentTreeUI(this);

		}
		catch(Exception e)
		{
			 System.out.println("Error setting native LAF: " + e);
		}

	}
	public static void main(String[] args) 
	{
		new LookAndFeelDemo();
	}
}
