package Library;

import java.util.ArrayList;

public class Teacher extends User{
	
	String teaId;
	String teaPassword;
	int teaCanBorrow = 10;
	int teaHasBorrow;
	
	
	ArrayList<Book> teaHasBorrowBook;//用于存储老师已经借了的书本信息
	
	
	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public String getTeaPassword() {
		return teaPassword;
	}

	public void setTeaPassword(String teaPassword) {
		this.teaPassword = teaPassword;
	}

	public int getTeaCanBorrow() {
		return teaCanBorrow;
	}

	public void setTeaCanBorrow(int teaCanBorrow) {
		this.teaCanBorrow = teaCanBorrow;
	}

	public int getTeaHasBorrow() {
		return teaHasBorrow;
	}

	public void setTeaHasBorrow(int teaHasBorrow) {
		this.teaHasBorrow = teaHasBorrow;
	}



	public ArrayList<Book> getTeaHasBorrowBook() {
		return teaHasBorrowBook;
	}

	public void setTeaHasBorrowBook(ArrayList<Book> teaHasBorrowBook) {
		this.teaHasBorrowBook = teaHasBorrowBook;
	}

	/**
	 * 无参构造器
	 */
    public Teacher(){
    	
    }
    
    /**
     * 有参构造器
     * @param name
     * @param age
     * @param sex
     * @param teaId
     * @param teaPassword
     */
	public Teacher(String name,int age,String sex,String teaId,String teaPassword){
		super(name,age,sex);
		this.teaId = teaId;
		this.teaPassword = teaPassword;
		this.teaHasBorrow = 0;
		teaHasBorrowBook = new ArrayList<Book>();
		
	}
	
	/**
	 * 重写toString()方法
	 */
	public String toString(){
		return super.toString()+"teaId:"+teaId+
		                 "  teaPassword:"+teaPassword+
		                 "  teaCanBorrow:"+teaCanBorrow+
		                 "  teaHasBorrow:"+teaHasBorrow+"\n";
	}



}
