package com.appmobile.repository;

public interface CartRepository 
{
	ArrayList<Cart> getCarts();
	Cart getCartById(int cartId);
	Cart addCart(Cart cart);
	Cart updateCart(int cartId,Cart cart);

}
