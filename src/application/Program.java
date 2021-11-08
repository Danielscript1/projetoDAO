package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		//instancia meu obj dao
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("digite o id ");
		int id = sc.nextInt();
		Seller seller = sellerDao.findById(id);
		
		System.out.println(seller);
		
	}
}
