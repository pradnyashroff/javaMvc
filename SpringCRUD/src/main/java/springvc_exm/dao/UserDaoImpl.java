package springvc_exm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_exm.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	public List<User> ListAlluser() {
		// TODO Auto-generated method stub
		String sql = "SELECT id, firstname, lastname, address FROM users";
		  
			List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		  
		  return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(User user){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  /*if(user != null){
		   parameterSource.addValue("id", user.getId());
		   parameterSource.addValue("firstname", user.getFirstname());
		   parameterSource.addValue("lastname", user.getLastname());
		   parameterSource.addValue("address", user.getAddress());
		  }*/
		  return parameterSource;
		 }
		 
		 private static final class UserMapper implements RowMapper<User>{

		  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		   User user = new User();
		   user.setId(rs.getInt("id"));
		   user.setFirstname(rs.getString("firstname"));
		   user.setLastname(rs.getString("lastname"));
		   user.setAddress(rs.getString("address"));
		   
		   return user;
		  }
		  
		 }

}
