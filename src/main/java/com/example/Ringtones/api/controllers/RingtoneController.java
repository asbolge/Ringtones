package com.example.Ringtones.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ringtones.business.abstracts.RingtoneService;
import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.ErrorDataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.entities.concretes.Ringtone;

@RestController
@RequestMapping("/api/ringtones")
public class RingtoneController {

	private RingtoneService ringtoneService;
	
	@Autowired
	public RingtoneController(RingtoneService ringtoneService) {
		super();
		this.ringtoneService = ringtoneService;
	}

	@GetMapping("/getall")
	public DataResult<List<Ringtone>> getAll() {
		return this.ringtoneService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Ringtone ringtone) {
		
		return this.ringtoneService.add(ringtone);
	}
	
	@GetMapping("/getByRingtoneName")
	public DataResult<Ringtone> getByRingtoneName(@RequestParam String ringtoneName){
		
		return this.ringtoneService.getByRingtoneName(ringtoneName);
	}
	
	@GetMapping("/getById")
	public DataResult<Ringtone> getById(@RequestParam int ringtoneId){
		
		return this.ringtoneService.getById(ringtoneId);
	}
	
	@GetMapping("/getByRingtoneCategory")
	public DataResult<Ringtone> getByRingtoneCategory(@RequestParam String ringtoneCategory){
		
		return this.ringtoneService.getByRingtoneCategory(ringtoneCategory);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		
		Map<String,String> validationErrors = new HashMap<String,String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());	
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}

	
}
