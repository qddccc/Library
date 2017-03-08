package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherFunction {

	//教师功能类中声明一个ArrayList用于存储教师所借书本
	
	/**
	 * 教师登录方法
	 * @param bookList
	 * @param stuList
	 */
	public static void teaLogin(ArrayList<Book>bookList,ArrayList<Teacher> teaList){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入教工号：");
		String teaId = in.next();
		System.out.println("请输入密码：");
		String teaPassword = in.next();
		Teacher teacher = TeacherArray.peekTeacher(teaId, teaList);
		if(teacher != null){
			if(teaPassword.equals(teacher.getTeaPassword())){
				succLogin(bookList,teacher,teaList);
				return;
			}
			else{
				System.out.println("密码错误，请重新输入！");
				teaLogin(bookList,teaList);
				return;
			}
		}
		else{
			System.out.println("不存在该账号，请重新输入！");
			teaLogin(bookList,teaList);
			return;
		}
	}
	/**
	 * 教师登录成功后的方法
	 * @param bookList
	 * @param student
	 */
	public static void succLogin(ArrayList<Book>bookList,Teacher teacher,ArrayList<Teacher> teaList){
		Scanner in = new Scanner(System.in);
		System.out.println("请选择您接下来的操作\n" +
				"借书请输入“1”；\n" +
				"查看已经借阅的书籍请输入“2”；\n" +
				"还书请输入“3”；\n" +
				"退出系统请输入“4”；");
		int i = in.nextInt();
		
		if(i==1 && teacher.teaHasBorrowBook.size()<teacher.getTeaCanBorrow()){
			System.out.println("请输入要借的书名：");
			String bookName = in.next();
			Book book=BorrowRecord.bookBorrow(bookName, bookList);
			
			if(book != null){
				teacher.getTeaHasBorrowBook().add(book);
				System.out.println("您已经成功借书，现返回控制台！");
				succLogin(bookList,teacher,teaList);
			}else{
				System.out.println("书库中没有您要借的书本，现返回控制台！");
				succLogin(bookList,teacher,teaList);
			}
			
		}
		
		else if(i==1 && teacher.teaHasBorrowBook.size()>=teacher.getTeaCanBorrow()){
			System.out.println("您所借书本数量已经超过限制，您不能借阅书本了，现返回控制开台！");
			succLogin(bookList,teacher,teaList);
		}
		
		else if(i == 2){
			System.out.println("您已经借阅书本数为："+teacher.getTeaHasBorrowBook().size()+"，" +
					"信息如下：\n"+teacher.getTeaHasBorrowBook()+"\n现返回控制台！");
			succLogin(bookList,teacher,teaList);
		}
		
		else if(i == 3){
			System.out.println("请输入您要还的书名：");
			String bookName = in.next();
			Book book= BookArray.peekBook(bookName, teacher.getTeaHasBorrowBook());
			BorrowRecord.bookLent(bookName, teacher.getTeaHasBorrowBook());
			System.out.println(teacher.getTeaHasBorrowBook().remove(book));
			System.out.println("您已经成功还书，现返回控制台！");
			succLogin(bookList,teacher,teaList);
		}
		
		else if(i == 4){
			System.out.println(teacher.getTeaHasBorrowBook()+"\n现返回控制台！");
			Menu.closeSystem();
			return;
		}
	}
}
