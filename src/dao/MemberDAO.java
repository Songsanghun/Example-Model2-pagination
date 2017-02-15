package dao;

import domain.MemberBean;

public interface MemberDAO {
	public int insert(MemberBean member) throws Exception;  //이름은 Quary 문으로 해줘라.
	public MemberBean selectById(String id) throws Exception; 
	/*public boolean login(MemberBean member) throws Exception;*/
	public int update(MemberBean member) throws Exception; 
	public int delete(MemberBean member) throws Exception; 
}
