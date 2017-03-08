package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentArray {
	
	/**
	 * 添加学生
	 * @param student
	 * @param stuList
	 * @return
	 */
	public static boolean addStudent(Student student,ArrayList<Student> stuList){
	
		Student tempStudent = peekStudent(student.getStuId(),stuList);
		if(tempStudent != null && tempStudent.getStuId() == student.getStuId()){
			System.out.println("该学生已经存在，不能添加！");
			return false;
		}
		else{
			stuList.add(student);
			return true;
		}
		
	}
	
	/**
	 * 删除学生
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
	 * 修改学生信息，可以修改姓名、年龄、密码
	 * @param stuId
	 * @param stuList
	 * @return
	 */
	public static Student changeStudent(String stuId,ArrayList<Student> stuList){
		Scanner in = new Scanner(System.in);
		for(int i=0;i<stuList.size();i++){
			if(stuId.endsWith(stuList.get(i).getStuId())){
				System.out.println("可以修改的项目有：姓名、年龄、密码。");
				
				System.out.println("请输入您修改后的姓名：");
				String newName = in.next();
				if(newName != null){
					stuList.get(i).setSex(newName);
				}
				
				System.out.println("请输入您修改后的年龄：");
				int newAge = in.nextInt();
				if(newAge>0){
					stuList.get(i).setAge(newAge);
				}
				
				System.out.println("请输入您要修改的密码：");
				String newPassword = in.next();
				if(newPassword != null){
					stuList.get(i).setStuPassword(newPassword);
				}
				
				System.out.println("修改后的信息为：");
	            return stuList.get(i);
			}
		}
		return null;
	}
	public static Student changeStudent(Student student){
		Scanner in = new Scanner(System.in);
		
				System.out.println("可以修改的项目有：姓名、年龄、密码。");
				
				System.out.println("请输入您修改后的姓名：");
				String newName = in.next();
				if(newName != null){
					student.setName(newName);
				}
				
				System.out.println("请输入您修改后的年龄：");
				int newAge = in.nextInt();
				if(newAge>0){
					student.setAge(newAge);
				}
				
				System.out.println("请输入您要修改的密码：");
				String newPassword = in.next();
				if(newPassword != null){
					student.setStuPassword(newPassword);
				}
		return student;
	}
	/**
	 * 查找学生，如果查找到了返回该学生
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
	 * 显示所有学生信息
	 * @param stuList
	 */
	public static void showAllStudent(ArrayList<Student> stuList){
		for(int i=0;i<stuList.size();i++){
			System.out.println(stuList.get(i));
		}
	}
	
	/*public static void main(String[] args) {
		//String name,int age,String sex,String stuId,String stuPassword
		Student stu1 = new Student("覃大创",20,"男","15050018","1234567890");
		Student stu2 = new Student("颜诗垚",20,"男","15050001","1234567890");
		
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
