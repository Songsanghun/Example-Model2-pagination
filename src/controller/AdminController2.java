package controller;

import domain.MemberBean;
import service.AdminService2;
import serviceImpl.AdminServiceImpl2;

import javax.swing.*;

public class AdminController2 {
	public void start() {
		MemberBean member= null;
		AdminService2 service = new AdminServiceImpl2();  //다형성  타입이 다르면 다형성이라고 한다. : 부모꺼를 칭하고 불러오는건 자식.
		String ssn = "";
		int i = 0;
		while (true) { 
			switch (JOptionPane.showInputDialog("0.종료 1.회원등록 2.ID검색 3.이름검색 4.목록조회 5.등급조정 6.삭제")) {
			case "0":
				return;
			case "1": 
				member = new MemberBean();
				String[] strArr = JOptionPane.showInputDialog("id,이름").split(",");
				member.setId(strArr[0]);
				member.setName(strArr[1]);
				service.regist(member);
				JOptionPane.showMessageDialog(null, service.count()+"명 등록됨");
				//현재 회원수는 3명입니다.
				break;
			case "2":
				String keyword = JOptionPane.showInputDialog("아이디를 입력하세요.");
				if(service.exist(keyword)){
					JOptionPane.showMessageDialog(null, service.findById(keyword).toString());
				}else{
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않음.");
				}
				break;
			case "3":
				String temp = JOptionPane.showInputDialog("이름을 입력해주세요.");
				String name = "";
				if(service.countByName(temp)!=0){
					MemberBean[] temparr = service.findByName(temp);
					for(i=0;i<temparr.length;i++){
						name+=temparr[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null, name);
				}else{
					JOptionPane.showMessageDialog(null, "이름이 존재하지 않음.");
				}
				break;
			case "4":
				if(service.count()==0){
					JOptionPane.showMessageDialog(null,"회원이 존재하지 않습니다.");
				}else{
					MemberBean[] arr = service.list();
					String result = "";
					for(;i<service.count();i++){
						result += arr[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null, result);
				}
				break;
			case "5":
				String temp2 = JOptionPane.showInputDialog("ID, RANK");
				String[] tempArr = temp2.split(",");
				member.setId(tempArr[0]);
				member.setRank(tempArr[1]);
				service.changeRank(member);
				break;
			case "6":
				String delete = JOptionPane.showInputDialog("삭제할 아이디를 입력하세요.");
				if(service.exist(delete)){
					service.remove(delete);
					JOptionPane.showMessageDialog(null, "아이디가 삭제되었습니다.");
				}else{
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않음.");
				}
				break;
			}
		}
	}

}
