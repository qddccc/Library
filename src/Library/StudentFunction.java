package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentFunction {
	//学生功能类中声明一个ArrayList用于存储学生所借书本
	
	/**
	 * 学生登录方法
	 * @param bookList
	 * @param stuList
	 */
	public static void stuLogin(ArrayList<Book>bookList,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入学号：");
		String stuId = in.next();
		System.out.println("请输入密码：");
		String stuPassword = in.next();
		Student student = StudentArray.peekStudent(stuId, stuList);
		if(student != null){
			if(stuPassword.equals(student.getStuPassword())){
				succLogin(bookList,student,stuList);
				return;
			}
			else{
				System.out.println("密码错误，请重新输入！");
				stuLogin(bookList,stuList);
				return;
			}
		}
		else{
			System.out.println("不存在该账号，请重新输入！");
			stuLogin(bookList,stuList);
			return;
		}
	}
	/**
	 * 学生登录成功后的方法
	 * @param bookList
	 * @param student
	 */
	public static void succLogin(ArrayList<Book>bookList,Student student,ArrayList<Student> stuArray){
		Scanner in = new Scanner(System.in);
		System.out.println("请选择您接下来的操作\n" +
				"借书请输入“1”；\n" +
				"查看已经借阅的书籍请输入“2”；\n" +
				"还书请输入“3”；\n" +
				"更改信息请输入“4”；\n" +
				"退出系统请输入其他；");
		int i = in.nextInt();
		
		if(i==1 && student.stuHasBorrowBook.size()<student.getStuCanBorrow()){
			System.out.println("请输入要借的书名：");
			String bookName = in.next();
			Book book=BorrowRecord.bookBorrow(bookName, bookList);
			
			if(book != null){
				student.getStuHasBorrowBook().add(book);
				System.out.println("您已经成功借书，现返回控制台！");
				succLogin(bookList,student,stuArray);
				return;
			}else{
				System.out.println("书库中没有您要借的书本，现返回控制台！");
				succLogin(bookList,student,stuArray);
				return;
			}
			
		}
		
		else if(i==1 && student.stuHasBorrowBook.size()>=student.getStuCanBorrow()){
			System.out.println("您所借书本数量已经超过限制，您不能借阅书本了，现返回控制开台！");
			succLogin(bookList,student,stuArray);
			return;
		}
		
		else if(i == 2){
			System.out.println("您已经借阅书本数为："+student.getStuHasBorrowBook().size()+"，" +
					"信息如下：\n"+student.getStuHasBorrowBook()+"\n现返回控制台！");
			succLogin(bookList,student,stuArray);
			return;
		}
		
		else if(i == 3){
			System.out.println("请输入您要还的书名：");
			String bookName = in.next();
			Book book= BookArray.peekBook(bookName, student.getStuHasBorrowBook());
			BorrowRecord.bookLent(bookName, student.getStuHasBorrowBook());
			if(student.getStuHasBorrowBook().remove(book)){
				System.out.println("您已经成功还书，现返回控制台！");
			}else{
				System.out.println("您没有借阅这本书！");
			}
			
			succLogin(bookList,student,stuArray);
			return;
		}
		else if(i == 4){
			
			StudentArray.changeStudent(student);
			System.out.println("成功修改，更改后信息如下：");
			System.out.println(student);
			System.out.println("现返回控制台！");
			succLogin(bookList,student,stuArray);
			return;
		}
		else{
			
			Menu.closeSystem();
			return;
		}
	}
}
