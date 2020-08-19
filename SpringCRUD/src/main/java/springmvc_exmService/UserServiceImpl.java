package springmvc_exmService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import springmvc_exm.model.User;
import springvc_exm.dao.UserDao;

public class UserServiceImpl implements UserService{

	UserDao userdao;
	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public List<User> ListAlluser() {
		// TODO Auto-generated method stub
		return userdao.ListAlluser();
	}

}
