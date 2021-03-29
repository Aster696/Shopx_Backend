package com.shopx.service;

import java.util.List;

import com.shopx.model.User;
import com.shopx.model.UserCart;

public interface UserCartService {

	public boolean addCart(UserCart cart);
	public boolean deleteCart(int cartId);
	public List<UserCart> displayCartByUserId(User user);
	public UserCart displayUserCartById(int cartId);
	
}
