package com.shopx.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopx.dao.UserCartDAO;
import com.shopx.model.User;
import com.shopx.model.UserCart;
import com.shopx.service.UserCartService;

@Service
public class UserCartServiceImpl implements UserCartService{

	@Autowired
	UserCartDAO userCartDAO;
	
	public boolean addCart(UserCart cart) {
		userCartDAO.addCart(cart);
		return true;
	}

	public boolean deleteCart(int cartId) {
		userCartDAO.deleteCart(cartId);
		return true;
	}

	public List<UserCart> displayCartByUserId(User user) {
		
		return userCartDAO.displayCartByUserId(user);
	}

	public UserCart displayUserCartById(int cartId) {
		
		return userCartDAO.displayUserCartById(cartId);
	}

}
