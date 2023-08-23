package com.mycompany.exam.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.mycompany.exam.domain.User;
import com.mycompany.exam.rm.UserRowMapper;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User save(User u) {
		String  sql = "INSERT INTO users(`user_id`, `email`, `login_status`, `name`, `password`, `phone`, `profile`, `role`, `user_name`)"
				+" VALUES(:user_id, :email, :login_status, :name, :password, :phone, :profile, :role,:user_name)";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("name", u.getName());
		ps.addValue("phone", u.getPhone());
		ps.addValue("email", u.getEmail());
		ps.addValue("user_id", u.getUserId());
		ps.addValue("profile", u.getProfile());
		ps.addValue("password", u.getPassword());
		ps.addValue("role", u.getRole());
		ps.addValue("login_status", u.getLoginStatus());
		ps.addValue("user_name", u.getUserName());
		
//		GeneratedKeyHolder kh = new GeneratedKeyHolder();
//		int id =()(kh.getKey());
		
		npjt.update(sql, ps);
//		u.setUserId(id);
		return u;
	}

	@Override
	public void update(User u) {
		String sql = "UPDATE users SET name=:name,"
				+ "phone=:phone,"
				+ "email=:email,"
				+ "profile=:profile,"
				+ "user_name=:user_name,"
				+ "password=:password,"
				+ "role=:role,"
				+ "login_status=:login_status"
				+ "WHERE user_id=:user_id";
		Map<String,Object> m = new HashMap<String, Object>();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("profile", u.getProfile());       
        m.put("user_name", u.getUserName());       
        m.put("password", u.getPassword());       
        m.put("role", u.getRole());
        m.put("login_status", u.getLoginStatus());
        m.put("user_id", u.getUserId());
        npjt.update(sql, m);

	}

	@Override
	public void delete(Integer uId) {
		String sql = "DELETE FROM users WHERE user_id=?";
		jt.update(sql, uId);

	}

	@Override
	public User findById(Integer uId) {
		String sql = "SELECT * FROM users WHERE user_id = "+uId;
		return jt.queryForObject(sql,new UserRowMapper());
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		return jt.query(sql,new UserRowMapper());
		
	}

	@Override
	public List<User> findByProp(String fielName, Object value) {
		String sql = "SELECT * FROM users WHERE "+fielName+"=?";
         return jt.query(sql, new UserRowMapper(), value);
	}

}
