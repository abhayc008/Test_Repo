package mini_project;

import java.util.Scanner;

class Book
{

	private int bookId;
	private String authorName;
	private double price;
	private String bookName;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Book(int bookId,String bookName,String authorName, double price ) 
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}

	@Override
	public String toString() 
	{
		return "Book [BookId: " + bookId + ",BookName: " + bookName + ", AuthorName: " + authorName
				+ ",Price:  "+price+"]";
	}
}
public class BookDemo 
{

	public static void main(String[] args)
	{
		int choice,bookId,count=0;
		double price;
		String bookName,authorName;
		Scanner scanner = new Scanner(System.in);
		Book book[] = new Book[10];
		              
        while(true)
        {
    		System.out.println("1.Add book");
    		System.out.println("2.Update book");
    		System.out.println("3.Delete book");
    		System.out.println("4.Search book");
    		System.out.println("5.Show all book");
    		System.out.println("6.Exit");
        	System.out.println("Enter your choice");
            choice = scanner.nextInt();
            switch(choice)
            {
            case 1:
            	System.out.println("Add book");
            	System.out.println("Enter number of books");
            	int noOfBooks;
            	noOfBooks=scanner.nextInt();
            	for(int i=0;i<noOfBooks;i++)
            	{
            		System.out.println("Enter Book Id");
            		bookId = scanner.nextInt();
          
            		
            		System.out.println("Enter Book name");
            		bookName = scanner.next();
            		System.out.println();
            		
            		System.out.println("Enter Author name");
            		authorName = scanner.next();
            		System.out.println();
                    
            		System.out.println("Enter Book price");
            		price = scanner.nextDouble();
            		
            		book[count] = new Book(bookId,bookName,authorName,price);
            		count++;
            	}
            	break;
            case 2:
            	System.out.println("Upadate Book");
            	System.out.println("Enter the BookId for Update");
            	bookId = scanner.nextInt();
            	for(int i=0;i<count;i++)
            	{
            		if(book[i]!=null && book[i].getBookId()==bookId)
                	{
                		System.out.println("Enter the Book name for update ");
                		bookName = scanner.next();
                		book[i].setBookName(bookName);
                		
                		System.out.println("Enter the Author name for update");
                		authorName = scanner.next();
                		book[i].setAuthorName(authorName);
                		
                		System.out.println("Enter the book price");
                		price = scanner.nextDouble();
                		book[i].setPrice(price);
                	}	
            	}
            	System.out.println("Book upadate successfully!!!");
            	break;
            case 3:
            	System.out.println("Delete  Book");
            	System.out.println("Enter the BookId for delete");
            	bookId = scanner.nextInt();
            	for(int i=0;i<count;i++)
            	{
            		if(book[i]!=null && book[i].getBookId()==bookId)
                	{
                      book[i]=null;
                	}	
            	}	
            	System.out.println("Book deleted successfully!!!");
            	break;
            case 4:
            	System.out.println("Search Book");
            	System.out.println("Enter the BookId for Search");
            	bookId = scanner.nextInt();
            	for(int i=0;i<count;i++)
            	{
            		if(book[i]!=null && book[i].getBookId()==bookId)
                	{
                      System.out.println(book[i]);
                	}	
            	}	
            	System.out.println("Search Completed!!!");
            	break;
            case 5:
            	System.out.println("Show all Book");
            	System.out.println("All Book are:");
            	
            	for(int i=0;i<count;i++)
            	{
            		  if(book[i] != null)
            		  {
            			  System.out.println(book[i]);  
            		  }
                }
            	break;
            case 6:
            	System.exit(0);
            default:
            	System.out.println("Please enter valid choice!!!");
            }
        }
	}

}
