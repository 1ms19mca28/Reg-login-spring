package services;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.Employee;
import repository.EmployeeDao;
/**
 * Servlet implementation class EmployeeServlet
 */

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  EmployeeDao employee;
	
	
	
	public void init() {
		employee = new  EmployeeDao();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				addEmployee(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			
			default:
				listEmployee(request, response);
				break;	
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = employee.getAllEmployee();
		request.setAttribute("listEmployee",listEmployee );
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeIndex.jsp");
		dispatcher.forward(request, response);
	}


	private void addEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String  contact= request.getParameter("contact");
		Employee newEmployee = new Employee (firstName,lastName,password,address,contact);
		employee.addEmployee(newEmployee);
		response.sendRedirect("list");
	}
	

	private void  updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String  contact= request.getParameter("contact");
		Employee newEmployee = new Employee(id,firstName,lastName,password,address,contact);
		employee.updateEmployee(newEmployee);
		response.sendRedirect("list");
	}
	
	



}