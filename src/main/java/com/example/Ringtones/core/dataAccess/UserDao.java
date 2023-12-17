package com.example.Ringtones.core.dataAccess;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Ringtones.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
	List<User> getByEmail(String email);
	
	List<User>getByuserName(String username);
	
	List<User> getByPassword(String password);
	
	User findByuserNameAndPassword(String userName, String password);
}

