package com.yzk.shopsystem.dao;

import java.util.List;

import com.yzk.shopsystem.model.Shop;

public interface ShopDao {
	List<Shop> selectAll();
}
