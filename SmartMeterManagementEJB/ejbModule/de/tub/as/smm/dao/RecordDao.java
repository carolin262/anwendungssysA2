package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.Record;

/**
 * Session Bean implementation class RecordDao
 */
@Stateless
public class RecordDao {
	
	// injected database connection
	@PersistenceContext
	private EntityManager em;

	// store a new record
	public void persist(Record record) {
		em.merge(record);
	}

	// retrieve all records
	public List<Record> getAblesungen() {
		TypedQuery<Record> query = em.createQuery("SELECT u FROM Record u ORDER BY u.id DESC", Record.class);
		return query.getResultList();
	}

}
