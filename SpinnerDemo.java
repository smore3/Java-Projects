import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

public class SpinnerDemo extends JFrame{

	JSpinner spin1,spin2;
	
	Container cp;
	JLabel lb;
	
	public SpinnerDemo()
	{
		
		cp=getContentPane();
		cp.setLayout(new GridLayout(2,2));		
		
		cp.add(new JLabel("Birth Date : "));		
		
		//Date Spinner
		SpinnerModel dtmodel=new SpinnerDateModel();
		spin1=new JSpinner(dtmodel);
		cp.add(spin1);
				
		
		cp.add(new JLabel("Age"));
		ArrayList<Integer> mylist=new ArrayList<Integer>();
		mylist.add(10);
		mylist.add(20);
		mylist.add(30);
		mylist.add(40);
		mylist.add(50);
		
		//Number Spinner
		SpinnerModel numModel=new SpinnerListModel(mylist);
		spin2=new JSpinner(numModel);
		cp.add(spin2);
		
		
		
			
		setSize(600,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SpinnerDemo fr=new SpinnerDemo();

	}

}



