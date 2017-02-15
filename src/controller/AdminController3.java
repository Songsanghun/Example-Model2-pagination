package controller;

import domain.MemberBean;
import enums.Butt; //여러개 만들어도 된다.
import service.AdminService;
import serviceImpl.AdminServiceImpl;

import javax.swing.*;

public class AdminController3 {
	public void start() {
		MemberBean member = null;
		AdminService service = new AdminServiceImpl(); // 다형성 타입이 다르면 다형성이라고 한다.
														// : 부모꺼를 칭하고 불러오는건 자식.
		int i = 0;
		Butt[] buttens = { Butt.CLOSE, Butt.MEM_ADD, Butt.FIND_BY_ID, Butt.FIND_BY_NAME, Butt.LIST, Butt.RANK,
				Butt.DELETE };
		Butt select = (Butt) JOptionPane.showInputDialog(null, // frame
				"PATTENT PAGE", // frame title
				"SELECT PATIENT MENU", // order
				JOptionPane.QUESTION_MESSAGE, // type
				null, // icon
				buttens, // Array of choices
				buttens[1] // default
		);
		switch (select) {
		case CLOSE:
			return;
		case MEM_ADD:
			member = new MemberBean();
			String[] strArr = JOptionPane.showInputDialog("id,이름").split(",");
			member.setId(strArr[0]);
			member.setName(strArr[1]);
			service.regist(member);
			JOptionPane.showMessageDialog(null, service.count() + "명 등록됨");
			// 현재 회원수는 3명입니다.
			break;
		case FIND_BY_ID:
			String keyword = JOptionPane.showInputDialog("아이디를 입력하세요.");
			if (service.findById(keyword) != null) {
				JOptionPane.showMessageDialog(null, service.findById(keyword).toString());
			} else {
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않음.");
			}
			break;
		case FIND_BY_NAME:
			String temp = JOptionPane.showInputDialog("이름을 입력해주세요.");
			String name = "";
			JOptionPane.showMessageDialog(null, "이름이 존재하지 않음.");
			break;
		case LIST:
			JOptionPane.showMessageDialog(null, "회원이 존재하지 않습니다.");
			break;
		case RANK:
			break;
		case DELETE:
			break;
		}
	}
}
