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
		for(Seller obj : list) {
			System.out.println("setor: "+obj);
		}
		//----buscando todos os elementos
		
		System.out.println("teste 3: -> findAll");
		
		Department dep1 = new Department(numberDep,null);
		 list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println("setor: "+obj);
		}
		
	//----insert os elementos
		
		System.out.println("teste 4: -> insert");
		
		 Seller neWseller = new Seller(null,"israel","samuel@com",new Date(),4000.0,dep);
		 sellerDao.insert(neWseller);
		 System.out.println("inserido"+neWseller.getId());
		
		 //--atualizando dados
		 
		 System.out.println("\n=== TEST 5: seller update =====");
			seller = sellerDao.findById(1);
			seller.setName("daniel");
			sellerDao.update(seller);
			System.out.println("Update completed");
		 
			 //--deletando dados
			 
			 System.out.println("\n=== TEST 5: seller deletando =====");
				sellerDao.delete(1);
				
			 
	}
}
