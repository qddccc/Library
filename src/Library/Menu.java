package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	/**
	 * ��ϵͳ����
	 */
	public static void openSystem(ArrayList<Book>bookList,ArrayList<Teacher> teaList,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		System.out.println("��ѡ���¼��ʽ��"+
		           "\n ���롰1��Ϊ����Ա��¼"+
		           "\n ���롰2��Ϊ��ʦ��¼"+
		           "\n ���롰3��Ϊѧ����¼");
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
	 * �ر�ϵͳ����
	 */
	public static void closeSystem(){
		System.out.println("ϵͳ�Ѿ��رգ�");
		System.exit(0);
	}
	



	
	public static void main(String[] args) {
		
		Book book1 = new Book("1","�ߵ���ѧ",4);
		Book book2 = new Book("2","��ѧӢ��",4);
		Book book3 = new Book("3","��ѧ����",4);
		Book book4 = new Book("4","��ѧ����",4);
		ArrayList<Book> bookList = new ArrayList<Book>();
		BookArray.addBook(book1,bookList);
		BookArray.addBook(book2,bookList);
		BookArray.addBook(book3,bookList);
		BookArray.addBook(book4,bookList);
		
		Student stu1 = new Student("����",20,"��","15050018","1234567890");
		Student stu2 = new Student("��ʫ��",20,"��","15050001","1234567890");
        ArrayList<Student> stuList = new ArrayList<Student>();
		StudentArray.addStudent(stu1,stuList);
		StudentArray.addStudent(stu2,stuList);

		Teacher tea1 = new Teacher("����ʦ",40,"��","15050018","1234567890");
		Teacher tea2 = new Teacher("����ʦ",50,"Ů","15050001","1234567890");
		ArrayList<Teacher> teaList = new ArrayList<Teacher>();
		TeacherArray.addTeacher(tea1, teaList);
		TeacherArray.addTeacher(tea2, teaList);
		
		
		System.out.println("�Ƿ��ϵͳ���������롰1��������������������");
		Scanner in = new Scanner(System.in);
		int openSystem = in.nextInt();
		if(openSystem == 1){
			openSystem(bookList,teaList,stuList);
		}else{
			closeSystem();
	    }
	

}
	
}


