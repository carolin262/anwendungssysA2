package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.SmartMeter;

/**
 * Session Bean implementation class SmartMeterDaoEJB
 */
@Stateless
public class SmartMeterDao {

	// injected database connection
	@PersistenceContext
	private EntityManager em;

	// store a new smart meter
	public void persist(SmartMeter smartMeter) {
		em.persist(smartMeter);
	}

	// retrieve all smart meters
	public List<SmartMeter> getAllSmartMeters() {
		TypedQuery<SmartMeter> query = em.createQuery("SELECT u FROM SmartMeter u ORDER BY u.id", SmartMeter.class);
		return query.getResultList();
	}

	public SmartMeter findSmartmeterById(Long smartmeterId) {
		TypedQuery<SmartMeter> query = em
				.createQuery("SELECT u FROM SmartMeter u WHERE u.id LIKE :sId", SmartMeter.class)
				.setParameter("sId", smartmeterId).setMaxResults(1);
		return query.getSingleResult();
	}

}