package mbalcilar.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mbalcilar.northwind.business.abstracts.UserService;
import mbalcilar.northwind.core.dataAccess.UserDao;
import mbalcilar.northwind.core.entities.User;
import mbalcilar.northwind.core.utilities.results.DataResult;
import mbalcilar.northwind.core.utilities.results.Result;
import mbalcilar.northwind.core.utilities.results.SuccessDataResult;
import mbalcilar.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
 	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("user added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"User added");	
	
	}

}
