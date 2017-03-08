package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	/**
	 * 打开系统方法
	 */
	public static void openSystem(ArrayList<Book>bookList,ArrayList<Teacher> teaList,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		System.out.println("请选择登录方式！"+
		           "\n 输入“1”为管理员登录"+
		           "\n 输入“2”为教师登录"+
		           "\n 输入“3”为学生登录");
        int loginWay = in.nextInt();
        switch(loginWay){
            case 1:AdminFunction.adminLogin(bookList,teaList,stuList);
                   break;
            case 2:TeacherFunction.teaLogin(bookList,teaList);
                   break; 
            case 3:StudentFunction.stuLogin(bookList,stuList);
                   break;
            }
	}
	/**
	 * 关闭系统方法
	 */
	public static void closeSystem(){
		System.out.println("系统已经关闭！");
		System.exit(0);
	}
	



	
	public static void main(String[] args) {
		
		Book book1 = new Book("1","高等数学",4);
		Book book2 = new Book("2","大学英语",4);
		Book book3 = new Book("3","大学体育",4);
		Book book4 = new Book("4","大学政治",4);
		ArrayList<Book> bookList = new ArrayList<Book>();
		BookArray.addBook(book1,bookList);
		BookArray.addBook(book2,bookList);
		BookArray.addBook(book3,bookList);
		BookArray.addBook(book4,bookList);
		
		Student stu1 = new Student("覃大创",20,"男","15050018","1234567890");
		Student stu2 = new Student("颜诗垚",20,"男","15050001","1234567890");
        ArrayList<Student> stuList = new ArrayList<Student>();
		StudentArray.addStudent(stu1,stuList);
		StudentArray.addStudent(stu2,stuList);

		Teacher tea1 = new Teacher("王老师",40,"男","15050018","1234567890");
		Teacher tea2 = new Teacher("白老师",50,"女","15050001","1234567890");
		ArrayList<Teacher> teaList = new ArrayList<Teacher>();
		TeacherArray.addTeacher(tea1, teaList);
		TeacherArray.addTeacher(tea2, teaList);
		
		
		System.out.println("是否打开系统？打开请输入“1”，不打开请输入其他！");
		Scanner in = new Scanner(System.in);
		int openSystem = in.nextInt();
		if(openSystem == 1){
			openSystem(bookList,teaList,stuList);
		}else{
			closeSystem();
	    }
	

}
	
}


