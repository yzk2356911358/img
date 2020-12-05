package com.yzk.shopsystem.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yzk.shopsystem.dao.UserDao;
import com.yzk.shopsystem.model.User;

public class UserDaoImp implements UserDao {
	private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/shopsystem?serverTimezone=UTC";
	private final String userName = "root";
	private final String password = "root";

	@Override
	public int insert(User user) {
		int n = 0;
		String sql = "insert into User values (default,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAddres());
			n = ps.executeUpdate();
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
		return n;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from User where id=?";
		int n = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// ��������
			Class.forName(jdbcDriver);
			// ��ȡ����
			conn = DriverManager.getConnection(url, userName, password);
			// �����Ự
			ps = conn.prepareStatement(sql);
			// ���� ? ��ֵ
			ps.setInt(1, id);
			// ִ��sql
			n = ps.executeUpdate();
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

		return n;
	}

	@Override
	public int update(User user) {
		String sql = "update user set username=?, password=? where id=?";
		int n = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// ��������
			Class.forName(jdbcDriver);
			// ��ȡ����
			conn = DriverManager.getConnection(url, userName, password);
			// �����Ự
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());
			n = ps.executeUpdate();
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
		return n;
	}

	@Override
	public List<User> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(int id) {
		for (User user : selectAll()) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> selectAll() {
		String sql = "select * from User";
		List<User> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// ��������
			Class.forName(jdbcDriver);
			// ��ȡ����
			conn = DriverManager.getConnection(url, userName, password);
			// �����Ự
			ps = conn.prepareStatement(sql);
			// ��ȡ�����
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("gender"),rs.getString("tel"),rs.getString("email"),rs.getString("addres"));
				list.add(user);
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
