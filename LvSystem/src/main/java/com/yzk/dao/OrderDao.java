package com.yzk.dao;

import java.util.List;

import com.yzk.model.Order;
import com.yzk.model.User;

public interface OrderDao {
	List<Order> findall();

	User getbyid(int id);

	void del(int id);

	void add(Order order);

	void up(Order Order);

}
