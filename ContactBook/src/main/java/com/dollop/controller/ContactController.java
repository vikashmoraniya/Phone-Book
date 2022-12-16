package com.dollop.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dollop.dao.ContactInterface;
import com.dollop.dao.ContactInterfaceImpl;
import com.dollop.dao.UserInterface;
import com.dollop.dao.UserInterfaceImpl;
import com.dollop.model.Contact;
import com.dollop.model.UserLogin;

public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	ContactInterface contactInterface = null;
	UserInterface uifi = null;

	public ContactController() {
		contactInterface = new ContactInterfaceImpl();
		uifi = new UserInterfaceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("action" + action);
		if (action == null) {
			action = "Login";
		}
		switch (action) {

		case "ADD":
			addContact(request, response);
			break;
		case "LIST":
			listContact(request, response);
			break;
		case "EDIT":
			getContact(request, response);
			break;
		case "DELETE":
			deleteContact(request, response);
			break;
		case "LOGIN":
			userLogin(request, response);
			break;
		case "SIGNUP":
			try {
				userSignup(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			listContact(request, response);
			break;

		}
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		if (uifi.loginUser(name,password)) {
			request.setAttribute("NOTIFICATION", "LOGIN Successful");
			System.out.println("login successful!");
			dispatcher = request.getRequestDispatcher("views/contact-form.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("NOTIFICATION","Something want wrong");
			dispatcher = request.getRequestDispatcher("/views/Login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void userSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		UserLogin use = new UserLogin(name,password);
		if (uifi.insertUser(use)) {
			request.setAttribute("NOTIFICATION", "Singup Successful");
			dispatcher = request.getRequestDispatcher("/views/Login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("NOTIFICATION","Something want wrong");
			dispatcher = request.getRequestDispatcher("/views/Signup.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void getContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Contact details = contactInterface.viewContactById(Integer.parseInt(id));
		request.setAttribute("contact", details);
		dispatcher = request.getRequestDispatcher("/views/contact-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		Contact cont = new Contact();

		cont.setName(request.getParameter("name"));
		cont.setEmail(request.getParameter("email"));
		cont.setPhone(request.getParameter("phone"));

		if (id.isEmpty() || id == null) {
			if (contactInterface.createContact(cont)) {
				request.setAttribute("NOTIFICATION", "Contact Saved Successfully*_*");
			}

		} else {
			cont.setId(Integer.parseInt(id));
			if (contactInterface.updateContact(cont)) {
				request.setAttribute("NOTIFICATION", "Employee Update Successfully*_*");

			}
		}
		listContact(request, response);

	}

	private void listContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Contact> theList = contactInterface.viewAllContact();
		request.setAttribute("list", theList);
		dispatcher = request.getRequestDispatcher("/views/contact-list.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		if (contactInterface.deleteContact(id)) {
			request.setAttribute("NOTIFICATION", "Contact Deleted Successfully*_*");
//			dispatcher = request.getRequestDispatcher("/views/contact-list.jsp");
//			dispatcher.forward(request, response);
		}
		listContact(request, response);
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
