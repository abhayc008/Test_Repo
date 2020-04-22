package multithreading;

class User
{
	int balance = 30000;
	public synchronized void  deposit(int amt)  
	{
		System.out.println("Balance before deposit:" +balance);
		System.out.println("Enter the amount to deposit: "+amt);
		balance += amt;
		System.out.println("Balance after deposit : "+balance);
		notify();

	}
	public synchronized void withdraw(int amt)
	{
		System.out.println("Balance before withdrawal:" +balance);
        if(amt>balance)
        {
        	System.out.println("Waiting for deposit......");
        }
        try {
			wait(3000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        balance-=amt;
		System.out.println("Balance after withdrawal : "+balance);

	}
}

public class InterThreadCommunication {

	public static void main(String[] args)
	{
		User user = new User();
		
		new Thread()
		{
			@Override
			public void run() {
				user.withdraw(50000);
			}
			
		}.start();

		new Thread()
		{
			@Override
			public void run() {
				user.deposit(10000);
			}
		}.start();
	}

}
