package Library;

import java.util.ArrayList;



public class BorrowRecord {
	
	public static Book bookBorrow(String bookName,ArrayList<Book> bookList){
		Book book = BookArray.peekBook(bookName, bookList);//引用
		if(book != null &&  book.getBookOnshelfCount()>0){
			book.setBookOnshelfCount(book.getBookOnshelfCount()-1);
			return book;
		}
		return null;
	}
	
	public static Book bookLent(String bookName,ArrayList<Book> bookList){
		Book book = BookArray.peekBook(bookName, bookList);
		if(book != null){
			book.setBookOnshelfCount(book.getBookOnshelfCount()+1);
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		Book book1 = new Book("1","高等数学",2);
		Book book2 = new Book("2","大学英语",2);
		Book book3 = new Book("3","大学体育",2);
		Book book4 = new Book("4","大学政治",2);
		
		ArrayList bookList = new ArrayList();
		
		BookArray.addBook(book1,bookList);
		BookArray.addBook(book2,bookList);
		BookArray.addBook(book3,bookList);
		BookArray.addBook(book4,bookList);
		
		bookBorrow("高等数学",bookList);
		System.out.println(BookArray.peekBook("高等数学",bookList));
		Student stu1 = new Student("覃大创",20,"男","15050018","1234567890");
		stu1.stuHasBook.add(bookBorrow("高等数学",bookList));
		System.out.println(BookArray.peekBook("高等数学",bookList));
		System.out.println(BookArray.peekBook("高等数学",bookList));
		System.out.println(stu1.stuHasBook);
		//stu1.stuHasBook.add(bookBorrow("高等数学",bookList));
		System.out.println(BookArray.peekBook("高等数学",bookList));
		//stu1.stuHasBook.add(bookBorrow("高等数学",bookList));//如果返回的是Null,则不能添加，应该注意
		stu1.stuHasBook.add(bookBorrow("大学英语",bookList));
		
		System.out.println(bookBorrow("高等数学",bookList));
		System.out.println(stu1.stuHasBook);
		
	}*/

}
