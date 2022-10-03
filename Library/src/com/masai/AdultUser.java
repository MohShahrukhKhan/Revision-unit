package com.masai;

public class AdultUser implements LibraryUser {
	
	public int age;
	public String Booktype;

	public AdultUser(int age, String booktype) {
		super();
		this.age = age;
		Booktype = booktype;
	}

	@Override
	public void registerAccount() {
		String message="Sory, your Age is must Greater then 12 for registerd under an Adult Account";
		if(age>12) {
			message="You have successfully registerd under an Adult Account";
		}
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	@Override
	public void requestBook() {
		// TODO Auto-generated method stub
		String messag="Sorry";
		if(Booktype.equals("Fiction") && age>12) {
			messag="Book issued Sucessfully for 7 days";
		}
		System.out.println(messag);
		
	}

}
