package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminFunction {

	/**
	 * 管理员登录方法
	 */
	public static void adminLogin(ArrayList<Book>bookList,ArrayList<Teacher> teaList,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入管理员账号：");
		int adminId = in.nextInt();
		System.out.println("请输入管理员密码：");
		int adminPassword = in.nextInt();
		//默认管理员账号和密码都是1234567890
		if(adminId == 1234567890 && adminPassword == 1234567890){
			adminFunction(bookList,teaList,stuList);
		}else{
			System.out.println("账号密码错误，请重新登录！");
			adminLogin(bookList,teaList,stuList);
		}
	}
	
	/**
	 * 管理员登录成功后的方法
	 */
	public static void adminFunction(ArrayList<Book>bookList,ArrayList<Teacher> teaList,ArrayList<Student> stuList){
		System.out.println("请选择操作!\n" +
				"查看所有图书信息，请输入“1”；\n" +
				"查看所有教师信息，请输入“2”；\n" +
				"查看所有学生信息，请输入“3”；\n" +
				"添加图书，请输入“4”；\n" +
				"删除图书，请输入“5”；\n" +
				"更改图书信息，请输入“6”；\n" +
				"查看某本图书信息，请输入“7”；\n" +
				"输入其它则退出系统！");
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		if(i == 1){
			System.out.println("共有 "+bookList.size()+" 本书，信息如下：");
			System.out.println(bookList);
			System.out.println("现返回控制台！");
			adminFunction(bookList,teaList,stuList);
			return;
		}else if(i == 2){
			System.out.println("共有 "+teaList.size()+" 名教师，信息如下：");
			System.out.println(teaList);
			System.out.println("现返回控制台!");
			adminFunction(bookList,teaList,stuList);
			return;
		}else if(i == 3){
			System.out.println("共有 "+teaList.size()+" 名学生，信息如下：");
			System.out.println(stuList);
			System.out.println("现返回控制台!");
			adminFunction(bookList,teaList,stuList);
			return;
		}else if(i == 4){
			Book book = BookArray.addBook(bookList);
			if(book == null){
				System.out.println("本书已经存在，不能添加，现返回控制台！");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				bookList.add(book);
				System.out.println("书本添加完毕，现返回控制台！");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}else if(i == 5){
			System.out.println("请输入要删除的书名：");
			String bookName = in.next();
			boolean temp=BookArray.deleteBook(bookName, bookList);
			if(temp == true){
				System.out.println("书本已经删除，现返回控制台！");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				System.out.println("书本不存在，不能删除，现返回控制台！");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}else if(i == 6){
			System.out.println("请输入要更改的书本的书名：");
			String bookName = in.next();
			Book book=BookArray.changeBook(bookName, bookList);
			if(book != null){
				System.out.println("书本修改完毕，现返回控制台！");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				System.out.println("书本不存在，不能更改，现返回控制台");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}else if(i == 7){
			System.out.println("请输入要查询的书名：");
			String bookName = in.next();
			Book book = BookArray.peekBook(bookName, bookList);
			if(book != null){
				System.out.println("书本信息如下：\n"+book);
				System.out.println("现返回控制台！");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				System.out.println("书本不存在，现返回控制台！");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}
		else{
			Menu.closeSystem();
		}
	}

}
