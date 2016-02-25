import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Account {
int balance;
	/**
	 * @param args
	 */
Lock lock=new ReentrantLock();

public Account(int balance)
{
this.balance=balance;	
}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
