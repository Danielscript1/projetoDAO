package application;

import java.util.Date;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.util.List;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		//instancia meu obj dao
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("digite o id ");
		int id = sc.nextInt();
		Seller seller = sellerDao.findById(id);
		
		System.out.println(seller);
		//insert de dados
		/*
		 * this.id = id;
		this.name = name;
		this.email = email;
		this.bithDate = bithDate;
		this.baseSalary = baseSalary;
		this.department = department;
		 * */
//		for(Seller obj : list) {
//			System.out.println(obj);
//		}
//		
//		System.out.println("inderindo dados: ");
//		Department department = null;
//		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		
		
		
	}
}
