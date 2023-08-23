package com.mycompany.exam.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mycompany.exam.domain.User;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u=new User();
        u.setUserId(rs.getInt("user_id"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setEmail(rs.getString("email"));
        u.setProfile(rs.getString("profile"));
        u.setUserName(rs.getString("user_name"));
        u.setRole(rs.getInt("role"));
        u.setLoginStatus(rs.getInt("login_status"));
        u.setPassword(rs.getString("password"));
        return u;
    }    
}
