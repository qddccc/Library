package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherFunction {

	//��ʦ������������һ��ArrayList���ڴ洢��ʦ�����鱾
	
	/**
	 * ��ʦ��¼����
	 * @param bookList
	 * @param stuList
	 */
	public static void teaLogin(ArrayList<Book>bookList,ArrayList<Teacher> teaList){
		Scanner in = new Scanner(System.in);
		System.out.println("������̹��ţ�");
		String teaId = in.next();
		System.out.println("���������룺");
		String teaPassword = in.next();
		Teacher teacher = TeacherArray.peekTeacher(teaId, teaList);
		if(teacher != null){
			if(teaPassword.equals(teacher.getTeaPassword())){
				succLogin(bookList,teacher,teaList);
				return;
			}
			else{
				System.out.println("����������������룡");
				teaLogin(bookList,teaList);
				return;
			}
		}
		else{
			System.out.println("�����ڸ��˺ţ����������룡");
			teaLogin(bookList,teaList);
			return;
		}
	}
	/**
	 * ��ʦ��¼�ɹ���ķ���
	 * @param bookList
	 * @param student
	 */
	public static void succLogin(ArrayList<Book>bookList,Teacher teacher,ArrayList<Teacher> teaList){
		Scanner in = new Scanner(System.in);
		System.out.println("��ѡ�����������Ĳ���\n" +
				"���������롰1����\n" +
				"�鿴�Ѿ����ĵ��鼮�����롰2����\n" +
				"���������롰3����\n" +
				"�˳�ϵͳ�����롰4����");
		int i = in.nextInt();
		
		if(i==1 && teacher.teaHasBorrowBook.size()<teacher.getTeaCanBorrow()){
			System.out.println("������Ҫ���������");
			String bookName = in.next();
			Book book=BorrowRecord.bookBorrow(bookName, bookList);
			
			if(book != null){
				teacher.getTeaHasBorrowBook().add(book);
				System.out.println("���Ѿ��ɹ����飬�ַ��ؿ���̨��");
				succLogin(bookList,teacher,teaList);
			}else{
				System.out.println("�����û����Ҫ����鱾���ַ��ؿ���̨��");
				succLogin(bookList,teacher,teaList);
			}
			
		}
		
		else if(i==1 && teacher.teaHasBorrowBook.size()>=teacher.getTeaCanBorrow()){
			System.out.println("�������鱾�����Ѿ��������ƣ������ܽ����鱾�ˣ��ַ��ؿ��ƿ�̨��");
			succLogin(bookList,teacher,teaList);
		}
		
		else if(i == 2){
			System.out.println("���Ѿ������鱾��Ϊ��"+teacher.getTeaHasBorrowBook().size()+"��" +
					"��Ϣ���£�\n"+teacher.getTeaHasBorrowBook()+"\n�ַ��ؿ���̨��");
			succLogin(bookList,teacher,teaList);
		}
		
		else if(i == 3){
			System.out.println("��������Ҫ����������");
			String bookName = in.next();
			Book book= BookArray.peekBook(bookName, teacher.getTeaHasBorrowBook());
			BorrowRecord.bookLent(bookName, teacher.getTeaHasBorrowBook());
			System.out.println(teacher.getTeaHasBorrowBook().remove(book));
			System.out.println("���Ѿ��ɹ����飬�ַ��ؿ���̨��");
			succLogin(bookList,teacher,teaList);
		}
		
		else if(i == 4){
			System.out.println(teacher.getTeaHasBorrowBook()+"\n�ַ��ؿ���̨��");
			Menu.closeSystem();
			return;
		}
	}
}
