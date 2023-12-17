package com.example.Ringtones.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.Ringtones.business.abstracts.AdministratorService;
import com.example.Ringtones.core.entities.Administrator;
import com.example.Ringtones.core.entities.User;
import com.example.Ringtones.core.utilities.results.ErrorDataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.entities.concretes.Ringtone;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

	private AdministratorService administratorService;
	
	@Autowired
	public AdministratorController(AdministratorService administratorService) {
		super();
		this.administratorService = administratorService;
	}
	
	@PostMapping("/addAdmin")
	public Result add(@RequestBody Administrator administrator) {
		
		return this.administratorService.add(administrator);
	}
	
	@PostMapping("/addRingtone")
	public Result add(@RequestBody Ringtone ringtone) {
		
		return this.administratorService.add(ringtone);
	}
	
	@PostMapping("/addUser")
	public Result add(@RequestBody User user) {
		
		return this.administratorService.add(user);
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
