package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentFunction {
	//ѧ��������������һ��ArrayList���ڴ洢ѧ�������鱾
	
	/**
	 * ѧ����¼����
	 * @param bookList
	 * @param stuList
	 */
	public static void stuLogin(ArrayList<Book>bookList,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		System.out.println("������ѧ�ţ�");
		String stuId = in.next();
		System.out.println("���������룺");
		String stuPassword = in.next();
		Student student = StudentArray.peekStudent(stuId, stuList);
		if(student != null){
			if(stuPassword.equals(student.getStuPassword())){
				succLogin(bookList,student,stuList);
				return;
			}
			else{
				System.out.println("����������������룡");
				stuLogin(bookList,stuList);
				return;
			}
		}
		else{
			System.out.println("�����ڸ��˺ţ����������룡");
			stuLogin(bookList,stuList);
			return;
		}
	}
	/**
	 * ѧ����¼�ɹ���ķ���
	 * @param bookList
	 * @param student
	 */
	public static void succLogin(ArrayList<Book>bookList,Student student,ArrayList<Student> stuArray){
		Scanner in = new Scanner(System.in);
		System.out.println("��ѡ�����������Ĳ���\n" +
				"���������롰1����\n" +
				"�鿴�Ѿ����ĵ��鼮�����롰2����\n" +
				"���������롰3����\n" +
				"������Ϣ�����롰4����\n" +
				"�˳�ϵͳ������������");
		int i = in.nextInt();
		
		if(i==1 && student.stuHasBorrowBook.size()<student.getStuCanBorrow()){
			System.out.println("������Ҫ���������");
			String bookName = in.next();
			Book book=BorrowRecord.bookBorrow(bookName, bookList);
			
			if(book != null){
				student.getStuHasBorrowBook().add(book);
				System.out.println("���Ѿ��ɹ����飬�ַ��ؿ���̨��");
				succLogin(bookList,student,stuArray);
				return;
			}else{
				System.out.println("�����û����Ҫ����鱾���ַ��ؿ���̨��");
				succLogin(bookList,student,stuArray);
				return;
			}
			
		}
		
		else if(i==1 && student.stuHasBorrowBook.size()>=student.getStuCanBorrow()){
			System.out.println("�������鱾�����Ѿ��������ƣ������ܽ����鱾�ˣ��ַ��ؿ��ƿ�̨��");
			succLogin(bookList,student,stuArray);
			return;
		}
		
		else if(i == 2){
			System.out.println("���Ѿ������鱾��Ϊ��"+student.getStuHasBorrowBook().size()+"��" +
					"��Ϣ���£�\n"+student.getStuHasBorrowBook()+"\n�ַ��ؿ���̨��");
			succLogin(bookList,student,stuArray);
			return;
		}
		
		else if(i == 3){
			System.out.println("��������Ҫ����������");
			String bookName = in.next();
			Book book= BookArray.peekBook(bookName, student.getStuHasBorrowBook());
			BorrowRecord.bookLent(bookName, student.getStuHasBorrowBook());
			if(student.getStuHasBorrowBook().remove(book)){
				System.out.println("���Ѿ��ɹ����飬�ַ��ؿ���̨��");
			}else{
				System.out.println("��û�н����Ȿ�飡");
			}
			
			succLogin(bookList,student,stuArray);
			return;
		}
		else if(i == 4){
			
			StudentArray.changeStudent(student);
			System.out.println("�ɹ��޸ģ����ĺ���Ϣ���£�");
			System.out.println(student);
			System.out.println("�ַ��ؿ���̨��");
			succLogin(bookList,student,stuArray);
			return;
		}
		else{
			
			Menu.closeSystem();
			return;
		}
	}
}
