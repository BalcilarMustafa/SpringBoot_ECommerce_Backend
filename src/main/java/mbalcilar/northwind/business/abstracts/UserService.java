package mbalcilar.northwind.business.abstracts;

import mbalcilar.northwind.core.entities.User;
import mbalcilar.northwind.core.utilities.results.DataResult;
import mbalcilar.northwind.core.utilities.results.Result;


public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
