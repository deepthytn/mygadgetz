package daoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.MyProduct;
import dao.DaoI;

@Service
@Transactional
public class DaoServiceIm implements DaoIServ{

	@Autowired
	DaoI ds;
	public List<MyProduct> getAll()
	{
		
	return	ds.getAllproduct();
	}
	public void addproduct(MyProduct p)
	{
		ds.addproduct(p);
	}
	public MyProduct getRowById(int id){
		MyProduct p=	ds.getRowById(id);
		return p;
	}
	public void updateRow(MyProduct p){
		
		ds.updateRow(p);
	
	}
	 public void deleterow(MyProduct p){
		 ds.deleterow(p);
	 }
}
