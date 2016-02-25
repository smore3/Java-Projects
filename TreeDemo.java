/*
JTree:A control that displays a set of hierarchical data as an outline. 
DefaultMutableTreeNode : is a general-purpose node in a tree data structure
A tree node may have at most one parent and 0 or more children. 
*/
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

class TreeDemo extends JFrame
{
	Container cp;
	JTree tree;


	public TreeDemo()
	{
		super("JTree");
		setSize(400,400 );
		cp=getContentPane();

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
		cp.add(tree);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new TreeDemo();
	}
}
