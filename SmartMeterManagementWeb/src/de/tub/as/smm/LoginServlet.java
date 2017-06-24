package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tub.as.smm.dao.UserDao;
import de.tub.as.smm.models.User;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Injected DAO EJB:
	@EJB
	UserDao userDao;
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// display "verwalten"
		request.getRequestDispatcher("/verwalten").forward(request, response);
	}

	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the current session
		HttpSession session = request.getSession();

		// create or log in an user and set user as session attribute
		String userName = request.getParameter("user");
		if (userDao.findUserByName(userName).size() == 1) {
			User user = userDao.findUserByName(userName).get(0);
			session.setAttribute("user", user);
		} else {
			User user = new User(request.getParameter("user"));
			userDao.persist(user);
			session.setAttribute("user", user);
		}

		// display "verwalten"
		doGet(request, response);
	}
}
