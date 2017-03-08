package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentArray {
	
	/**
	 * ���ѧ��
	 * @param student
	 * @param stuList
	 * @return
	 */
	public static boolean addStudent(Student student,ArrayList<Student> stuList){
	
		Student tempStudent = peekStudent(student.getStuId(),stuList);
		if(tempStudent != null && tempStudent.getStuId() == student.getStuId()){
			System.out.println("��ѧ���Ѿ����ڣ�������ӣ�");
			return false;
		}
		else{
			stuList.add(student);
			return true;
		}
		
	}
	
	/**
	 * ɾ��ѧ��
	 * @param stuName
	 * @param stuList
	 * @return
	 */
	public static boolean deleteStudent(String stuId,ArrayList<Student> stuList){
		for(int i=0;i<stuList.size();i++){
			if(stuId.endsWith(stuList.get(i).getStuId())){
				stuList.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * �޸�ѧ����Ϣ�������޸����������䡢����
	 * @param stuId
	 * @param stuList
	 * @return
	 */
	public static Student changeStudent(String stuId,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		for(int i=0;i<stuList.size();i++){
			if(stuId.endsWith(stuList.get(i).getStuId())){
				System.out.println("�����޸ĵ���Ŀ�У����������䡢���롣");
				
				System.out.println("���������޸ĺ��������");
				String newName = in.next();
				if(newName != null){
					stuList.get(i).setSex(newName);
				}
				
				System.out.println("���������޸ĺ�����䣺");
				int newAge = in.nextInt();
				if(newAge>0){
					stuList.get(i).setAge(newAge);
				}
				
				System.out.println("��������Ҫ�޸ĵ����룺");
				String newPassword = in.next();
				if(newPassword != null){
					stuList.get(i).setStuPassword(newPassword);
				}
				
				System.out.println("�޸ĺ����ϢΪ��");
	            return stuList.get(i);
			}
		}
		return null;
	}
	public static Student changeStudent(Student student){
		Scanner in = new Scanner(System.in);
		
				System.out.println("�����޸ĵ���Ŀ�У����������䡢���롣");
				
				System.out.println("���������޸ĺ��������");
				String newName = in.next();
				if(newName != null){
					student.setName(newName);
				}
				
				System.out.println("���������޸ĺ�����䣺");
				int newAge = in.nextInt();
				if(newAge>0){
					student.setAge(newAge);
				}
				
				System.out.println("��������Ҫ�޸ĵ����룺");
				String newPassword = in.next();
				if(newPassword != null){
					student.setStuPassword(newPassword);
				}
		return student;
	}
	/**
	 * ����ѧ����������ҵ��˷��ظ�ѧ��
	 * @param stuId
	 * @param stuList
	 * @return
	 */
	public static Student peekStudent(String stuId,ArrayList<Student> stuList){
		int i;
		for(i=0;i<stuList.size();i++){
			if(stuId.equals(stuList.get(i).getStuId())){
				return stuList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * ��ʾ����ѧ����Ϣ
	 * @param stuList
	 */
	public static void showAllStudent(ArrayList<Student> stuList){
		for(int i=0;i<stuList.size();i++){
			System.out.println(stuList.get(i));
		}
	}
	
	/*public static void main(String[] args) {
		//String name,int age,String sex,String stuId,String stuPassword
		Student stu1 = new Student("����",20,"��","15050018","1234567890");
		Student stu2 = new Student("��ʫ��",20,"��","15050001","1234567890");
		
		ArrayList stuList = new ArrayList();
		
		System.out.println(addStudent(stu1,stuList));
		System.out.println(addStudent(stu2,stuList));
		System.out.println(deleteStudent("15050001",stuList));
		System.out.println(deleteStudent("15050001",stuList));
		System.out.println(peekStudent("15050018",stuList));
		System.out.println(peekStudent("15050001",stuList));
		System.out.println(peekStudent("15050018",stuList));
		
		System.out.println(changeStudent("15050018",stuList));
		
	}*/

}
