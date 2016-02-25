import java.io.*;


public class raf {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
File f1=new File("Introduction1.txt");
File f2=new File("http1.txt");

RandomAccessFile raf1=new RandomAccessFile (f1,"r");
RandomAccessFile raf2=new RandomAccessFile (f2,"rw");
try
{
int x=0;
do
{
x=raf1.read();
raf2.write((char) x);
} while(x!=-1);
}
catch(FileNotFoundException e)
{
	System.out.println("File not found");
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Hello World");
	
	}

}
