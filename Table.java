import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
class Table extends JFrame
{
	 
	JTable tb;
	Container cp;
	String [] col={ "Name" ,"Subject" ,"Batch","Marks1","Marks2","Marks3"};
    
	String [][] data={
			{ "Rohit" ,"java","Batch-1","50","50","50"},
			{  "Sumit","vb","Batch-2" ,"60","50","50" },
		    { "Roma" ,"java","Batch-3","50","80","50"},
		    { "Rupesh" ,"vb","Batch-1","80","50","50"},
		    { "Rutu" ,"java","Batch-1","90","80","50"},    
    };
   

	
	public Table()
	{
		cp=getContentPane();
		tb=new JTable(data,col);
		JScrollPane jp=new JScrollPane(tb);
		cp.add(jp,BorderLayout.CENTER);
		
		setSize(500,400);
		setVisible(true);

	}
	public static void main(String a[])
	{
		new Table();
	}
}