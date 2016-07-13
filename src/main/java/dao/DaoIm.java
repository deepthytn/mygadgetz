package dao;

import java.io.Serializable;
import java.util.List;
import dao.DaoI;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.MyProduct;

@Transactional
@Repository
public class DaoIm implements DaoI{
	List<MyProduct> prods;
	
	 @Autowired
 SessionFactory sessionFactory;

	   public DaoIm(){
		   
	   }
	   public List<MyProduct> getAllproduct() 
	   {
		   
		   Session session = sessionFactory.getCurrentSession();  
		    Query q =session.createQuery("from MyProduct");
		    	prods =(List<MyProduct>)q.list();
		    	return prods;
	   }
	   
	   public void addproduct(MyProduct p)
	   {
		   System.out.println("In save");
			Session s=sessionFactory.getCurrentSession();
			System.out.println("After current");
			s.save(p);
			System.out.println("After Save");		
			s.flush();
	   }
	   public MyProduct getRowById(int id){
		   
		   Session s=sessionFactory.openSession();
		   Transaction trx=s.beginTransaction();
		   
		   MyProduct p=(MyProduct)s.load(MyProduct.class, id);
		  trx.commit();
		  s.close();
		   return p;
		   
	   }
	   
	  
	   public void updateRow(MyProduct p) {
		   Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(p);
	        session.flush();
	   
	   }
	   public void deleterow(MyProduct p)
	   {
		   Session session = sessionFactory.getCurrentSession();
	        session.delete(p);
		   System.out.println("aft del");
		   session.flush();
		   
	   }

}
