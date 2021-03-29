package com.shopx.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopx.dao.UserCartDAO;
import com.shopx.model.Game;
import com.shopx.model.User;
import com.shopx.model.UserCart;

@Transactional
@Repository(value = "userCartDAO")
public class UserCartDAOImpl implements UserCartDAO{

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCart(UserCart cart) {
		sessionFactory.getCurrentSession().save(cart);
		return true;
	}

	public boolean deleteCart(int cartId) {
		UserCart uc = new UserCart();
		uc.setCartId(cartId);
		sessionFactory.getCurrentSession().delete(uc);
		return true;
	}

	public List<UserCart> displayCartByUserId(User user) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.UserCart where user_id=:user_id");
		return query.setParameter("user_id", user.getId()).getResultList();
	}

	public UserCart displayUserCartById(int cartId) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.UserCart where cartId= : cartId");
		query.setParameter("cartId", cartId);
		return (UserCart)query.getResultList().get(0);
	}
	
	

}
