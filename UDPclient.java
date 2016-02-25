import java.net.*;
class UDPclient  
{
	DatagramSocket DS;
	DatagramPacket DP;
	InetAddress addr;
	static int i=0;
	
   public static void main(String[] args) 
   { 
	   UDPclient us=new UDPclient();
	   us.go();
	   //us.wait();
   }

   public void go()
	{
	   try
	   {
	   DS=new DatagramSocket(1303);
	   addr=InetAddress.getLocalHost();
	   byte b[]=new byte[64];
	   
	   DP=new DatagramPacket(b,b.length);
       Thread.sleep(10000);  
	   while(true)
	    {
		 DS.receive(DP);
		 System.out.println(new String(DP.getData())+"\n");
		}
 
	   } 
	  	
	   catch(Exception e)
	   {
	     e.printStackTrace();
	   }
	}

	
}