package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Product;

public interface ProductDAO {
	// adding product
	public int addProduct(Product product) throws ClassNotFoundException, SQLException;
	// delete product
	public int deleteProduct(int id)throws ClassNotFoundException, SQLException;
	//update product
	public int  updateProduct(int id , String name)throws ClassNotFoundException, SQLException;
	//retrive product
	public List<Product> selectProduct() throws ClassNotFoundException,SQLException;
	
	
	
}
