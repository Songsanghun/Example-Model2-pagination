package service;

import domain.MemberBean;
import java.util.*;

public interface AdminService {
	//비지니스 로직 = DB 데이터와 일치
	//qurey 문에 들어가는 키워드는 사용하지 마라.
	/**
	* CREATE : INSERT
	*
	*/
	public void regist(MemberBean member); //저장할때는 Map이 가장 빠르다. 
	/**
	* READ : SELECT
	*
	*/
	// read one
	// read some
	// read all
	// read special
	public MemberBean findById(String id);  
	public List<MemberBean> findByName(String name); 
	public Map<String,MemberBean> mapFindByName(String name); 
	public List<MemberBean> memberList();
	public List<String> keyList();
	public int count();
	/**
	* UPDATE : UPDATE
	*
	*/
	public void update(MemberBean member); //change해라 MemberBean을
	/**
	* DELETE : DELETE
	*
	*/
	public void remove(String id); //remove해라 id을 넣어서 
	// util
	// validation
}
