package userdao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.UserRegisteration;

public interface userdaoIn {
	
	
public void addUser(UserRegisteration user);
	
	public UserRegisteration checkUser(UserRegisteration user);
}
