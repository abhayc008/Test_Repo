package multithreading;

import java.util.Scanner;

public class Bank
{
	int balance = 30000;
	public synchronized void  deposit( ) throws InterruptedException 
	{
		int amt;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Balance before deposit:" +balance);
		System.out.println("Enter the amount to deposit: ");
		amt = scanner.nextInt();
		Thread.sleep(1000);
		balance += amt;
		Thread.sleep(1000);
		System.out.println("Balance after deposit : "+balance);

	}
	public synchronized void withdraw( ) throws InterruptedException 
	{
		int amt;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Balance before withdrawal:" +balance);
		System.out.println("Enter the amount to withdraw: ");
		amt = scanner.nextInt();
		Thread.sleep(1000);
		balance -= amt;
		Thread.sleep(1000);
		System.out.println("Balance after withdrawal : "+balance);

	}

}
