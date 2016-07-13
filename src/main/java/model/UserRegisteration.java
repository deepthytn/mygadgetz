package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UserRegisteration")
public class UserRegisteration {
	@Id
	int id;
String username;
String password;
String role;

public UserRegisteration()
{
	id=0;
	username=null;
	password=null;
	role=null;
}
public UserRegisteration(int id,String pname,String desc,String role)
{
	this.id=id;
	this.username=pname;
	this.password=desc;
	this.role=role;
	
}

public void setId(int id)
{
	this.id=id;
}
public int getId()
{
	return this.id;
}
public void setusername(String pname)
{
	this.username=pname;
}
public String getusername()
{
	return this.username;
}
public void setpassword(String desc)
{
	this.password=desc;
}
public String getpassword()
{
	return this.password;
}
public String getRole(){
	return this.role;
}


@Override
public String toString() {
	return "UserRegisteration[ id="+id+", usernamename="+username+
			",password="+ password+"]";
}

}
