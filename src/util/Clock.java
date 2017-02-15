package util;
import java.text.SimpleDateFormat;     // text 에 쓸만한건 이거 뿐
import java.util.Date;

public class Clock {
	/*public static void main(String[] args) {
		System.out.println(now());
	}*/
	public String now(){
		return new SimpleDateFormat("yyyy년 MM월 dd a hh : mm : ss").format(new Date());
	}
}
