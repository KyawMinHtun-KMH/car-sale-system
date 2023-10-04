package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import model.Car;
import model.CarDAO;


import model.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class ToyotaController
 */
@MultipartConfig
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/motorcar")
	private DataSource dataSource;

	private CarDAO carDAO;

	@Override
	public void init() throws ServletException {
		carDAO = new CarDAO(dataSource);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		User user =(User) session.getAttribute("user");
		if(user ==null) {
			response.sendRedirect("login");
		}else {
		String mode = request.getParameter("mode");
		if (mode == null) {
			mode = "TOYOTA_LIST";
		}
		switch (mode) {
		case "TOYOTA_LIST":
			showCar(request, response);
			break;
			
		case "SHOW_FORM":
			showCarForm(request, response);
			break;
			
		case "CREATE":
			createCar(request, response);
			break;
			
		case "LOAD":
			loadCar(request, response);
			break;
			
		case "UPDATE":
			updateCar(request, response);
			break;

		case "DELETE":
			deleteCar(request, response);
			break;

		default:
			break;
		}
		
		}

	}

	private void loadCar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		Car car = carDAO.getCar(id);
		request.setAttribute("car", car);

		RequestDispatcher dispatcher = request.getRequestDispatcher("update-car.jsp");
		dispatcher.forward(request, response);

	}
	
	private void addImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Part file = request.getPart("carImage");

		String fileName = file.getSubmittedFileName();
		String uploadPath = "C:/JavaEEBatch3WS/car_sale/src/main/webapp/carimg/"+fileName;
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();
			byte[] data = new byte[is.available()];

			is.read(data);

			fos.write(data);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				fos.close();
			}
		}
		
	}
	
	private void updateCar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Part file = request.getPart("carImage");

		String fileName = file.getSubmittedFileName();
		String uploadPath = "C:/JavaEEBatch3WS/car_sale/src/main/webapp/carimg/" + fileName;

		FileOutputStream fos = new FileOutputStream(uploadPath);

		InputStream is = file.getInputStream();

		byte[] data = new byte[(is.available())];

		is.read(data);

		fos.write(data);

		fos.close();*/
		addImage(request, response);
		
		
		Long id = Long.parseLong(request.getParameter("id"));
		Part file = request.getPart("carImage");
		String carImage = file.getSubmittedFileName();
		
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String power = request.getParameter("power");
		String topSpeed = request.getParameter("topSpeed");
		Integer stock= Integer.parseInt(request.getParameter("stock"));
		Integer numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
		
		if(carImage.isEmpty()) {
			Car car= carDAO.getCar(id);
			carImage = car.getCarImage();
		}

		Car car = new Car(id, carImage, model, price, power, topSpeed, numberOfSeats,brand,stock);
		int rowEffected = carDAO.updateCar(car);
		PrintWriter out = response.getWriter();
		if (rowEffected > 0) {
			showCar(request, response);
		}else {
			out.print("fail to create");
		}

	}

		private void deleteCar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		System.out.println("delected car id is "+id);
		int rowEffected = carDAO.deleteCar(id);
		if (rowEffected > 0) {
			showCar(request, response);
		}

	}
	

	private void createCar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*Part file = request.getPart("carImage");

		String fileName = file.getSubmittedFileName();
		String uploadPath = "C:/JavaEEBatch3WS/car_sale/src/main/webapp/carimg/" + fileName;

		FileOutputStream fos = new FileOutputStream(uploadPath);

		InputStream is = file.getInputStream();

		byte[] data = new byte[(is.available())];

		is.read(data);

		fos.write(data);

		fos.close();*/

		Boolean isAdd=true;
		Part file=request.getPart("carImage");
		
		String carImage = file.getSubmittedFileName();
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		String power = request.getParameter("power");
		String topSpeed = request.getParameter("topSpeed");
		Integer numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
		Integer stock=Integer.parseInt(request.getParameter("stock"));
		String brand=request.getParameter("brand");
		List<Car> carList = carDAO.getAllCar();
		for(Car car:carList) {
			if(car.getCarImage().equals(carImage)) {
				isAdd=false;
			}
		}
		
		if(isAdd) {
			addImage(request, response);
		int rowEffected = carDAO.createCar(new Car(carImage, model, price, power, topSpeed, numberOfSeats, brand,stock));
		PrintWriter out = response.getWriter();
		if (rowEffected > 0) {

			showCar(request, response);

		} else {
			out.print("fail to create");
		}
		}
		else {
			showCar(request, response);
		}

	}


	private void showCarForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-car.jsp");
		dispatcher.forward(request, response);

	}

	private void showCar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		User user =(User) session.getAttribute("user");
		String brand= request.getParameter("brand");
		
		List<Car> carList = carDAO.getCarsByBrand(brand);
		System.out.println("########Car list lenght is "+carList.size());
		request.setAttribute("carList", carList);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("car.jsp");
		dispatcher.forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
