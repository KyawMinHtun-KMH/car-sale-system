package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.sql.DataSource;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
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
    public LoginController() {
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
			mode="LOGIN-FORM";
		}
		
		switch (mode) {
		case "LOGIN_FORM":
			loginForm(request,response);
			break;
			
		case "LOGIN":
			login(request,response);
			break;
			
		case "LOGOUT":
			logout(request,response);
			break;

		default:
			loginForm(request,response);
			break;
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		session.invalidate();
		
		loginForm(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		boolean valid=userDAO.isUserValid(email, password);
		
		if(valid) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userDAO.getUserByEmail(email));
			session.setMaxInactiveInterval(3600 * 3);
			
			response.sendRedirect("home");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("Invalid username or password");
		}
		
	}

	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("signin.jsp");
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
