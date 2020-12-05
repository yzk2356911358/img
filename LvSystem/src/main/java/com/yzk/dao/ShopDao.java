package com.yzk.dao;

import java.util.List;

import com.yzk.model.Shop;

public interface ShopDao {
	List<Shop> findall();

	Shop getbyid(int id);

	void del(int id);

	void add(Shop shop);

	void up(Shop shop);

}
