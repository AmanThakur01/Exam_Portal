package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.exam.dao.BaseDao;
import com.exam.dao.UserDao;
import com.exam.domain.User;
import com.exam.rm.UserRowMapper;


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
		String sql = "SELECT * FROM user WHERE user_name=:un AND password=:pw";
		try {
			MapSqlParameterSource ps = new MapSqlParameterSource();
			ps.addValue("un",user_name);
			ps.addValue("pw",password);
			 return npjt.queryForObject(sql, ps,new UserRowMapper() );
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new Exception("Empty Result Set.");
			
		}
	}

	@Override
	public void editProfile(User u) {
		userDao.update(u);
	}

	@Override
	public Boolean changeLoginStatus(Integer uId, Integer newStatus) {
		String sql = "UPDATE user SET loginStatus="+newStatus+" WHERE userId= "+uId;
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
		String sql = "DELETE FROM user WHERE userId IN("+ids+")";
		jt.update(sql);
		return true;
	}
	
	@Override
	public List<User> search(String txt) {
		String str ="SELECT * FROM user WHERE ( name LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%'  "
				+ "OR email LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR loginName LIKE '%"+txt+"%' OR password LIKE '%"+txt+"%' OR role LIKE '%"+txt+"%' OR loginStatus LIKE '%"+txt+"%')";
		return jt.query(str, new UserRowMapper());
	}

}
