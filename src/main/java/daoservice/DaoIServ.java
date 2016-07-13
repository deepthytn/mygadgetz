package daoservice;

import java.util.List;
import model.MyProduct;

public interface DaoIServ {
	public List<MyProduct> getAll();
	public void addproduct(MyProduct p);
	public MyProduct getRowById(int id);
	public void updateRow(MyProduct p);
	 public void deleterow(MyProduct p);
}
