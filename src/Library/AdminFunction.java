package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminFunction {

	/**
	 * ����Ա��¼����
	 */
	public static void adminLogin(ArrayList<Book>bookList,ArrayList<Teacher> teaList,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		System.out.println("���������Ա�˺ţ�");
		int adminId = in.nextInt();
		System.out.println("���������Ա���룺");
		int adminPassword = in.nextInt();
		//Ĭ�Ϲ���Ա�˺ź����붼��1234567890
		if(adminId == 1234567890 && adminPassword == 1234567890){
			adminFunction(bookList,teaList,stuList);
		}else{
			System.out.println("�˺�������������µ�¼��");
			adminLogin(bookList,teaList,stuList);
		}
	}
	
	/**
	 * ����Ա��¼�ɹ���ķ���
	 */
	public static void adminFunction(ArrayList<Book>bookList,ArrayList<Teacher> teaList,ArrayList<Student> stuList){
		System.out.println("��ѡ�����!\n" +
				"�鿴����ͼ����Ϣ�������롰1����\n" +
				"�鿴���н�ʦ��Ϣ�������롰2����\n" +
				"�鿴����ѧ����Ϣ�������롰3����\n" +
				"���ͼ�飬�����롰4����\n" +
				"ɾ��ͼ�飬�����롰5����\n" +
				"����ͼ����Ϣ�������롰6����\n" +
				"�鿴ĳ��ͼ����Ϣ�������롰7����\n" +
				"�����������˳�ϵͳ��");
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		if(i == 1){
			System.out.println("���� "+bookList.size()+" ���飬��Ϣ���£�");
			System.out.println(bookList);
			System.out.println("�ַ��ؿ���̨��");
			adminFunction(bookList,teaList,stuList);
			return;
		}else if(i == 2){
			System.out.println("���� "+teaList.size()+" ����ʦ����Ϣ���£�");
			System.out.println(teaList);
			System.out.println("�ַ��ؿ���̨!");
			adminFunction(bookList,teaList,stuList);
			return;
		}else if(i == 3){
			System.out.println("���� "+teaList.size()+" ��ѧ������Ϣ���£�");
			System.out.println(stuList);
			System.out.println("�ַ��ؿ���̨!");
			adminFunction(bookList,teaList,stuList);
			return;
		}else if(i == 4){
			Book book = BookArray.addBook(bookList);
			if(book == null){
				System.out.println("�����Ѿ����ڣ�������ӣ��ַ��ؿ���̨��");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				bookList.add(book);
				System.out.println("�鱾�����ϣ��ַ��ؿ���̨��");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}else if(i == 5){
			System.out.println("������Ҫɾ����������");
			String bookName = in.next();
			boolean temp=BookArray.deleteBook(bookName, bookList);
			if(temp == true){
				System.out.println("�鱾�Ѿ�ɾ�����ַ��ؿ���̨��");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				System.out.println("�鱾�����ڣ�����ɾ�����ַ��ؿ���̨��");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}else if(i == 6){
			System.out.println("������Ҫ���ĵ��鱾��������");
			String bookName = in.next();
			Book book=BookArray.changeBook(bookName, bookList);
			if(book != null){
				System.out.println("�鱾�޸���ϣ��ַ��ؿ���̨��");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				System.out.println("�鱾�����ڣ����ܸ��ģ��ַ��ؿ���̨");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}else if(i == 7){
			System.out.println("������Ҫ��ѯ��������");
			String bookName = in.next();
			Book book = BookArray.peekBook(bookName, bookList);
			if(book != null){
				System.out.println("�鱾��Ϣ���£�\n"+book);
				System.out.println("�ַ��ؿ���̨��");
				adminFunction(bookList,teaList,stuList);
				return;
			}else{
				System.out.println("�鱾�����ڣ��ַ��ؿ���̨��");
				adminFunction(bookList,teaList,stuList);
				return;
			}
		}
		else{
			Menu.closeSystem();
		}
	}

}
