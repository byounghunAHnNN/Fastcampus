package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; //static 변수 
	@RequestMapping("/hello")
	private void main() { // 인스턴스 메서드 => iv,cv 둘다 사용 가능 public 대신 private도 사용 가능. 호출이 된다. 이유는? requestmapping-> 메서드외부 호출 가능하게 하는데 내부에서 
			System.out.println("Hello");
	
	}
	
	public static void main2() { //static 메서드 cv만 사용가능.  
		System.out.println(cv);  //ok 
//		System.out.println(iv); //에러 static 메서드는 인스턴스 사용 불가 
	}

}
