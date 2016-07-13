package userdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import model.UserRegisteration;
@Transactional
@Repository
public class UserDaoIm implements userdaoIn{
	List<UserRegisteration> ulist=null;
	
	@Autowired
	userdaoIn mu;
	SessionFactory sf;
	
	public void addUser(UserRegisteration user){
		Session s=sf.getCurrentSession();
		s.save(user);
		s.flush();
	}
public List<UserRegisteration> getUserAll(){
	/*
	 *  Session session = sessionFactory.getCurrentSession();  
		    Query q =session.createQuery("from MyProduct");
		    	prods =(List<MyProduct>)q.list();
		    	return prods;
	 * */
	Session s=sf.getCurrentSession();
	Query q=s.createQuery("from UserRegisteration");
	ulist=(List<UserRegisteration>)q.list();
	return ulist;
	
}
	
	public UserRegisteration checkUser(UserRegisteration user){
		
		/*
		 * System.out.println(user.getUsername()+" "+user.getEmail());
		String result = "";
		Session ss1 = sessionFactory.openSession();
		Query qry = ss1.createQuery("from UserDetails where username=?");
		qry.setParameter(0, user.getUsername());
		List<UserDetails> lst = (List<UserDetails>)qry.list();
		
		for(UserDetails usr : lst)
	    {
	        System.out.println(usr.getUsername()+" "+usr.getEmail());
	    }
		if(lst.size()>0)
			return lst.get(0);
		else
			return null;
		 * */
		System.out.println("");
		Session s=sf.getCurrentSession();
		Query qry=s.createQuery("from UserDetails where username=?");
		qry.setParameter(0, user.getusername());
		List<UserRegisteration> lst=(List<UserRegisteration>) qry.list();
		for(UserRegisteration usr:lst)
		{
			if(usr.getpassword().equals(user.getpassword()))
					{
				
				return user;
					}
			
		}
		return null;
		
	}
		
	}
