//Client.java

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class MyClient extends Frame implements ActionListener
{
 TextField txtenter;
 TextArea txtdisplay;
 DataOutputStream output;
 DataInputStream input;
 String message="";

 public MyClient()
 {
  super("MY CLIENT APPLICATION");
  setLayout(new GridLayout(2,1));

   //Create a read-only TextArea	
  txtdisplay=new TextArea();
  txtdisplay.setEditable(false);
  add(txtdisplay); 

  txtenter=new TextField();
  txtenter.setEnabled(false);
  txtenter.addActionListener(this);
  add(txtenter);

  setSize(300,300);
  setVisible(true);
 }
  
  public void actionPerformed(ActionEvent e)
  {
	  //when the client types some message & presses ENTER key
   try
	 {
	String s=e.getActionCommand();
	output.writeUTF("CLIENT:"+s); //writes the client msg into the outputstream
    output.flush();
    txtdisplay.append("\nCLIENT:"+s);   
	txtenter.setText("");
	  }
	  catch(Exception ex){}
  }

 public void runClient()
 {
  Socket s;
  try
  {
    
	txtdisplay.setText("Client !!! Attempting Connection...");
     //establishing connection
	s=new Socket("LAB3-14.SEEDAUNDH.COM",5000);
	//s = new Socket("localhost",5000);
	//  s=new Socket("cls-1",5000);
    txtdisplay.append("Connected to : "+s.getInetAddress().getHostName());

	//getting input/output streams associated with the Client Socket
    output=new DataOutputStream(s.getOutputStream());
    output.flush();
    input=new DataInputStream(s.getInputStream());
    txtenter.setEnabled(true);
     //processing connection
    
	do
    {
        message=input.readUTF();//Go on reading the messages from server until the msg is TERMINATE
        txtdisplay.append("\n"+message);
    	}while(!message.equals("SERVER>>>TERMINATE"));


    txtdisplay.append("Closing Connection...");
    input.close(); //close the I/O streams
    output.close();
    s.close();//close the socket
 }
 catch(Exception e)
 {}
 }
 public static void main(String args[])
 {
  MyClient client=new MyClient();
  client.runClient();
 }
}





