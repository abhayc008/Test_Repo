package small_project;
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
