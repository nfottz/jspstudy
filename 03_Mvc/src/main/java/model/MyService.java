package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyService {
	
	// public, abstract 생략 가능
	public String execute(HttpServletRequest request, HttpServletResponse response);
	
}