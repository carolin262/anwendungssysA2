package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tub.as.smm.dao.RecordDao;
import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.dao.UserDao;
import de.tub.as.smm.models.Record;
import de.tub.as.smm.models.SmartMeter;
import de.tub.as.smm.models.User;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Injected DAO EJB:
	@EJB
	SmartMeterDao smartmeterDao;
	@EJB
	RecordDao recordDao;
	@EJB
	UserDao userDao;

	/**
	 * display a smart meter with all its properties
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the correct smart meter
		Long smartmeterId = Long.parseLong(request.getParameter("id"));
		SmartMeter smartmeter = smartmeterDao.findSmartmeterById(smartmeterId);
		// generate random values for "Spannung" & "Stom"
		smartmeter.randomSpannung();
		smartmeter.randomStrom();
		// set correct smart meter object as the attribute
		request.setAttribute("smartmeter", smartmeter);

		// check whether user is logged in, if true set user as attribute
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if (user != null) {
			user.setSmartmerterId(smartmeterId);
			request.setAttribute("user", user);
		}

		// display smart meter with all its properties
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	/**
	 * method is called if a new record is created by a logged in user
	 */
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create new "Verbrauchswert" record
		Long smartmeterId = Long.parseLong(request.getParameter("id"));
		SmartMeter smartmeter = smartmeterDao.findSmartmeterById(smartmeterId);
		String user = request.getParameter("user");
		double verbrauchswert = Double.parseDouble(request.getParameter("verbrauchswert"));
		Record record = new Record(smartmeter, user, verbrauchswert);
		recordDao.persist(record);
		smartmeter.getSmartmeterRecords().add(record);

		// display smart meter with all its properties
		doGet(request, response);
	}

}
