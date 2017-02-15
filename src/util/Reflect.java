package util;
import java.lang.reflect.*;
import java.util.*;
public class Reflect {
	public static void main(String[] args) {
		try {
			Class klass = Class.forName("domain.DatabaseBean"); //Shallow copy klass 인스턴스에 담아두는거.
			
			//Class.forName("domain.DatabaseBean");       		
			//setter의미로 쓸수있다. Class.forName에 set되고 있는 느낌을 알아야 한다.
			
			Method[] arr = klass.getDeclaredMethods();  // method 의 수가 fix되어있기 때문에 자료구조를 []로 짠것
			
			Set<String> set = new HashSet<String>();
			for(Method m:arr){
				set.add(m.getName());    //m <--치고 일단 .을 쳐라
			}
			System.out.println(set.toString());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}
