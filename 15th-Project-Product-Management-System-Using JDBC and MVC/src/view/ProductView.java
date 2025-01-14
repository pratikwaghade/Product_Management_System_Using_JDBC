package view;

import java.util.Scanner;

import controller.ProductController;
import model.Product;

public class ProductView {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		ProductController obj = new ProductController();
		
		
		while(true)
		{
			System.out.println("-----------------------------------------------------------");
			System.out.println("*********WELCOME TO THE PRODUCT MANAGEMENT SYSTEM**********");
			System.out.println("Menus:");
			System.out.println("\t 1.Add a product\n"+"\t 2.View all products\n"+"\t 3.Update a product\n"+"\t 4.Delete a product\n"+"\t 5.Exit");
			System.out.println("-----------------------------------------------------------");
			System.out.println("Enter your choice from above menu: ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				obj.addProduct();
				break;
			
			case 2:
				obj.viewProduct();
				break;
				
			case 3:
				System.out.println("Available data in database: ");
				System.out.println();
				obj.viewProduct();
				System.out.println("_________________________________________________________");
				
				System.out.println("Enter id of product to update data:");
				int updateID = sc.nextInt();
				
				obj.updateProduct(updateID);	
				break;
				
			case 4:
				System.out.println("Available data in database: ");
				System.out.println();
				obj.viewProduct();
				System.out.println("_________________________________________________________");
				
				obj.deleteProduct();
				break;
			}
			
		}
	}
}
