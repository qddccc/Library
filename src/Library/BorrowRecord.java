package Library;

import java.util.ArrayList;



public class BorrowRecord {
	
	public static Book bookBorrow(String bookName,ArrayList<Book> bookList){
		Book book = BookArray.peekBook(bookName, bookList);//����
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
		Book book1 = new Book("1","�ߵ���ѧ",2);
		Book book2 = new Book("2","��ѧӢ��",2);
		Book book3 = new Book("3","��ѧ����",2);
		Book book4 = new Book("4","��ѧ����",2);
		
		ArrayList bookList = new ArrayList();
		
		BookArray.addBook(book1,bookList);
		BookArray.addBook(book2,bookList);
		BookArray.addBook(book3,bookList);
		BookArray.addBook(book4,bookList);
		
		bookBorrow("�ߵ���ѧ",bookList);
		System.out.println(BookArray.peekBook("�ߵ���ѧ",bookList));
		Student stu1 = new Student("����",20,"��","15050018","1234567890");
		stu1.stuHasBook.add(bookBorrow("�ߵ���ѧ",bookList));
		System.out.println(BookArray.peekBook("�ߵ���ѧ",bookList));
		System.out.println(BookArray.peekBook("�ߵ���ѧ",bookList));
		System.out.println(stu1.stuHasBook);
		//stu1.stuHasBook.add(bookBorrow("�ߵ���ѧ",bookList));
		System.out.println(BookArray.peekBook("�ߵ���ѧ",bookList));
		//stu1.stuHasBook.add(bookBorrow("�ߵ���ѧ",bookList));//������ص���Null,������ӣ�Ӧ��ע��
		stu1.stuHasBook.add(bookBorrow("��ѧӢ��",bookList));
		
		System.out.println(bookBorrow("�ߵ���ѧ",bookList));
		System.out.println(stu1.stuHasBook);
		
	}*/

}
