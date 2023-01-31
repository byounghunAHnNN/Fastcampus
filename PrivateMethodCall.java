package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception{ //throws Exception ����ó�� 
		Hello hello = new Hello();
	//	hello.main(); // private�̶� �ܺ� ȣ���� �Ұ��Ѵ�.
		
		// Reflection  API�� ����� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����.
		// java.lang.reflect��Ű���� ����  
		// HelloŬ������ Class��ü(Ŭ������ ������ ��� �ִ� ��ü ) �� ���´�. 
		Class helloClass = Class.forName("com.fastcompus.ch2.Hello"); //class�� ���赵�� ��ü�� ����� �ִ�.
		Hello hello1 = (Hello)helloClass.newInstance(); //Class��ü�� ���� ������ ��ü ���� 
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private�� main( )�� ȣ�Ⱑ���ϰ� �Ѵ�.
		
		main.invoke(hello); //hello.main()
	}
}
