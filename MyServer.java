 import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

class MyServer extends Frame implements ActionListener
{
	TextField txtenter;
	TextArea txtdisplay;
	DataOutputStream output;
	DataInputStream input;

	public MyServer()
	{
		super("MY SERVER APPLICATION");
		setLayout(new GridLayout(2,1));		
		
		//Create a Read-Only TextArea
		txtdisplay=new TextArea();
		txtdisplay.setEditable(false);
		add(txtdisplay);

		txtenter=new TextField(25);
		txtenter.addActionListener(this);
		txtenter.setEnabled(false);
		add(txtenter);
		setSize(300,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//when the server types some message & presses ENTER key
		try
		{
		String s=e.getActionCommand();
		output.writeUTF("SERVER>>>"+s);//writes the server msg into the outputstream
		txtdisplay.append("\nSERVER>>>"+s);
	 	txtenter.setText("");
		}
		catch(Exception ex){}
	}

	public void runServer()
	{
		ServerSocket ss;
		Socket s;
		try
		{
			 //create a seversocket
			 ss=new ServerSocket(5000);//server is waiting at port no 5000
			 while(true)
			 {
			    //wait for the connection ie Client request
			    txtdisplay.setText("\nWaiting for the Connection...");

			     //establishing connection
			    s=ss.accept();
			    txtdisplay.append("\nConnection received from:"+s.getInetAddress().getHostName());

			     //getting input/output streams associated with the Server Socket
				output=new DataOutputStream(s.getOutputStream());
			    output.flush();
			    input=new DataInputStream(s.getInputStream());
			     //processing connection
			    String message="Server>>>Connection Sucessfull...";
			    output.writeUTF(message);
			    output.flush();
			    txtenter.setEnabled(true);
			    do
			    {
			     message=input.readUTF();//Go on reading the messages from client until the msg is TERMINATE
				 txtdisplay.append("\n"+message);
			    }while(!message.equals("CLIENT>>>TERMINATE"));

			    txtdisplay.append("\nUser Terminated Connection...");
			    output.close(); //close the I/O streams
			    input.close();
			    s.close();	//close the socket
			   }
		}
		catch(Exception e)
		{}
	}

	public static void main(String[] args) 
	{
		MyServer ser=new MyServer();
		ser.runServer();
	}
}
