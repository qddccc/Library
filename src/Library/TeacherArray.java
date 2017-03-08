package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherArray {
	/**
	 * 添加老师
	 * @param teacher
	 * @param teaList
	 * @return
	 */
	public static boolean addTeacher(Teacher teacher,ArrayList<Teacher> teaList){
		Teacher tempTeacher = peekTeacher(teacher.getTeaId(),teaList);
		if(tempTeacher != null && tempTeacher.getTeaId() == teacher.getTeaId()){
			System.out.println("该教师已经存在，不能添加！");
			return false;
		}
		else{
			teaList.add(teacher);
			return true;
		}
	}
	
	/**
	 * 删除老师
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
	 * 修改老师信息，可以修改姓名、年龄、密码
	 * @param teaId
	 * @param teaList
	 * @return
	 */
	public static Teacher changeStudent(String teaId,ArrayList<Teacher> teaList){
		Scanner in = new Scanner(System.in);
		for(int i=0;i<teaList.size();i++){
			if(teaId.endsWith(teaList.get(i).getTeaId())){
				System.out.println("可以修改的项目有：姓名、年龄、密码。");
				
				System.out.println("请输入您修改后的姓名：");
				String newName = in.next();
				if(newName != null){
					teaList.get(i).setName(newName);
				}
				
				System.out.println("请输入您修改后的年龄：");
				int newAge = in.nextInt();
				if(newAge>0){
					teaList.get(i).setAge(newAge);
				}
				
				System.out.println("请输入您要修改的密码：");
				String newPassword = in.next();
				if(newPassword != null){
					teaList.get(i).setTeaPassword(newPassword);
				}
				
				System.out.println("修改后的信息为：");
	            return teaList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 查找教师，如果查找到了返回该教师
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
	 * 显示所有教师信息
	 * @param teaList
	 */
	public static void showAllTeacher(ArrayList<Teacher> teaList){
		for(int i=0;i<teaList.size();i++){
			System.out.println(teaList.get(i));
		}
	}

}
