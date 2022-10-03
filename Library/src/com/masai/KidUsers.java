package com.masai;

public class KidUsers implements LibraryUser{
	public int age;
	public String Booktype;
	
	
	@Override
	public void registerAccount() {
		// TODO Auto-generated method stub
		String message="Sory, your Age is must less then 12 for registerd under an Adult Account";
		if(age<12) {
			message="You have successfully registerd under an kids Account";
		}
		// TODO Auto-generated method stub
		System.out.println(message);
	}
	@Override
	public void requestBook() {
		// TODO Auto-generated method stub
		String messag="Sorry";
		if(Booktype.equals("Kids") && age<12) {
			messag="Book issued Sucessfully for 10 days";
		}
		System.out.println(messag);
		
	}
	public KidUsers(int age, String booktype) {
		super();
		this.age = age;
		Booktype = booktype;
	}


}
