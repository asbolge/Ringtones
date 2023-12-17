package com.example.Ringtones.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ringtones.business.abstracts.AdministratorService;
import com.example.Ringtones.core.dataAccess.AdministratorDao;
import com.example.Ringtones.core.dataAccess.UserDao;
import com.example.Ringtones.core.entities.Administrator;
import com.example.Ringtones.core.entities.User;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.core.utilities.results.SuccessResult;
import com.example.Ringtones.dataAccess.RingtoneDao;
import com.example.Ringtones.entities.concretes.Ringtone;

@Service
public class AdministratorManager implements AdministratorService{

	private AdministratorDao administratorDao;
	private RingtoneDao ringtoneDao;
	private UserDao userDao;
	
	@Autowired
	public AdministratorManager(AdministratorDao administratorDao, RingtoneDao ringtoneDao, UserDao userDao) {
		super();
		this.administratorDao = administratorDao;
		this.ringtoneDao = ringtoneDao;
		this.userDao = userDao;
	}
	
	@Override
	public Result add(Administrator administrator) {
		// TODO Auto-generated method stub
		this.administratorDao.save(administrator);
		return new SuccessResult("Administrator eklendi.");
	}

	@Override
	public Result add(Ringtone ringtone) {
		this.ringtoneDao.save(ringtone);
		return new SuccessResult("Zil sesi eklendi.");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}
	
	

}
