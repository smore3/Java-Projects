import java.net.*;

class UDPserver  
{
	DatagramSocket DS;
	DatagramPacket DP;
	InetAddress addr;
	static int i=0;
	
   public static void main(String[] args) 
   { 
	   UDPserver us=new UDPserver();
	   us.go();
   }

   public void go()
	{
	   try
	   {
	   DS=new DatagramSocket();
	   addr=InetAddress.getLocalHost(); 

	   for( ; ; )
		{
		 Thread.sleep(1000); 
	     String str="This is my "+i+"th datagram packet";
		 System.out.println(str+"\n");
	     byte b[]=str.getBytes();
		 DP=new DatagramPacket(b,b.length,addr,1303);
		 i++;
        
		 DS.send(DP);   
        } 
	  	
	   }

	   catch(Exception e)
	   {
	     e.printStackTrace();
	   }
	}
}
