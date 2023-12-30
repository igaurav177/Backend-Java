package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.DbUtil;
import com.pojo.Product;

public class ProductDAOImpl implements ProductDAO{
	public int addProduct(Product product) throws ClassNotFoundException,SQLException{
		Connection con = DbUtil.dbConn();
		if(con!=null) {
			System.out.println("Connected with db...");
		}
		String sql = "insert into product values(?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product.getPid());
		st.setString(2, product.getPname());
		st.setInt(3,product.getCost());
		return st.executeUpdate();
	}

	@Override
	public int deleteProduct(int id) throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.dbConn();
		if(con!=null) {
			System.out.println("connected with db...");
		}
		String sql = "delete from product where pid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,id);
		return st.executeUpdate();
		
	}

	@Override
	public int updateProduct(int id, String name) throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.dbConn();
		if(con!=null) {
			System.out.println("connected with db...");
		}
		String sql="update product set name=? where pid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,name);
		st.setInt(2, id);
		return st.executeUpdate();
	}

	@Override
	public List<Product> selectProduct() throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.dbConn();
		if(con!=null) {
			System.out.println("connected with db....");
		}
		String sql = "select * from product";
		PreparedStatement st = con.prepareStatement(sql);
		//select we use to st.executeQuerry
		ResultSet rs  = st.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while(rs.next()) {
			Product product = new Product();
			product.setPid(rs.getInt("pid"));
			product.setPname(rs.getString("pname"));
			product.setCost(rs.getInt("pcost"));
			list.add(product);
		}
		
		return list;
	}

}
