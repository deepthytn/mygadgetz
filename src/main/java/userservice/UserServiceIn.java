package userservice;

import model.UserRegisteration;

public interface UserServiceIn {
public void addUser(UserRegisteration user);
	
	public UserRegisteration checkUser(UserRegisteration user);
}
