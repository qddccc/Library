package Library;

import java.util.ArrayList;
import java.util.Scanner;



public class BookArray {
	
	
	/**
	 * ��
	 * @param book
	 * @param bookList
	 * @return
	 */
	public static boolean addBook(Book book,ArrayList<Book> bookList){
		Book tempBook = peekBook(book.getBookName(),bookList);
		if(tempBook != null && tempBook.getBookId() == book.getBookId()){
			System.out.println("�Ȿ���Ѿ����ڣ�������ӣ�");
			return false;
		}else{
			bookList.add(book);
			return true;
		}
	}
	
	/**
	 * ɾ
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
	 * ��
	 * @param bookName
	 * @param bookList
	 * @return
	 */
	public static Book changeBook(String bookName,ArrayList<Book> bookList){
		Scanner in = new Scanner(System.in);
		int i;
		for(i=0;i<bookList.size();i++){
			if(bookName.equals((bookList.get(i)).getBookName())){
				System.out.println("ֻ���޸�Id��������������");
				System.out.println("���������޸ĺ��Id��");
				String newId = in.next();
				if(newId != null)
					(bookList.get(i)).setBookId(newId);
				
				System.out.println("�������޸ĺ��������");
				String newName = in.next();
				if(newName != null)
					(bookList.get(i)).setBookName(newName);
				
				System.out.println("�������޸ĺ��鱾�ܹ�������");
				int newCount = in.nextInt();
				if(newCount>0)
					(bookList.get(i)).setBookTotalCount(newCount);
				
				
				return (bookList.get(i));
				
			}
		}
		
		return null;
		
	}
	
	/**
	 * ��
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
	 * �ֶ�����鱾
	 */
	public static Book addBook(ArrayList<Book> bookList){
		
		Scanner in = new Scanner(System.in);
		Book book = new Book();
		
		System.out.println("������Ҫ��ӵ��鱾Id:");
		String bookId = in.next();
		book.setBookId(bookId);
		
		System.out.println("������Ҫ��ӵ��鱾���֣�");
		String bookName = in.next();
		book.setBookName(bookName);
		
		System.out.println("��������ӵ�������");
		int BookTotalCount = in.nextInt();
		book.setBookTotalCount(BookTotalCount);
		book.setBookOnshelfCount(BookTotalCount);
		
		if(peekBook(bookName,bookList)!=null){
			return null;
		}
		return book;
		
	}
	
    /**
     * �鿴�����鱾
     */
	public ArrayList<Book> showAllBook(ArrayList<Book> bookList){
		return bookList;
	}
	
	/**
	 * �򵥲���Book��BookArray��
	 * @param args
	 */
	/*public static void main(String[] args) {
		
		Book book1 = new Book("1","�ߵ���ѧ",2);
		Book book2 = new Book("2","��ѧӢ��",2);
		Book book3 = new Book("3","��ѧ����",2);
		Book book4 = new Book("4","��ѧ����",2);
		
		ArrayList bookList = new ArrayList();
		
		System.out.println(addBook(book1,bookList));
		System.out.println(addBook(book2,bookList));
		System.out.println(addBook(book3,bookList));
		System.out.println(addBook(book4,bookList));
		
		System.out.println(peekBook("�ߵ���ѧ",bookList));
		System.out.println(deleteBook("�ߵ���ѧ",bookList));
		System.out.println(peekBook("�ߵ���ѧ",bookList));
		System.out.println(changeBook("��ѧӢ��",bookList));
		System.out.println(book1);
		System.out.println("");

	}*/

}
