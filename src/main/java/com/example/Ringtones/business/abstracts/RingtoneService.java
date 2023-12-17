package com.example.Ringtones.business.abstracts;

import java.util.List;

import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.entities.concretes.Ringtone;


public interface RingtoneService {

	DataResult<List<Ringtone>> getAll();
	
	Result add(Ringtone ringtone);
	
	DataResult<Ringtone> getByRingtoneName(String ringtoneName);
	
	DataResult<Ringtone> getById(int ringtoneId);
	
	DataResult<Ringtone> getByRingtoneCategory(String ringtoneCategory);
	
}
