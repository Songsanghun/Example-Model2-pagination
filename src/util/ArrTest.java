package util;
import java.util.*;
public class ArrTest {
	public static void main(String[] args) {
		String[] arr ={"a","b","c","d"};
		Set<String> t = new HashSet<String>();
		for(String s:arr){
			t.add(s);
		}
		System.out.println(t.toString());
	}
}
