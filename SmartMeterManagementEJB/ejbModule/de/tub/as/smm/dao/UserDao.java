package de.tub.as.smm.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.User;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class UserDao {

	// injected database connection
	@PersistenceContext
	private EntityManager em;

	// store a new user
	public void persist(User user) {
		em.persist(user);
	}
	
	// retrieve all the users
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
		return query.getResultList();
	}

	// retrieve currently logged in user
	public List<User> getLoggedInUser() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.status = TRUE", User.class)
				.setMaxResults(1);
		return query.getResultList();
	}
	
	// find a user 
	public List<User> findUserByName(String name) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name LIKE :userName", User.class)
				.setMaxResults(1).setParameter("userName", name);
		return query.getResultList();
	}

	// set logged in status from true to false
	public void logoutUser(Long userId) {
		em.createQuery("UPDATE User SET status = FALSE WHERE id LIKE :userId")
				.setParameter("userId", userId).executeUpdate();
	}
	
	// set logged in status from false to true
	public void logInUser(Long userId) {
		em.createQuery("UPDATE User SET status = TRUE WHERE id LIKE :userId")
				.setParameter("userId", userId).executeUpdate();
	}
	
	// update last login date
	public void lastLogin(Long userId) {
		em.createQuery("UPDATE User SET lastLogin = :date WHERE id LIKE :userId")
				.setParameter("userId", userId).setParameter("date", new Date(System.currentTimeMillis()))
				.executeUpdate();
	}

}
