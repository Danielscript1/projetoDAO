package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	Connection conn; //instancia  de conexão
	PreparedStatement st = null;  // instancia de execucao de comando sql
	ResultSet rs = null; //instancia de consultar
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//constructor 
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		
		
		try {
			//conn = DB.getConnection();//instabelecendo a conexão
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
		try {
			//conn = DB.getConnection();//instabelecendo a conexão
			conn.setAutoCommit(false);//todos confirmações vão ficar pedentes de uma confimação
			//query execuçaõ de consultar
			
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName"
					+ "FROM seller INNER JOIN department"
					+ "ON seller.DepartmentId = department.Id"
					+ "WHERE seller.Id = ?");
					
			conn.commit();//confirmação do commit
			//recuperando
			//st.setInt(1, rs.getInt(id));
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				
				
			}

			
			
			
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
		return null;
	
	}

	@Override
	public List<Seller> findAll() {
		
		return null;
	}
	
}
