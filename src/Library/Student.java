package Library;

import java.util.ArrayList;

public class Student extends User{
	
	String stuId;
	String stuPassword;
	int stuCanBorrow = 2;
	int stuHasBorrowCount;
	ArrayList<Book> stuHasBorrowBook;//���ڴ洢ѧ���Ѿ����˵��鱾��Ϣ
	
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public int getStuCanBorrow() {
		return stuCanBorrow;
	}
	public void setStuCanBorrow(int stuCanBorrow) {
		this.stuCanBorrow = stuCanBorrow;
	}
	public int getStuHasBorrowCount() {
		return stuHasBorrowCount;
	}
	public void setStuHasBorrowCount(int stuHasBorrowCount) {
		this.stuHasBorrowCount = stuHasBorrowCount;
	}
	public ArrayList<Book> getStuHasBorrowBook() {
		return stuHasBorrowBook;
	}
	public void setStuHasBorrowBook(ArrayList<Book> stuHasBorrowBook) {
		this.stuHasBorrowBook = stuHasBorrowBook;
	}

	
	/**
	 * �޲ι�����
	 */
    public Student(){
    	
    }
    
    /**
     * �вι�����
     * @param name
     * @param age
     * @param sex
     * @param stuId
     * @param stuPassword
     */
	public Student(String name,int age,String sex,String stuId,String stuPassword){
		super(name,age,sex);
		this.stuId = stuId;
		this.stuPassword = stuPassword;
		this.stuHasBorrowCount = 0;
		stuHasBorrowBook = new ArrayList<Book>();
	}
	

	/**
	 * ��дtoString()����
	 */
	public String toString(){
		return super.toString()+"stuId:"+stuId+
		                 "  stuPassword:"+stuPassword+
		                 "  stuCanBorrow:"+stuCanBorrow+
		                 "  stuHasBorrow:"+stuHasBorrowCount+"\n";
	}


}
