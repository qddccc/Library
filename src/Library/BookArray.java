package Library;

import java.util.ArrayList;
import java.util.Scanner;



public class BookArray {
	
	
	/**
	 * 增
	 * @param book
	 * @param bookList
	 * @return
	 */
	public static boolean addBook(Book book,ArrayList<Book> bookList){
		Book tempBook = peekBook(book.getBookName(),bookList);
		if(tempBook != null && tempBook.getBookId() == book.getBookId()){
			System.out.println("这本书已经存在，不能添加！");
			return false;
		}else{
			bookList.add(book);
			return true;
		}
	}
	
	/**
	 * 删
	 * @param bookName
	 * @param bookList
	 * @return
	 */
	public static boolean deleteBook(String bookName,ArrayList<Book> bookList){
		int i;
		for(i=0;i<bookList.size();i++){
			if(bookName.equals((bookList.get(i)).getBookName())){
				bookList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 改
	 * @param bookName
	 * @param bookList
	 * @return
	 */
	public static Book changeBook(String bookName,ArrayList<Book> bookList){
		Scanner in = new Scanner(System.in);
		int i;
		for(i=0;i<bookList.size();i++){
			if(bookName.equals((bookList.get(i)).getBookName())){
				System.out.println("只能修改Id、书名、数量！");
				System.out.println("请输入您修改后的Id：");
				String newId = in.next();
				if(newId != null)
					(bookList.get(i)).setBookId(newId);
				
				System.out.println("请输入修改后的书名：");
				String newName = in.next();
				if(newName != null)
					(bookList.get(i)).setBookName(newName);
				
				System.out.println("请输入修改后书本总共数量：");
				int newCount = in.nextInt();
				if(newCount>0)
					(bookList.get(i)).setBookTotalCount(newCount);
				
				
				return (bookList.get(i));
				
			}
		}
		
		return null;
		
	}
	
	/**
	 * 查
	 * @param bookName
	 * @param bookList
	 * @return
	 */
	public static Book peekBook(String bookName,ArrayList<Book> bookList){
		int i;
		for(i=0;i<bookList.size();i++){
			if(bookName.equals((bookList.get(i)).getBookName())){
				return bookList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 手动添加书本
	 */
	public static Book addBook(ArrayList<Book> bookList){
		
		Scanner in = new Scanner(System.in);
		Book book = new Book();
		
		System.out.println("请输入要添加的书本Id:");
		String bookId = in.next();
		book.setBookId(bookId);
		
		System.out.println("请输入要添加的书本名字：");
		String bookName = in.next();
		book.setBookName(bookName);
		
		System.out.println("请输入添加的数量：");
		int BookTotalCount = in.nextInt();
		book.setBookTotalCount(BookTotalCount);
		book.setBookOnshelfCount(BookTotalCount);
		
		if(peekBook(bookName,bookList)!=null){
			return null;
		}
		return book;
		
	}
	
    /**
     * 查看所有书本
     */
	public ArrayList<Book> showAllBook(ArrayList<Book> bookList){
		return bookList;
	}
	
	/**
	 * 简单测试Book和BookArray类
	 * @param args
	 */
	/*public static void main(String[] args) {
		
		Book book1 = new Book("1","高等数学",2);
		Book book2 = new Book("2","大学英语",2);
		Book book3 = new Book("3","大学体育",2);
		Book book4 = new Book("4","大学政治",2);
		
		ArrayList bookList = new ArrayList();
		
		System.out.println(addBook(book1,bookList));
		System.out.println(addBook(book2,bookList));
		System.out.println(addBook(book3,bookList));
		System.out.println(addBook(book4,bookList));
		
		System.out.println(peekBook("高等数学",bookList));
		System.out.println(deleteBook("高等数学",bookList));
		System.out.println(peekBook("高等数学",bookList));
		System.out.println(changeBook("大学英语",bookList));
		System.out.println(book1);
		System.out.println("");

	}*/

}
