package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class Hello {
	int iv = 10; // �ν��Ͻ� ����
	static int cv = 20; //static ���� 
	@RequestMapping("/hello")
	private void main() { // �ν��Ͻ� �޼��� => iv,cv �Ѵ� ��� ���� public ��� private�� ��� ����. ȣ���� �ȴ�. ������? requestmapping-> �޼���ܺ� ȣ�� �����ϰ� �ϴµ� ���ο��� 
			System.out.println("Hello");
	
	}
	
	public static void main2() { //static �޼��� cv�� ��밡��.  
		System.out.println(cv);  //ok 
//		System.out.println(iv); //���� static �޼���� �ν��Ͻ� ��� �Ұ� 
	}

}
