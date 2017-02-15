package controller;

import domain.MemberBean;
import domain.AccountBean;
import service.AccountService;
import serviceImpl.AccountServiceImpl;
import javax.swing.*;

public class CustomerController {
	public void start() {
		MemberBean member= null;
		AccountBean account = null; // null 값은 초기화가 아니라 엄밀히 말하면 null값을 가지고 있는 것이다.
								// 주소지는 있는데 사람이 없는 느낌
		AccountService service = new AccountServiceImpl();
		String ssn = "";
		while (true) { // Tomcat 의 방식을 모방
			/*
			 * int opt = Integer.parseInt(option); // String을 int 로 바꿔주는거 (""를
			 * 벗겨주는거) String opt2 = String.valueOf(opt); // int 를 String 로 바꿔주는거
			 * (""를 씌워주는거)
			 */
			switch (JOptionPane.showInputDialog("0.종료 1.회원등록 2.통장개설 3.입금 4.출금 5.조회 6.해지")) {
			case "0":
				return;
			case "1":
				member= new MemberBean();
				;
				while (true) {
					ssn = JOptionPane.showInputDialog("주민등록 번호: ");
					char ch = ssn.charAt(7);
					if (ch == '0' || ch == '7' || ch == '8' || ch == '9') {
						JOptionPane.showMessageDialog(null, "다시 입력하세요.");
					} else {
						break;
					}
				}
				member.setSsn(ssn);
				member.setId(JOptionPane.showInputDialog("아이디"));
				member.setName(JOptionPane.showInputDialog("이름"));
				JOptionPane.showMessageDialog(null, member.getName() + "님 회원등록 되었습니다.");
				break;
			case "2":
				String uid = "";
				String accountType = "저축예금";
				int money = 0;
				account = service.createAccountBean(uid, accountType, money);
				while (true) {
					uid = JOptionPane.showInputDialog("아이디를 입력하세요.");

					if (member.getId().equals(uid)) {
						break;
					} else {
						JOptionPane.showMessageDialog(null, "아이디를 다시 입력하세요.");
					}
				}
				JOptionPane.showMessageDialog(null, account.toString());
				break;
			case "3":
				JOptionPane.showMessageDialog(null,	service.deposit((Integer.parseInt(JOptionPane.showInputDialog("입금할 금액을 입력해주세요.")))));
				break;
			case "4":
				JOptionPane.showMessageDialog(null,	service.withdraw((Integer.parseInt(JOptionPane.showInputDialog("출금할 금액을 입력해주세요.")))));
				break;
			case "5":
				
				break;
			case "6":
				break;
			}
		}
	}

}
