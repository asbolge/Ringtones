package com.example.Ringtones.business.abstracts;

import java.util.List;

import com.example.Ringtones.core.entities.User;
import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	Result findByEmail(String email);
	
	Result findByUsernameAndPassword(String username, String password);
	
	Result registration(User user);
	
	Result checkUserWithMail(String email);
	
	DataResult<List<User>> getAll();
	
	DataResult<User> loginAuth(String username, String password);
	
}
