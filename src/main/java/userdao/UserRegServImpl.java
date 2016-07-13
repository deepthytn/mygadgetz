package userdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import model.UserRegisteration;
import userdao.userdaoIn;

@Service
@Transactional
public class UserRegServImpl {
	
	@Autowired
	userdaoIn us;
	
public void addUser(UserRegisteration user){
	
	us.addUser(user);
	
	
}
	
	public UserRegisteration checkUser(UserRegisteration user){
		return us.checkUser(user);
	
	}
}
