
package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.dao.UserDao;
import de.tub.as.smm.models.SmartMeter;
import de.tub.as.smm.models.User;

/**
 * Servlet implementation class SmartMeterServlet
 */
@WebServlet("/verwalten")
public class SmartMeterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Injected DAO EJB:
	@EJB
	SmartMeterDao smartmeterDao;
	@EJB
	UserDao userDao;

	/**
	 * display the list of smart meters
	 */
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set a single user as the attribute if someone is logged in
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			request.setAttribute("user", user);
		}

		// set a list of all smart meters as the attribute
		request.setAttribute("smartmeter", smartmeterDao.getAllSmartMeters());

		// display the list of smart meters
		request.getRequestDispatcher("/verwalten.jsp").forward(request, response);
	}

	/**
	 * method is called if a new smart meter is created 
	 */
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create a new smart meter
		if (request.getParameter("geraetekennung") != null && request.getParameter("maxBelastung") != null) {
			String geraetekennung = request.getParameter("geraetekennung");
			double maxBelastung = Double.parseDouble(request.getParameter("maxBelastung"));
			SmartMeter smartmeter = new SmartMeter(geraetekennung, maxBelastung);
			smartmeterDao.persist(smartmeter);
		}

		// display the list of smart meters
		doGet(request, response);
	}

}