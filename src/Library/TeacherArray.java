package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherArray {
	/**
	 * �����ʦ
	 * @param teacher
	 * @param teaList
	 * @return
	 */
	public static boolean addTeacher(Teacher teacher,ArrayList<Teacher> teaList){
		Teacher tempTeacher = peekTeacher(teacher.getTeaId(),teaList);
		if(tempTeacher != null && tempTeacher.getTeaId() == teacher.getTeaId()){
			System.out.println("�ý�ʦ�Ѿ����ڣ�������ӣ�");
			return false;
		}
		else{
			teaList.add(teacher);
			return true;
		}
	}
	
	/**
	 * ɾ����ʦ
	 * @param teaName
	 * @param teaList
	 * @return
	 */
	public static boolean deleteTeacher(String teaId,ArrayList<Teacher> teaList){
		for(int i=0;i<teaList.size();i++){
			if(teaId.endsWith(teaList.get(i).getTeaId())){
				teaList.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * �޸���ʦ��Ϣ�������޸����������䡢����
	 * @param teaId
	 * @param teaList
	 * @return
	 */
	public static Teacher changeStudent(String teaId,ArrayList<Teacher> teaList){
		Scanner in = new Scanner(System.in);
		for(int i=0;i<teaList.size();i++){
			if(teaId.endsWith(teaList.get(i).getTeaId())){
				System.out.println("�����޸ĵ���Ŀ�У����������䡢���롣");
				
				System.out.println("���������޸ĺ��������");
				String newName = in.next();
				if(newName != null){
					teaList.get(i).setName(newName);
				}
				
				System.out.println("���������޸ĺ�����䣺");
				int newAge = in.nextInt();
				if(newAge>0){
					teaList.get(i).setAge(newAge);
				}
				
				System.out.println("��������Ҫ�޸ĵ����룺");
				String newPassword = in.next();
				if(newPassword != null){
					teaList.get(i).setTeaPassword(newPassword);
				}
				
				System.out.println("�޸ĺ����ϢΪ��");
	            return teaList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * ���ҽ�ʦ��������ҵ��˷��ظý�ʦ
	 * @param teaId
	 * @param teaList
	 * @return
	 */
	public static Teacher peekTeacher(String teaId,ArrayList<Teacher> teaList){
		int i;
		for(i=0;i<teaList.size();i++){
			if(teaId.equals(teaList.get(i).getTeaId())){
				return teaList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * ��ʾ���н�ʦ��Ϣ
	 * @param teaList
	 */
	public static void showAllTeacher(ArrayList<Teacher> teaList){
		for(int i=0;i<teaList.size();i++){
			System.out.println(teaList.get(i));
		}
	}

}
