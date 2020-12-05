package com.yzk.dao;

import java.util.List;

import com.yzk.model.Hotel;

public interface HotelDao {
	List<Hotel> findall();

	Hotel getbyid(int id);

	void del(int id);

	void add(Hotel hotel);

	void up(Hotel hotel);

}
