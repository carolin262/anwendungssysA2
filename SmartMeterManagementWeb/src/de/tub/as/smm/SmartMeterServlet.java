package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Display the list of guests:
        request.setAttribute("smartmeter", smartmeterDao.getAllSmartMeters());
        request.getRequestDispatcher("/verwalten.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Handle a new guest:
        String name = request.getParameter("geraetekennung");
        String maxbel = request.getParameter("maxbel");
        if (name != null)
            smartmeterDao.persist(new SmartMeter(name,maxbel));
 
        // Display the list of guests:
        doGet(request, response);
    }
}