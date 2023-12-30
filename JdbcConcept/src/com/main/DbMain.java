package com.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dao.ProductDAOImpl;
import com.pojo.Product;

public class DbMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		ProductDAOImpl dao=null;
		Product product = null;
		while(true) {
			System.out.println("Menu \n1.add Product \n2.delete product \n3.update product \n4.retrive product \n5.exit");
			System.out.println("enter the choice : ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1: product = new Product();
			System.out.println("Enter product id");
			product.setPid(sc.nextInt());
			System.out.println("enter product name");
			product.setPname(sc.next()+sc.nextLine());
			System.out.println("enter product cost");
			product.setCost(sc.nextInt());
			dao = new ProductDAOImpl();
			if(dao.addProduct(product)>0) {
				System.out.println("product got inserted with details "+product);
			}
			break;
			case 2: 
				product = new Product();
				System.out.println("Enter product id: ");
				int id = sc.nextInt();
				dao = new ProductDAOImpl();
				if(dao.deleteProduct(id)>0) {
					System.out.println(id+"Product Id got deleted...");
				}
				break;
			case 3: 
				dao = new ProductDAOImpl();
				System.out.println("Enter id where you want to update: ");
				int Id =sc.nextInt();
				System.out.println("Enter name : ");
				String name =sc.next()+sc.nextLine();
					if(dao.updateProduct(Id,name)>0) {
						System.out.println("Product got updated with details");
					}
					break;
			case 4: 
				dao = new ProductDAOImpl();
				List<Product> productlist = dao.selectProduct();
				for(Product products:productlist) {
					System.out.println(products);
				}
				
				break;
			case 5: System.exit(0);
			break;
			}

		}

	}
}
