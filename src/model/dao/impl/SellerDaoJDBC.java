package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	Connection conn = null; //instancia  de conexão
	PreparedStatement st = null;  // instancia de execucao de comando sql
	
	
	
	@Override
	public void insert(Seller obj) {
		
		
		try {
			conn = DB.getConnection();//instabelecendo a conexão
			conn.setAutoCommit(false);//todos confirmaçõs vão ficar pedentes de uma confimação
			//query execuçaõ de consultar
			
			st = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId)"
					     + " VALUES ?,?,?,?,? ");
			conn.commit();//confirmação do commit
			//inserindo os dados
			st.setString(1, "obj");
			st.setString(2, "obj");
			st.setDate(3, null);
			st.setDouble(4, 0);
			st.setInt(5,0 );
			
			
		}catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Erro de transação! não concluida");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DB.closeStatement(st);//fechando minha conexão de comando sql
			
			
		}
	}

	@Override
	public void update(Seller obj) {
		
		
	}

	@Override
	public void delete(Integer id) {
		
		
	}

	@Override
	public Seller findById(Integer id) {
		
		return null;
	}

	@Override
	public List<Seller> findAll() {
		
		return null;
	}
	
}
