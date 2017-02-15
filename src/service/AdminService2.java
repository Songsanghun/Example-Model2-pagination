package service;
import domain.MemberBean;

public interface AdminService2 {
	//비지니스 로직 = DB 데이터와 일치
	//qurey 문에 들어가는 키워드는 사용하지 마라.
	/**
	* CREATE : INSERT
	*
	*/
	public void regist(MemberBean member);  //regist해라 MemberBean 을
	/**
	* READ : SELECT
	*
	*/
	// read one
	// read some
	// read all
	// read special
	public MemberBean findById(String id); // MemberBean 에서 find 해라 String id를 
	public MemberBean[] findByName(String name); //name을 findByname해라 반환은 Memberan[]로
	public MemberBean[] list();
	public int count();
	/**
	* UPDATE : UPDATE
	*
	*/
	public void changeRank(MemberBean member); //change해라 MemberBean을
	/**
	* DELETE : DELETE
	*
	*/
	public void remove(String id); //remove해라 id을 넣어서 
	// util
	// validation
	public boolean exist(String keyword);
	public int countByName(String name); //이름을 카운트 이름 숫자 (랭스를 정해줘야 배열을 불러올수있다.)
}
