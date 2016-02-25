import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 * @author saket.kale
 *
 */
public class AdmissionForm extends JFrame implements ActionListener{

	/**
	 * 
	 */
	JSplitPane pane;
	JSpinner DD,MM,YY;
	JLabel name,qualification,subject,bdt,gender,selectsub,selectedsub,info;
    JTextField txtname;
    JComboBox comboqualification;
    JList listSub1,listSub2;
    JButton register,add,remove,reset;
    JRadioButton button1; 
    JRadioButton button2; 
    Object selectionValues[];
    Vector <Object> data;
    Vector <Object> data2;
    JPanel jp1,jp2,tab1,tab2,tab3;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    JTabbedPane tabpane;
    JTree tree;
    DefaultMutableTreeNode studinfo;
    JTable table;
    DefaultTableModel model;
    int currentYear;
    
    
    JToolBar toolbar;
	JToggleButton metal,nimbus;
	
	
	JMenu SkinSelector;
    //JMenuItem 
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public AdmissionForm(){
		
		super("Student Information System");
		
		
		 
		
		
		
		Container cp=getContentPane();
		 
		jp1=new JPanel();
		
		jp2=new JPanel();
		jp2.setLayout(new BorderLayout());
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		jp1.setLayout(gbl);
				
			
		/*
		 * textfield and label 
		 */
		
		name=new JLabel("Name");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbl.setConstraints(name, gbc);
				
		txtname=new JTextField(10);
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbl.setConstraints(txtname, gbc);
		
		pack();
		setVisible(true);
		
		bdt = new JLabel("Birthdate :");
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=2;
		gbl.setConstraints(bdt, gbc);
		
		
		Calendar calendar = Calendar.getInstance();
		currentYear = calendar.get(Calendar.YEAR);
		SpinnerModel yearModel = new SpinnerNumberModel(currentYear,currentYear - 100,currentYear + 100,1);
		SpinnerModel dateModel =new SpinnerNumberModel(1,1,31,1);
		SpinnerModel monthModel=new SpinnerNumberModel(1,1,12,1);
		
		DD=new JSpinner(dateModel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbl.setConstraints(DD, gbc);
		
		MM=new JSpinner(monthModel);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbl.setConstraints(MM, gbc);
				
		
		YY=new JSpinner(yearModel);
		
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbl.setConstraints(YY, gbc);
		
		
		//c.add(name);
		//c.add(txtname);
		/* -------------------------textfield over -------------------------------------- */
		
		/*
		 * Combox creration and label
		 */
		qualification=new JLabel("Qualification");
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(qualification, gbc);
		
		
		comboqualification=new JComboBox();
		
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(comboqualification, gbc);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    comboqualification.addItem("BCA");
	    comboqualification.addItem("BCS");
	    comboqualification.addItem("BE");
	    comboqualification.addItem("ME");
	    comboqualification.addItem("MCA");
	    comboqualification.addItem("MCS");
	    comboqualification.addItem("MCM");
	    	    
	    comboqualification.setEditable(true);//why set editable?
	    
	   
	  //  pack();
	    setVisible(true);
         /* ----------------Combo over ----------------------------*/
		
		 /*
		  * JRadioButton creation
		  */
	    
	    gender=new JLabel("Gender");
	    gbc.gridx=0;
	    gbc.gridy=3;
	    gbl.setConstraints(gender, gbc);
	    
	     button1 = new JRadioButton("Male");
	     	
			gbc.gridx=1;
			gbc.gridy=3;
			gbl.setConstraints(button1, gbc);
	     button2 = new JRadioButton("Female");
	     	
			gbc.gridx=2;
			gbc.gridy=3;
			gbl.setConstraints(button2, gbc);
	     ButtonGroup buttonGroup = new ButtonGroup();
	     buttonGroup.add(button1);
	     buttonGroup.add(button2);
	     button1.setSelected(true);
	     
	     	
	     pack();
		 setVisible(true);
        
		 
		selectsub=new JLabel("Select subjects");
		 	gbc.gridx=0;
		    gbc.gridy=4;
		    gbc.gridwidth=2;
		    gbl.setConstraints(selectsub, gbc);
		selectedsub=new JLabel("Selected subjects");
		 	gbc.gridx=2;
		    gbc.gridy=4;
		    gbc.gridwidth=1;
		    gbl.setConstraints(selectedsub, gbc);
		 
		data=new Vector<Object> ();
		data2=new Vector<Object>();
		data.addElement("JAVA");
		data.addElement("DotNet");
		data.addElement("Testing");
		data.addElement("Web Designing");
		listSub1=new JList(data);
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridheight=2;
		
		gbl.setConstraints(listSub1, gbc);
		
		//JScrollPane scrollingList = new JScrollPane(listSub1);
		int cellWidth = 200;
		listSub1.setFixedCellWidth(cellWidth);
		int cellHeight = 18;
		listSub1.setFixedCellHeight(cellHeight);
		//getContentPane().add(subject);
		gbc.gridx=0;
		gbc.gridy=5;
		


		pack();
		setVisible(true);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(new GridLayout(2,1,25,5));
		gbc.gridx=1;
		gbc.gridy=5;
		//gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.BOTH;
		
		gbl.setConstraints(buttonpanel, gbc);
		add=new JButton(">>");
			
		add.addActionListener(this);
		
		remove=new JButton("<<");
		remove.addActionListener(this);
		
		//pack();
		setVisible(true);
			
		buttonpanel.add(add);
		buttonpanel.add(remove);
		
		listSub2=new JList();
		cellWidth = 200;
		listSub2.setFixedCellWidth(cellWidth);
		cellHeight = 18;
		listSub2.setFixedCellHeight(cellHeight);
		
		gbc.gridx=2;
		gbc.gridy=5;
		gbc.gridheight=2;
		gbc.fill=GridBagConstraints.BOTH;
		gbl.setConstraints(listSub2, gbc);
		//pack();
		setVisible(true);
		 
		
		
		
		register=new JButton("Register");
		
		
		gbc.gridx=0;
		gbc.gridy=7;
		gbc.fill=GridBagConstraints.CENTER;
		gbl.setConstraints(register, gbc);
		
		
		reset=new JButton("Reset");
		
		
		gbc.gridx=1;
		gbc.gridy=7;
		gbl.setConstraints(reset, gbc);
		
		jp1.add(name);
		jp1.add(txtname);
		
		jp1.add(bdt);
		jp1.add(DD);
		jp1.add(MM);
		jp1.add(YY);
	    	    
		jp1.add(qualification);
	    jp1.add(comboqualification);
     
	   
	    jp1.add(gender);
	    jp1.add(button1);
	    jp1.add(button2);
	    
	    jp1.add(selectsub);
	    jp1.add(selectedsub);
	    jp1.add(listSub1);
		
	    jp1.add(buttonpanel);
		
		
		jp1.add(listSub2);	
		jp1.add(register);
		jp1.add(reset);
		
		tabpane=new JTabbedPane();
		tabpane.setSize(200,270);
		
		tab1=new JPanel();
		tab1.setToolTipText("Simple View");
		tab1.setName("Simple View");
		tab1.setLayout(new GridLayout(4,4,5,5));
		
		tab2=new JPanel();
		tab2.setLayout(new BorderLayout());
		tab2.setToolTipText("Tree view");
		tab2.setName("Tree View");
		studinfo=new DefaultMutableTreeNode("Student Information");
		tree=new JTree(studinfo);
		tab2.add(tree,BorderLayout.WEST);
		
		tab3=new JPanel();
		tab3.setLayout(new BorderLayout());
		tab3.setToolTipText("Table view");
		tab3.setName("Table View");
		
		model=new DefaultTableModel();
		table=new JTable(model);
		tab3.add(new JScrollPane(table),BorderLayout.CENTER);
		
		model.addColumn("Name");
		model.addColumn("Birthdate");
		model.addColumn("Gender");
		model.addColumn("Subjects");
		
		tabpane.add(tab1);
		tabpane.add(tab2);
		tabpane.add(tab3);
		
		jp2.add(new JScrollPane(tabpane),BorderLayout.CENTER);
		
		pane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp2);
		//pane.setDividerLocation(230);
		cp.add(pane);
		
		register.addActionListener(this);
		reset.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdmissionForm d=new AdmissionForm();
		d.setSize(850,270);
		d.setVisible(true);
		d.setLocationRelativeTo(null);
		UIManager.LookAndFeelInfo lookAndFeels[]= UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo lookAndFeelInfo : lookAndFeels) {
			System.out.println(lookAndFeelInfo.getClassName());
		}
		
