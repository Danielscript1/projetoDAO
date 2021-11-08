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
		System.out.println("digite o id -> findById ");
		int id = sc.nextInt();
		Seller seller = sellerDao.findById(id);
		
		System.out.println(seller);
		//testando por departamento
		System.out.println("teste 2: -> find ByDepartment");
		
		System.out.println("informe o numero do departamento: ");
		int numberDep = sc.nextInt();
		Department dep = new Department(numberDep,null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller dep1 : list) {
			System.out.println("setor: "+dep1);
		}
		
		
		
		
		
	}
}
