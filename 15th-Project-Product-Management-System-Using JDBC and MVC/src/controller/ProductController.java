package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.Product;

public class ProductController {

	Scanner sc = new Scanner(System.in);
	
	public static Connection connection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_"
				+ "management", "root", "root");
		
		return conn;
	}
	
	Product obj = new Product();
	
	public void addProduct() throws Exception
	{	
		System.out.println("Enter Product details:");
//		System.out.println("Enter id:");
//		int id = sc.nextInt();
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter price:");
		float price = sc.nextFloat();
		System.out.println("Enter quantity:");
		int qty = sc.nextInt();
		System.out.println("Enter category:");
		String category = sc.next();
		
		
		//obj.setId(id);
		obj.setName(name);
		obj.setPrice(price);
		obj.setQuantity(qty);
		obj.setCategory(category);
		
		//int id1 = obj.getId();
		String name1 = obj.getName();
		float price1 = obj.getPrice();
		int qty1 = obj.getQuantity();
		String category1 = obj.getCategory();
		
		ProductController.connection();
		// Generate the next ID manually
	    String getMaxIdQuery = "SELECT MAX(id) FROM products"; // Query to get the maximum ID
	    Statement smt = connection().createStatement();
	    ResultSet rs = smt.executeQuery(getMaxIdQuery);

	    int nextId = 1; // Default ID is 1 if the table is empty
	    if (rs.next()) {
	        nextId = rs.getInt(1) + 1; // Increment the maximum ID by 1
	    }
		
		//String sql = "insert into products(id, name, price, quantity, category) values('"+id1+"','"+name1+"', '"+price1+"', '"+qty1+"', '"+category1+"')";
		String sql = "insert into products(id,name, price, quantity, category) values('"+nextId+"','"+name1+"', '"+price1+"', '"+qty1+"', '"+category1+"')";
		
		//Statement smt = connection().createStatement();
		smt.execute(sql);
		
		connection().close();
		smt.close();
		
		System.out.println("Data added successfully!");
	}
	
	public void viewProduct() throws Exception
	{
		ProductController.connection();
		
		String sql = "Select * from products";
		
		Statement smt = connection().createStatement();
		ResultSet rs = smt.executeQuery(sql);
		
		while(rs.next())
		{
			
			System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getFloat(3)+ " " + rs.getInt(4)+ " " + rs.getString(5));
			System.out.println("**************************************");
		}
		
		rs.close();
		smt.close();
		connection().close();
	}
	
	public void updateProduct(int updateID) throws Exception
	{
		//Product obj = new Product();
		ProductController.connection();
		
		String sql = "Select * from products";
		
		Statement smt = connection().createStatement();
		ResultSet rs = smt.executeQuery(sql);
		
		boolean idfound = false;
		while(rs.next())
		{
			if(rs.getInt(1) == updateID)
			{		
				idfound = true;
				boolean b = true;
				
				while(b)
				{
					System.out.println("-----------------------------------------------------------");
					System.out.println("Sub Menus:");
					System.out.println("\t (A) Name\n" + "\t (B) Price\n" + "\t (C) Quantity\n" + "\t (D) Category\n" + "\t (E) Exit" );
					System.out.println("Enter your choice from above menu:");
					String str = sc.next();
					
					String updatename;
					float updateprice;
					int updateqty;
					String updatecategory;
					
			
					switch(str)
					{
					case "A":
						System.out.println("Enter Name to update :");
						updatename = sc.next();
						String sql1 = "UPDATE products SET name = '" + updatename + "' WHERE id = '" + updateID + "'";
						smt.execute(sql1);
						System.out.println("Name updated successfully!!");
						break;
						
					case "B":
						System.out.println("Enter Price to update: ");
						updateprice = sc.nextFloat();
						String sql2 = "UPDATE products SET price = '" + updateprice + "' WHERE id = '" + updateID + "'";
						smt.execute(sql2);
						System.out.println("Price updated successfully!!");
						break;
					
					case "C":
						System.out.println("Enter Quantity to update: ");
						updateqty = sc.nextInt();
						String sql3 = "UPDATE products SET quantity = '" + updateqty + "' WHERE id = '" + updateID + "'";
						
						smt.execute(sql3);
						connection().close();
						smt.close();
						System.out.println("Quantity updated successfully!!");
						break;
						
					case "D":
						System.out.println("Enter Category to update: ");
						updatecategory = sc.next();
						String sql4 = "UPDATE products SET category = '" + updatecategory + "' WHERE id = '" + updateID + "'";
						smt.execute(sql4);
						
						System.out.println("Category updated successfully!!");
						break;
						
					case "E":
						System.out.println("Successfully Exited!");
						b = false;
						break;
					
					default:
						System.out.println("Invalid Input!");
						break;
					}	
					
				}
				connection().close();
				smt.close();
				break;
			}
		}	
		if(!idfound)
		{
			System.out.println("Id is not present!");
		}
	}
	
	public void deleteProduct() throws Exception
	{
		System.out.println("Enter id :");
		int id = sc.nextInt();
		
		ProductController.connection();
		
		String sql = "Select * from products";
		
		Statement smt = connection().createStatement();
		ResultSet rs = smt.executeQuery(sql);
		
		boolean idfound = false;
		
		while(rs.next())
		{
			if(rs.getInt(1) == id)
			{
				idfound = true;
				
				String query = "delete from products where id = '"+id+"'";
				
				smt = connection().createStatement();
				smt.execute(query);
				
				System.out.println("Data deleted successfully!");
				smt.close();
				connection().close();
				
			}
		}
		if(!idfound)
		{
			System.out.println("Id is not present!");
		}
		
		
	}
}
