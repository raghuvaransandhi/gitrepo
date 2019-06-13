package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.Common;
import common.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public int saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		int count = 0;
		if(user.getId() == null){
			Connection connection = Common.getConnection();
			try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO student (name,age) VALUES (?,?)");
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			count = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			Connection connection = Common.getConnection();
			try {
			PreparedStatement ps = connection.prepareStatement("update student set name = ?, age = ? where id = ?");
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setInt(3, user.getId());
			count = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		List<User> data =null;
		String SQL_SELECT = "Select * from student";
		Connection conn = Common.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(SQL_SELECT);
			data = new ArrayList<User>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                User user = new User();
                
                user.setId(id);
                user.setName(name);
                user.setAge(age);

                data.add(user);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return data;
	}

	@Override
	public User listUserById(Integer userId) {
		// TODO Auto-generated method stub
		String SQL_SELECT = "Select * from student where id = ?";
		Connection conn = Common.getConnection();
		PreparedStatement preparedStatement;
		User user = null;
		try {
			preparedStatement = conn.prepareStatement(SQL_SELECT);
			preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                user = new User();
                
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                break;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		String SQL_SELECT = "delete from student where id = ?";
		Connection conn = Common.getConnection();
		PreparedStatement preparedStatement;
		int del = 0;
		try {
			preparedStatement = conn.prepareStatement(SQL_SELECT);
			preparedStatement.setInt(1, userId);
			del = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  del;
	}
	
	
}
