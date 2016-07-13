package userdao;

import model.UserRegisteration;

public interface UserRegService {
public void addUser(UserRegisteration user);
	
	public UserRegisteration checkUser(UserRegisteration user);
}
