import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class SplitPaneDemo extends JFrame{

	Container cp;
	JSplitPane split;
	
	public SplitPaneDemo()
	{
		
		split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setBackground(Color.white);
		split.setLeftComponent(new MyTree());		
		split.setRightComponent(new MyTable());
		split.setDividerLocation(300);
		add(split);
		
		setSize(800,800);
		setTitle("Split Pane");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SplitPaneDemo fr=new SplitPaneDemo();
	}

}


class MyTree extends JPanel
{
	JTree tree;

	public MyTree()
	{
		DefaultMutableTreeNode top=new DefaultMutableTreeNode("Alphabets");
		DefaultMutableTreeNode A=new DefaultMutableTreeNode("A");
		DefaultMutableTreeNode B=new DefaultMutableTreeNode("B");
	
		DefaultMutableTreeNode a1=new DefaultMutableTreeNode("Apple");
		DefaultMutableTreeNode a2=new DefaultMutableTreeNode("Angel");
		DefaultMutableTreeNode a3=new DefaultMutableTreeNode("America");
		DefaultMutableTreeNode b1=new DefaultMutableTreeNode("Ball");
		DefaultMutableTreeNode b2=new DefaultMutableTreeNode("Bat");
		DefaultMutableTreeNode b3=new DefaultMutableTreeNode("Bucket");
		A.add(a1);
		A.add(a2);
		A.add(a3);
		B.add(b1);
		B.add(b2);
		B.add(b3);
		top.add(A);
		top.add(B);
	
		tree=new JTree(top);
		add(tree);	
		
	}
}

class MyTable extends JPanel
{
	
	String [] col={ "Name" ,"Subject" ,"Batch","Marks1","Marks2","Marks3"};
    
	String [][] data={
			{ "Rohit" ,"java","Batch-1","50","50","50"},
			{  "Sumit","vb","Batch-2" ,"60","50","50" },
		    { "Roma" ,"java","Batch-3","50","80","50"},
		    { "Rupesh" ,"vb","Batch-1","80","50","50"},
		    { "Rutu" ,"java","Batch-1","90","80","50"},    
    };
	JTable tb;
	public MyTable()
	{
		tb=new JTable(data,col);
		JScrollPane jp=new JScrollPane(tb);
		add(jp,BorderLayout.CENTER);	
		
	}
}



