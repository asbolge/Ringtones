package com.example.Ringtones.business.concretes;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ringtones.business.abstracts.UserService;
import com.example.Ringtones.core.dataAccess.UserDao;
import com.example.Ringtones.core.entities.User;
import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.ErrorDataResult;
import com.example.Ringtones.core.utilities.results.ErrorResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.core.utilities.results.SuccessDataResult;
import com.example.Ringtones.core.utilities.results.SuccessResult;



@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result findByEmail(String email) {

		if(this.userDao.getByEmail(email).isEmpty()) {
			
			return new ErrorResult("Kullanıcı bulunamadı.");
		}else {
			
			return new SuccessResult("Kullanıcı bul");

		}
		
		
	}

	@Override
	public Result registration(User user) {
		if(checkUserWithMail(user.getEmail()).isSuccess()) {
					add(user);
					return new SuccessResult("Başarıyla kayıt olundu.");
				}else {
					return new ErrorResult("Kaydolma başarısız.");
				}
	}

	@Override
	public Result checkUserWithMail(String email) {
		if(findByEmail(email).isSuccess()) {
			return new ErrorResult("Bu mail zaten kayıtlı.");
		}else {
		return new SuccessResult();
		}
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(), "Data listelendi." );
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		return new SuccessResult("Admin eklendi.");
	}

	@Override
	public DataResult<User> loginAuth(String username, String password) {
		
		if(findByUsernameAndPassword(username, password).isSuccess()) {
			return new SuccessDataResult<User>(this.userDao.findByuserNameAndPassword(username, password), "Giriş işlemi başarılı");
		}else {
		return new ErrorDataResult<User>(this.userDao.findByuserNameAndPassword(username, password),"Hatalı kullanıcı adı veya şifre");
	}
	}

	@Override
	public Result findByUsernameAndPassword(String username, String password) {
		
		if(this.userDao.getByuserName(username).isEmpty() || this.userDao.getByPassword(password).isEmpty()) {
			
			return new ErrorResult("Kullanıcı bulunamadı.");
		}else {
			
			return new SuccessResult("Kullanıcı bulundu.");

		}
	}
	
	
	
	

}
