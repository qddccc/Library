package Library;

public class Book {
	
	String BookId;
	String BookName;
	int BookTotalCount;
	int BookOnshelfCount;
	
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public int getBookTotalCount() {
		return BookTotalCount;
	}
	public void setBookTotalCount(int bookTotalCount) {
		BookTotalCount = bookTotalCount;
	}
	public int getBookOnshelfCount() {
		return BookOnshelfCount;
	}
	public void setBookOnshelfCount(int bookOnshelfCount) {
		BookOnshelfCount = bookOnshelfCount;
	}
	
	public Book(){
	
	}
	public Book(String BookId,String BookName,int BookTotalCount){
		this.BookId = BookId;
		this.BookName = BookName;
		this.BookTotalCount = BookTotalCount;
		this.BookOnshelfCount = BookTotalCount;//新增一本书时，其可借数量等于新增数量
	}
	
	public String toString(){
		return "BookId："+BookId+
			   ",  BookName："+BookName+
			   ",  BookTotalCount："+BookTotalCount+
               ",  BookOnshelfCount："+BookOnshelfCount+"\n";
	}


}
