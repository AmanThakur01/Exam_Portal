package com.mycompany.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mycompany.exam.dao.BaseDao;
import com.mycompany.exam.dao.UserDao;
import com.mycompany.exam.domain.User;
import com.mycompany.exam.rm.UserRowMapper;


@Service
public class UserServiceImpl extends BaseDao implements UserService  {

	@Autowired
    private UserDao userDao;
	
	@Override
	public User register(User u) {
		return userDao.save(u);
	}

	@Override
	public User login(String user_name, String password) throws Exception {
		String sql = "SELECT * FROM users WHERE user_name=:un AND password=:pw";
		System.out.println("username "+user_name);
		try {
			MapSqlParameterSource ps = new MapSqlParameterSource();
			ps.addValue("un",user_name);
			ps.addValue("pw",password);
			 return npjt.queryForObject(sql, ps,new UserRowMapper() );
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new Exception("Empty Result Set.Enter valid User!!!");
		}
	}

	@Override
	public void editProfile(User u) {
		userDao.update(u);
	}

	@Override
	public Boolean changeLoginStatus(Integer uId, Integer newStatus) {
		String sql = "UPDATE users SET login_status="+newStatus+" WHERE user_id= "+uId;
		jt.update(sql);
		return true;
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	@Override
	public Boolean bulkDelete(Integer[] uId) {
		String ids = StringUtils.arrayToCommaDelimitedString(uId);
		String sql = "DELETE FROM users WHERE user_id IN("+ids+")";
		jt.update(sql);
		return true;
	}
	
	@Override
	public List<User> search(String txt) {
		String str ="SELECT * FROM users WHERE ( name LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%'  "
				+ "OR email LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR login_name LIKE '%"+txt+"%' OR password LIKE '%"+txt+"%' OR role LIKE '%"+txt+"%' OR login_status LIKE '%"+txt+"%')";
		return jt.query(str, new UserRowMapper());
	}

}
