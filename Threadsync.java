import java.util.Scanner;


public class Threadsync extends Thread{
Account account;

	/**
	 * @param args
	 */
public Threadsync(Account account,String name)
{
super(name);
this.account=account;
}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try
		{
			int i=0;
			while(true)
			{
			if(Thread.currentThread().getName().equals("1"));
			{
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter the amount to be withdrawn:");
				int a=scan.nextInt();
				withdraw(a);
				Thread.sleep(500);
			}	
			if(Thread.currentThread().getName().equals("2"));
			{
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter the amount to be deposited:");
				int a=scan.nextInt();
				deposit(a);
				Thread.sleep(500);
			}
			i++;
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
	}
	public void withdraw(int amount)
	{
	try
	{
	account.lock.lock();
	int bamt=account.getBalance();
	System.out.print("Withdraw:"+amount);
	int bal=bamt-amount;
	account.setBalance(bal);
	bamt=account.getBalance();
	System.out.println("\t"+bamt);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public void deposit(int amount)
	{
	try
	{
	account.lock.lock();
	int bamt=account.getBalance();
	System.out.print("Deposit: "+amount);
	int bal=bamt+amount;
	account.setBalance(bal);
	bamt=account.getBalance();
	System.out.println("\t\t"+bamt);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int original=10000;
		System.out.println("original balance:"+original);
		System.out.println("\t\tThe balance after transaction");
		Account account=new Account(original);
		Thread t1=new Threadsync(account,"1");
		Thread t2=new Threadsync(account,"2");
    t1.start();
    t2.start();
	}

}
