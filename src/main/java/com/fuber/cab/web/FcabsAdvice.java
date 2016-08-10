package com.fuber.cab.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fuber.cab.web.view.Result;

@ControllerAdvice
public class FcabsAdvice {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Result handleException(Exception e) {
		Result result=new Result();
		result.setStatus("Failure");
		result.setError("Failed to add");
		Throwable cause = e.getCause();
		result.setErorMessage(e.getCause().getLocalizedMessage());
		return result;
	}
	
}
