package com.shopx.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopx.dao.UserDAO;
import com.shopx.model.User;

@Repository(value = "userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean deleteUser(int id) {
		try {
			User us = new User();
			us.setId(id);
			sessionFactory.getCurrentSession().delete(us);
			System.out.println("Deleted successfully");
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<User> displayUsers() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from com.shopx.model.User").getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public User displayUserByEmail(String email) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.User where email=: email");
			query.setParameter("email", email);
			return (User)query.getResultList().get(0);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public User displayUserById(int id) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.User where id= : id");
			query.setParameter("id", id);
			return (User)query.getResultList().get(0);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public User displayUserByName(String username) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.User where username=: username");
			query.setParameter("username", username);
			return (User)query.getResultList().get(0);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<User> searchUser(String email) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.User where email like: bn");
			return query.setParameter("bn", "%"+email+"%").getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

	public boolean isUsernameExist(String username) {
		
//		Query query = sessionFactory.getCurrentSession().createQuery("form com.shopx.model.User where username=:username");
		User us = displayUserByName(username);
		String user = us.getUsername();
		if (username.equals(user)) {

            return true;
        }
		return false;
	}

}
