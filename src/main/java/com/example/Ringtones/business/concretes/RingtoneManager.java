package com.example.Ringtones.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ringtones.business.abstracts.RingtoneService;
import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.core.utilities.results.SuccessDataResult;
import com.example.Ringtones.core.utilities.results.SuccessResult;
import com.example.Ringtones.dataAccess.RingtoneDao;
import com.example.Ringtones.entities.concretes.Ringtone;

@Service
public class RingtoneManager implements RingtoneService{

	private RingtoneDao ringtoneDao;
	
	@Autowired
	public RingtoneManager(RingtoneDao ringtoneDao) {
		super();
		this.ringtoneDao = ringtoneDao;
	}

	@Override
	public DataResult<List<Ringtone>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Ringtone>>
		(this.ringtoneDao.findAll(), "Data listelendi." );
				
	}

	@Override
	public Result add(Ringtone ringtone) {
		this.ringtoneDao.save(ringtone);
		return new SuccessResult("Zil sesi eklendi.");
	}

	@Override
	public DataResult<Ringtone> getByRingtoneName(String ringtoneName) {
		
		return new SuccessDataResult<Ringtone>
		(this.ringtoneDao.getByRingtoneName(ringtoneName), "Data getirildi.");
	}

	@Override
	public DataResult<Ringtone> getById(int ringtoneId) {
		return new SuccessDataResult<Ringtone>
		(this.ringtoneDao.getById(ringtoneId), "Data getirildi.");
	}

	@Override
	public DataResult<Ringtone> getByRingtoneCategory(String ringtoneCategory) {
		
		return new SuccessDataResult<Ringtone>
		(this.ringtoneDao.getByRingtoneCategory(ringtoneCategory), "Data getirildi.");
	}



}
