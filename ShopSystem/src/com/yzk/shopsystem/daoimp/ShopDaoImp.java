package com.yzk.shopsystem.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yzk.shopsystem.dao.ShopDao;
import com.yzk.shopsystem.model.Shop;

public class ShopDaoImp implements ShopDao {
	private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/shopsystem?serverTimezone=UTC";
	private final String userName = "root";
	private final String password = "root";

	@Override
	public List<Shop> selectAll() {
		String sql = "select * from Shop";
		List<Shop> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Shop shop = new Shop(rs.getInt("id"), rs.getString("img"), rs.getString("name"), rs.getString("jg"),
						rs.getString("xl"), rs.getString("kd"),rs.getString("fl"));
				list.add(shop);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
