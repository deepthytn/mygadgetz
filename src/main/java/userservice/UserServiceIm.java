package userservice;

import model.UserRegisteration;

import userdao.userdaoIn;

public class UserServiceIm implements UserServiceIn{
	userdaoIn us;
public void addUser(UserRegisteration user){
	us.addUser(user);
}
	
	public UserRegisteration checkUser(UserRegisteration user){
		
		return us.checkUser(user);
	}
}
