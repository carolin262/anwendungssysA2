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

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
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
		
		// logout an user if logout is requested and save last logged in date
		session.invalidate();
		Long userId = Long.parseLong(request.getParameter("logout"));
		userDao.lastLogin(userId);
		
		// display "verwalten"
		doGet(request, response);
	}
}
