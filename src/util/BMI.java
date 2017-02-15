package util;
public class BMI {
	public String getBmi(double kg,double cm) {
		double bmi = kg / (cm / 100 * cm / 100);
		String grade = "";
		if (bmi > 30.0) {
			grade = "고도비만";
		} else if (bmi > 25.0) {
			grade = "비만";
		} else if (bmi > 23.0) {
			grade = "과체중";
		} else if (bmi > 18.5) {
			grade = "정상";
		} else {
			grade = "저체중";
		}
		return grade;
	}
}