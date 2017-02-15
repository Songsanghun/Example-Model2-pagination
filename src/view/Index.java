package view;

import javax.swing.JOptionPane;

import controller.CustomerController;
import controller.MemberController;
import controller.AdminController;

public class Index {
	
	public static void main(String[] args) {
			switch(JOptionPane.showInputDialog(null,"0.EXIT 1.일반회원 2.관리자 3.맴버가입 조회")){
			case "0": return;
			case "1": new CustomerController().start(); break; 
			case "2": new AdminController().start(); break;
			case "3": try {
				new MemberController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