		 /*d.setD
		d.setDefaultLookAndFeelDecorated();*/
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		JLabel lblnm,lblbd,lblgender,lblsub;
		if(ae.getSource()==add)
		{
			System.out.println("inside add");
			//collected all selected values
			
			Object []listitems1=listSub1.getSelectedValues();
			
			//iterated through the values and then added to data2 
			for (Object object : listitems1) {
				data2.addElement(object);
			}	
			
			//added data2 to second list
			listSub2.setListData(data2);
			
			//for removing elements from the list
			int []selectedindices=listSub1.getSelectedIndices();
			for (int i=selectedindices.length-1;i>-1;i--) {
				
				data.removeElementAt(selectedindices[i]);	
			}
			listSub1.setListData(data);			
		}
		if(ae.getSource()==remove)
		{
			System.out.println("inside remove");
			Object []listitems2=listSub2.getSelectedValues();
			
			for (Object object : listitems2) {
				data.addElement(object);
			}	
			listSub1.setListData(data);
			int []selectedindices=listSub2.getSelectedIndices();
			for (int i=selectedindices.length-1;i>-1;i--) {
				
				data2.removeElementAt(selectedindices[i]);	
			}
			listSub2.setListData(data2);
			
		}
		if(ae.getSource()==register)
		{
			System.out.println("inside Register");
			String gender,nm,Bd,sub;
			nm=txtname.getText();
			Bd=DD.getValue()+"/"+MM.getValue()+"/"+YY.getValue();
			sub=data2.toString();
			if(button1.isSelected())
				gender="Male";
			else
				gender="Female";
			lblnm=new JLabel("Student name ="+nm);
			lblbd=new JLabel("Birthdate ="+Bd);
			lblgender=new JLabel("Gender ="+gender);
			lblsub=new JLabel("Selected Subjects ="+sub);
			tab1.add(lblnm);
			tab1.add(lblbd);
			tab1.add(lblgender);
			tab1.add(lblsub);
			
			
			
				DefaultMutableTreeNode Name=new DefaultMutableTreeNode(nm);
				
				DefaultMutableTreeNode BD=new DefaultMutableTreeNode("Birthdate");
					BD.add(new DefaultMutableTreeNode(Bd));
					Name.add(BD);
				DefaultMutableTreeNode Gender=new DefaultMutableTreeNode("Gender");
					Gender.add(new DefaultMutableTreeNode(gender));
					Name.add(Gender);
				DefaultMutableTreeNode Subjects=new DefaultMutableTreeNode("Subjects");
					Name.add(Subjects);
				for (Object obj : data2) {
					Subjects.add(new DefaultMutableTreeNode(obj));
				}
			studinfo.add(Name);
					
			model.addRow(new Object[]{nm,Bd,gender,data2.toString()});
			
		/*	Object cols[]=new Object[]{"Name","Birthdate","Gender","Subjects"};
			Object data1[][]=new Object[][]{{nm,Bd,gender,data2.toString()}};
			table=new JTable(data1,cols);
			
			tab3.add(new JScrollPane(table));*/
		
			
			
		}
		if(ae.getSource()==reset)
		{
			System.out.println("inside reset");
			txtname.setText("");
			DD.setValue(1);
			MM.setValue(1);
			YY.setValue(currentYear);
			data=new Vector<Object>();
				data.addElement("JAVA");
				data.addElement("DotNet");
				data.addElement("Testing");
				data.addElement("Web Designing");
			listSub1.setListData(data);
			
			Object obj[]=listSub1.getComponents();
			System.out.println(obj.toString());
			System.out.println(data.toString());
			data2.removeAllElements();
			listSub2.setListData(data2);
			comboqualification.setSelectedIndex(0);
			button1.setSelected(true);
			validate();
		}
		
		if(ae.getSource()==metal)
		{
			nimbus.setSelected(false);	
			
		}
		if(ae.getSource()==nimbus)
		{
			metal.setSelected(false);
			
			
		}
		validate();
		//tree=null;
		lblnm=null;
		lblbd=null;
		lblgender=null;
		lblsub=null;
	}
	
}