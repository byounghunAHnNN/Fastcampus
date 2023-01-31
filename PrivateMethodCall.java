package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception{ //throws Exception 예외처리 
		Hello hello = new Hello();
	//	hello.main(); // private이라 외부 호출이 불가한다.
		
		// Reflection  API를 사용해 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공.
		// java.lang.reflect패키지를 제공  
		// Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체 ) 를 얻어온다. 
		Class helloClass = Class.forName("com.fastcompus.ch2.Hello"); //class는 설계도라 객체를 만들수 있다.
		Hello hello1 = (Hello)helloClass.newInstance(); //Class객체가 가진 정보로 객체 생성 
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main( )을 호출가능하게 한다.
		
		main.invoke(hello); //hello.main()
	}
}
