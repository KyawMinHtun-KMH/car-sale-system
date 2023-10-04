package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;







public class CarDAO {
	
private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	public CarDAO(DataSource dataSource) {
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
	
	public List<Car> getAllCar(){
		List<Car> carList = new ArrayList<>();
		try {
			connection=dataSource.getConnection();
			stmt= connection.createStatement();
			
			rs = stmt.executeQuery("select * from car;");
			
			while(rs.next()) {
				carList.add(new Car(
						rs.getLong("id"),
						rs.getString("carImage"),
						rs.getString("model"),
						rs.getString("price"),
						rs.getString("power"),
						rs.getString("topSpeed"),
						rs.getInt("numberOfSeats"),
						rs.getString("brand"),
						rs.getInt("stock")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return carList;
	}
	
	public Car getCar(Long id){
		Car car=null;
		try {
			connection=dataSource.getConnection();
			stmt= connection.createStatement();
			
			rs = stmt.executeQuery("select * from car where id = '"+id+"';");
			
			while(rs.next()) {
				car =new Car(
						rs.getLong("id"),
						rs.getString("carImage"),
						rs.getString("model"),
						rs.getString("price"),
						rs.getString("power"),
						rs.getString("topSpeed"),
						rs.getInt("numberOfSeats"),
						rs.getString("brand"),
						rs.getInt("stock")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return car;
	}
	
	public List<Car> getCarsByBrand(String brand){
		List<Car> carBrandList = new ArrayList<>();
		try {
			connection=dataSource.getConnection();
			stmt= connection.createStatement();
			
			rs = stmt.executeQuery("select * from car where brand = '"+brand+"';");
			
			while(rs.next()) {
				carBrandList.add(new Car(
						rs.getLong("id"),
						rs.getString("carImage"),
						rs.getString("model"),
						rs.getString("price"),
						rs.getString("power"),
						rs.getString("topSpeed"),
						rs.getInt("numberOfSeats"),
						rs.getString("brand"),
						rs.getInt("stock")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return carBrandList;
	}
	
	public Integer createCar(Car car) {
		int rowEffected =0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("insert into car "
					+ "(carImage,model,price,power,topSpeed,numberOfSeats,brand,stock) "
					+ "values(?,?,?,?,?,?,?,?); ");
			pStmt.setString(1, car.getCarImage());
			pStmt.setString(2, car.getModel());
			pStmt.setString(3, car.getPrice());
			pStmt.setString(4, car.getPower());
			pStmt.setString(5, car.getTopSpeed());
			pStmt.setInt(6, car.getNumberOfSeats());
			pStmt.setString(7, car.getBrand());
			pStmt.setInt(8, car.getStock());
			
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	
	public int updateCar(Car car) {
		int rowEffected =0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("update car set "
					+ "carImage=?,"
					+ "model= ?,"
					+ "price= ?,"
					+ "power= ?,"
					+ "topSpeed= ?,"
					+ "numberOfSeats= ?,"
					+ "brand= ?,"
					+ "stock=? where id = ?;");
			pStmt.setString(1, car.getCarImage());
			pStmt.setString(2, car.getModel());
			pStmt.setString(3, car.getPrice());
			pStmt.setString(4, car.getPower());
			pStmt.setString(5, car.getTopSpeed());
			pStmt.setInt(6, car.getNumberOfSeats());
			pStmt.setString(7, car.getBrand());
			pStmt.setInt(8, car.getStock());
			pStmt.setLong(9, car.getId());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	
	
	public int deleteCar(Long id) {
		int rowEffected = 0;
		
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("delete from car where id=?;");
			
			pStmt.setLong(1, id);
			
			rowEffected= pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}

	

}
