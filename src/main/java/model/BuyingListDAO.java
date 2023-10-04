package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BuyingListDAO {
	
private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	
	private ResultSet rs;
	private PreparedStatement pStmt;
	

	public BuyingListDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}


	private void close() {
		if(connection !=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<BuyingList> getAllBuyingList(){
		List<BuyingList> buyingList = new ArrayList<>();
		try {
			connection=dataSource.getConnection();
			stmt= connection.createStatement();
			
			rs = stmt.executeQuery("select * from buyinglist;");
			
			while(rs.next()) {
				buyingList.add(new BuyingList(
						rs.getLong("id"),
						rs.getString("email"),
						rs.getString("model")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return buyingList;
	}
	
	public Integer createBuyingList(BuyingList buyingList) {
		int rowEffected =0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("insert into buyinglist "
					+ "(email,model) "
					+ "values(?,?); ");
			pStmt.setString(1, buyingList.getEmail());
			pStmt.setString(2, buyingList.getModel());
			
			
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	
	

}
