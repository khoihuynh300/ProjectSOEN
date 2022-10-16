package com.sunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
//		UserDaoImpl userDaoImpl = new UserDaoImpl();
//		String id = userDaoImpl.getUserById(4).getAccountName();
//		System.out.println(id);

//		CartItem cartItem = new CartItem();
//		CartDaoImpl cartDaoImpl = new CartDaoImpl();
//		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
//		cartItem.setCartId(cartDaoImpl.getCartById(1));
//		cartItem.setProductId(productDaoImpl.getProductById(4));
//		CartItemDaoImpl cartItemDaoImpl = new CartItemDaoImpl();
//		CartItem temp = cartItemDaoImpl.existCartItem(cartItem);
//		if (temp != null) {
//			System.out.println(temp.getPrice());
//		}
	}

}