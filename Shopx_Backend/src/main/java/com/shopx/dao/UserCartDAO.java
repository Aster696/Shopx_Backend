package com.shopx.dao;

import java.util.List;

import com.shopx.model.User;
import com.shopx.model.UserCart;

public interface UserCartDAO {

	public boolean addCart(UserCart cart);
	public boolean deleteCart(int cartId);
	public List<UserCart> displayCartByUserId(User user);
	public UserCart displayUserCartById(int cartId);
	
}
