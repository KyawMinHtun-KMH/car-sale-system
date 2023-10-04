package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.BuyingList;
import model.BuyingListDAO;
import model.Car;
import model.CarDAO;

import model.User;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class BuyingListController
 */
public class BuyingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/motorcar")
	private DataSource dataSource;
	
	private BuyingListDAO buyingListDAO;
	
	private CarDAO carDAO;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		buyingListDAO = new BuyingListDAO(dataSource);
		carDAO= new CarDAO(dataSource);
		
		
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyingListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		User user =(User) session.getAttribute("user");
		if(user ==null) {
			response.sendRedirect("login");
		}else {
		String mode=request.getParameter("mode");
		if(mode== null) {
			mode = "BUYING_LIST";
		}
		switch (mode) {
		
		case "BUYING_LIST":
			showBuyingList(request,response);
			break;
		
		case "CREATE":
			createBuyingList(request,response);
			break;

		default:
			showBuyingList(request,response);
			break;
		}
		}
	}

	private void showBuyingList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BuyingList> buyingList = buyingListDAO.getAllBuyingList();
		request.setAttribute("buyingList", buyingList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("buying-list.jsp");
		dispatcher.forward(request, response);
		
	}

	private void createBuyingList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		User user =(User) session.getAttribute("user");
		String email=user.getEmail();
		String brand = request.getParameter("brand");
		Long id = Long.parseLong(request.getParameter("id"));
		
		
			Car car1 = carDAO.getCar(id);
			String carImage= car1.getCarImage();
			String model = car1.getModel();
			String price = car1.getPrice();
			String power = car1.getPower();
			String topSpeed = car1.getTopSpeed();
			Integer numberOfSeats = car1.getNumberOfSeats();
			Integer stock = car1.getStock();
			Integer decreaseStock=stock-1;
			
			buyingListDAO.createBuyingList(new BuyingList(email, model));
			if(stock==1) {
				carDAO.deleteCar(id);
			}else {
			carDAO.updateCar(new Car(id, carImage, model, price, power, topSpeed, numberOfSeats, brand, decreaseStock));
			}
			
			
			
			//String brand= request.getParameter("brand");
			
			List<Car> car = carDAO.getCarsByBrand(brand);
			request.setAttribute("carList", car);
			RequestDispatcher dispatcher = request.getRequestDispatcher("car.jsp");
			dispatcher.forward(request, response);
			
			
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
