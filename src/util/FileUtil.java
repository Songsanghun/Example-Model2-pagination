package util;

import java.util.Scanner;
import java.io.*;

public class FileUtil {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		File file = new File("C:\\Users\\hb2003\\eclipse\\jee-neon\\eclipse\\test.txt"); // \t,
																							// \n,
																							// \\
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // Deco
																					// Patten
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg = "";
			while (true) {
				System.out.println("[메뉴]0.종료 1.쓰기 2.읽기");
				switch (s.next()) {
				case "0":
					writer.close();
					return;
				case "1":
					System.out.println("메세지 입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();  //화장실에서 물 내리는 거 (반드시 꼭 해야한다.)
					break;
				case "2":
					System.out.println("메세지 보기");
					while ((msg=reader.readLine())!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				}
			}
		} catch (IOException e) {   // 반드시 해야한다.

			e.printStackTrace();
		}
	}
}
