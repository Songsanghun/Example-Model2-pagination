package util;

public class RandomGenerator {
	public static int getRandomNum(int a, int b){
		/*
		  int max = 0, min = 0 , h = 0;
		  h = (a>b)?(int)(Math.random()*(a - b + 1)+b):(int)(Math.random()*(b - a + 1)+a);
		if(a>b){
			max=a; min=b;
		}else{
			max=b; min=a; 
		}
		return h;
		*/
		return (a>b)?(int)(Math.random()*(a - b + 1)+b):(int)(Math.random()*(b - a + 1)+a);
	}
	
}
