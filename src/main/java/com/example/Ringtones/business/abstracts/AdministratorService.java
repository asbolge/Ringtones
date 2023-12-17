package com.example.Ringtones.business.abstracts;

import com.example.Ringtones.core.entities.Administrator;
import com.example.Ringtones.core.entities.User;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.entities.concretes.Ringtone;

public interface AdministratorService {

	Result add(Administrator administrator);
	
	Result add(Ringtone ringtone);
	
	Result add(User user);
	
}
