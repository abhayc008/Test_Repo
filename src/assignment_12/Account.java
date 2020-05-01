package assignment_12;

interface Account 
{
   public void addAccount(Account account);
	   
   public void removeAccount(Account account);
   
   public double getBalance();

   public String getAccountId();
   
   public void deposit(double amount);
   
   public void withdraw(double amount);
   
   public void transfer(double amount, Account fromAccount, Account toAccount);

  
}
