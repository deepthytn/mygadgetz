package dao;

import java.util.List;


import model.MyProduct;
public interface DaoI {
	public List<MyProduct> getAllproduct();
	public void addproduct(MyProduct p);
	public MyProduct getRowById(int id);
	 public void updateRow(MyProduct p);
	 public void deleterow(MyProduct p);
}
