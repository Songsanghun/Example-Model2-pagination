package service;

import domain.MemberBean;

public interface MemberService {
	public int join(MemberBean member) throws Exception;  //regist해라 MemberBean 을
	public MemberBean findById(String id) throws Exception; // MemberBean 에서 find 해라 String id를 
	public boolean login(MemberBean member) throws Exception; // login해라 Member member을 참 거짓 구별.
	public boolean logout(MemberBean member) throws Exception; 
	public int change(MemberBean member) throws Exception; //change해라 MemberBean을
	public int remove(MemberBean member) throws Exception; //remove해라 MemberBean을
	
	
}
