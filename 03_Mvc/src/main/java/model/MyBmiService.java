package model;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class MyBmiService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("height"));
		double height = Double.parseDouble(opt1.orElse("1"));
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("weight"));
		double weight = Double.parseDouble(opt2.orElse("0"));
		
//		String heightStr = request.getParameter("height");
//		String weightStr = request.getParameter("weight");
//		double height = heightStr.equals("")? 0 : Double.parseDouble(heightStr);
//		double weight = weightStr.equals("")? 0 : Double.parseDouble(weightStr);
		
		double bmi = weight / ((height/100) * (height/100));
		String health = bmi < 20? "저체중" : bmi < 25? "정상" : "비만";
		request.setAttribute("bmi", health);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("view/output.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

}
