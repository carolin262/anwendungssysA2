package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.models.SmartMeter;

/**
 * Servlet implementation class SmartMeterServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Injected DAO EJB:
	@EJB
	SmartMeterDao smartmeterDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		for (SmartMeter smartmeter : smartmeterDao.getAllSmartMeters()) {
			if (Long.parseLong(request.getParameter("id")) == smartmeter.id) {
				smartmeter.randomSpannung();
				smartmeter.randomStrom();
				request.setAttribute("smartmeter", smartmeter);
			}
		}
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

}
