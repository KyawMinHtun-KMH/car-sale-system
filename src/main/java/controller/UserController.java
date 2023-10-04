package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import model.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.sql.DataSource;





/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/motorcar")
	private DataSource dataSource;
	
	private UserDAO userDAO;
	
	@Override
		public void init() throws ServletException {
			userDAO = new UserDAO(dataSource);
		}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode=request.getParameter("mode");
		
		if(mode == null) {
			mode="REGISTER_FORM";
		}
		
		switch (mode) {
		case "REGISTER_FORM":
			registerForm(request,response);
			break;
			
		case "REGISTER":
			register(request,response);
			break;

		default:
			registerForm(request, response);
			break;
		}
		
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Boolean active=Boolean.parseBoolean(request.getParameter("active"));
		
		Boolean admin=Boolean.parseBoolean(request.getParameter("admin"));
		
		String role=admin ? "ROLE_ADMIN" : "ROLE_USER";
		
		User user= new User(firstname, lastname, email, password, active, role);
		
		int rowEffected=userDAO.register(user);
		PrintWriter out =response.getWriter();
		if(rowEffected > 0) {
			response.sendRedirect("login");
			
		}else {
			out.print("<h1>Fail to register</h1>");
		}
		
	}

	private void registerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher= request.getRequestDispatcher("signup.jsp");
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
