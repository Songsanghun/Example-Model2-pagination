package util;

import javax.swing.JOptionPane;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import enums.ButtMumber;
import service.MemberService;
import serviceImpl.MemberServiceImpl;

public class DAOTest {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberDAO dao = new MemberDAOImpl();
		MemberBean member;
		ButtMumber[] ButtMumberons ={ButtMumber.CLOSE,ButtMumber.MEM_ADD,ButtMumber.FIND_BY_ID,ButtMumber.LOGIN,ButtMumber.LIST,ButtMumber.RANK,ButtMumber.DELETE};
		while(true){
			ButtMumber select=(ButtMumber)JOptionPane.showInputDialog(
					null, //frame
					"ADMIN PAGE", //frame title
					"SELECT ADMIN MENU", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					ButtMumberons, //Array of choices
					ButtMumberons[1] //default
					);
		switch(select){
		case CLOSE: JOptionPane.showConfirmDialog(null, "EXIT OK??"); return;
		case MEM_ADD:
			member = new MemberBean();
			String[] memberarr = JOptionPane.showInputDialog("아이디, 이름, 주민등록번호, 비밀번호, 프로필사진, 휴대폰번호, 이메일").split(" ");
			member.setId(memberarr[0]);
			member.setName(memberarr[1]);
			member.setSsn(memberarr[2]);
			member.setPassword(memberarr[3]);
			member.setProfileImg(memberarr[4]);
			member.setPhone(memberarr[5]);
			member.setEmail(memberarr[6]);
			try {
				service.join(member); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case FIND_BY_ID:
			member = new MemberBean();
			try {
				member = service.findById(JOptionPane.showInputDialog("아이디를 입력하세요."));
			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "회원정보: "+member.toString());
			break;
		case LOGIN:
			member = new MemberBean();
			break;
		case LIST:
			member = new MemberBean();
			try {
				member = service.findById(JOptionPane.showInputDialog("아이디를 입력하세요."));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			String[] memberarr1 = JOptionPane.showInputDialog("aaa",member).split(",");
			member.setId(memberarr1[0]);
			member.setName(memberarr1[1]);
			member.setSsn(memberarr1[2]);
			member.setPassword(memberarr1[3]);
			member.setProfileImg(memberarr1[4]);
			member.setPhone(memberarr1[5]);
			member.setEmail(memberarr1[6]);
			try {
				service.change(member);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case RANK:
			break;
		case DELETE:
			break;
			
		}	
		
		}
	}
}
