package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {
//	public static void main(String[] args) {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// 1. 입력 	
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	
	int yyyy = Integer.parseInt(year);
	int mm = Integer.parseInt(month);
	int dd = Integer.parseInt(day);
	
	// 2.작업
	Calendar cal = Calendar.getInstance();
	cal.set(yyyy, mm -1 , dd );
	
	int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //요일 1: 일요일 2: 월요일 
	char yoil = "일월화수목금토".charAt(dayOfweek);
	
	// 3.출력 
	response.setContentType("text/html");
	response.setCharacterEncoding("utf-8");
	PrintWriter out = response.getWriter(); // response 객체에서 브라우져로의 출럭 String을 얻어야 한다.
	out.println(year + "년" + month + "월" + day + "일은 ");
	out.println(yoil + "요일입니다.");
	}
}
