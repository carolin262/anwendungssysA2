package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.SmartMeter;
import de.tub.as.smm.models.User;

/**
 * Session Bean implementation class SmartMeterDaoEJB
 */
@Stateless
public class SmartMeterDao {
	


		// Injected database connection:
	    @PersistenceContext private EntityManager em;
	 
	    // Stores a new SmartMeters:
	    public void persist(SmartMeter smartMeter) {
	        em.persist(smartMeter);
	    }
	 
	    // Retrieves all the SmartMeters:
	    public List<SmartMeter> getAllSmartMeters() {
	        TypedQuery<SmartMeter> query = em.createQuery(
	            "SELECT u FROM SmartMeter u ORDER BY u.id", SmartMeter.class);
	        return query.getResultList();
	    }

	
}
