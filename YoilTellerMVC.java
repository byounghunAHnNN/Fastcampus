package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC { // http://localhost/ch2/getYoilMVC?year=2024&month=03&day=12
	//	public static void main(String[] args) {
	@RequestMapping("/getYoilMVC")
	//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {

	public ModelAndView main(int year, int month, int day ) throws IOException {

		ModelAndView mv = new ModelAndView();

		// 1.유효성 검사
		//	if(!isValid(year, month, day))
		//	return "yoilError";


		// 1. 입력 	
		//	String year = request.getParameter("year");
		//	String month = request.getParameter("month");
		//	String day = request.getParameter("day");

		//	int yyyy = Integer.parseInt(year);
		//	int mm = Integer.parseInt(month);
		//	int dd = Integer.parseInt(day);

		// 2.작업
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);

		// 3. 계산한 결과를 model에 저장.
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);

		//	return "yoil"; // WEB-INF/views/yoil,jsp 부분 보여줘라. 

		//4. 결과를 보여줄 view를 지정
		mv.setViewName("yoil");

		return mv;

	}

	private boolean isValid(int year, int month, int day) { // class안에서만 사용해서 private로 사용 

		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1 , day );

		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //요일 1: 일요일 2: 월요일 
		return "일월화수목금토".charAt(dayOfweek);
	}
}
