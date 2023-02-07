package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC5 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	@RequestMapping("/getYoilMVC5") // http://localhost:/ch2/getYoil?year=2021&month=10&day=1
	//public String main(@ModelAttribute("MyDate")MyDate date,  Model model) { // 아래와 동일하다. 
	public String main( MyDate date,  Model model) {
		
		// 1. ModelAndView를 생성
    //	ModelAndView mv = new ModelAndView(); 
    	
		//1. 유효성 검사
		if(!isValid(date))
			return "yoilError";

		// 2. 처리 요일 계산
		//char yoil = getYoil(date);

		// 3.계산한 결과를 model에 저장
		//model.addAttribute("MyDate", date);
		//model.addAttribute("yoil", yoil);
		
		// 4. w작업 결과를 보여줄 view 이름을 반환 
		return "yoil"; // web-inf / views/yoil/jsp
		
	}


	private boolean isValid(MyDate date) {	
		return isValid(date.getYear() ,date.getMonth(), date.getDay());
	}
	
	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear() ,date.getMonth(), date.getDay());
	}
	
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토.".charAt(dayOfWeek);
	}
	
	private boolean isValid(int year, int month, int day) {
		if(year==-1 || month==-1 || day==-1)
		return false;
		
		return (1<=month && month<=12 ) && (1<=day && day<=31); //간단히 체크 
	}
}