package controller;

import java.util.*;
import domain.ArticleBean;

//1.추가..주어진 BbsBean 값을 vec 에 추가하기
//1,James,Hello,2016-2-6 17:30
//2,Tom,Hi,2016-8-6 17:30
//3,Alex,Good Morning,2016-11-20 17:30
//4,Betty,I'm happy,2016-12-25 17:30
//5,John,Thank you,2017-2-6 17:30
//2.검색(1)..seq가 1인 글 검색, 
//해당 seq 가 있으면 내용을 보여주고
//없으면 해당글이 존재하지 않는다고 출력함
//3.검색(some)...
//James 가 쓴 글 검색
//하나라도 없으면 해당글이 존재하지 않는다고 출력함
//4.전체 출력
//글이 하나도 없으면
//빈 게시판 이라고 출력함
//5.수정 (seq가 1인 글의 내용을 Good Bye)로 변경
//수정이 끝나면 바뀐 글내용 출력하기
//6.삭제 (seq가 인 글을 삭제)
//삭제가 끝나면 해당글이 없다고 출력함
public class BoardController {
	public static void main(String[] args) {
		List<ArticleBean> list = new Vector<ArticleBean>(10,10); //
		// 0.리스트 스펙보기
		//System.out.println("CAPA : " +list.capacity());
		//System.out.println("SIZE : " +list.size());
		// 1.추가..주어진 BbsBean 값을 vec 에 추가하기
		//1,James,Hello,2016-2-6 17:30
		//2,Tom,Hi,2016-8-6 17:30
		//3,Alex,Good Morning,2016-11-20 17:30
		//4,Betty,I'm happy,2016-12-25 17:30
		//5,John,Thank you,2017-2-6 17:30
		ArticleBean a = new ArticleBean();
		a.setSeq("1");
		a.setId("James");
		a.setTitle("Hello");
		a.setRegdate("2016-2-6 17:30");
		list.add(a);
		a = new ArticleBean();
		a.setSeq("2");
		a.setId("Tom");
		a.setTitle("Hi");
		a.setRegdate("2016-8-6 17:30");
		list.add(a);
		a = new ArticleBean();
		a.setSeq("3");
		a.setId("Alex");
		a.setTitle("Good Morning");
		a.setRegdate("2016-11-20 17:30");
		list.add(a);
		a = new ArticleBean();
		a.setSeq("4");
		a.setId("Betty");
		a.setTitle("I'm happy");
		a.setRegdate("2016-12-25 17:30");
		list.add(a);
		a = new ArticleBean();
		a.setSeq("5");
		a.setId("John");
		a.setTitle("Thank you");
		a.setRegdate("2017-2-6 17:30");
		list.add(a);
		//System.out.println(list);
		// 2-1.검색(1)...맨 마지막에 추가한 글 검색,
		String result = "";
		for(int i=0;i<list.size();i++){       // list.capacity()는 랭스 여기에선 10을 의미 list.size();는 카운트를 의미
			if(i==list.size()-1){
				result=list.get(i).toString(); // list.elementAt(i) 가 안되는 이유는 List method 가 아니라 vector method 기 때문에 다형성이 안된다.
			}
		}
		System.out.println(result);
		// 2-2.검색(1)..seq가 3인 글 검색
		Set<ArticleBean> set = new HashSet<ArticleBean>();
		for(int i=0;i<list.size();i++){
			if("3".equals(list.get(i).getSeq())){
				set.add(list.get(i));
			}
		}
		System.out.println(set.toString());
		// 3.검색(some)...James 가 쓴 글 검색
		set = new HashSet<ArticleBean>(); 
		for(int i=0;i<list.size();i++){
			if("James".equals(list.get(i).getId())){
				set.add(list.get(i));
			}
		}
		System.out.println(set.toString());
		// 4.전체 출력
		System.out.println(list);
		// 5.수정 (seq가 1인 글의 내용을 Good Bye)로 변경
		set = new HashSet<ArticleBean>();
		for(int i=0;i<list.size();i++){
			if("1".equals(list.get(i).getSeq())){
				list.get(i).setTitle("Good Bye");
			}
		}
		System.out.println(list);
		// 수정이 끝나면 바뀐 글내용 출력하기

		// 6.삭제 (seq가 3인 글을 삭제)
		set = new HashSet<ArticleBean>();
		for(int i=0;i<list.size();i++){
			if(list.contains(list.get(i))){
			}
		}
		Iterator<ArticleBean>it = list.iterator();
		while(it.hasNext()){
			if(it.next().getSeq().equals("3")){  //itertor 야 3번 가서 찾아
				it.remove();					 // 찾았으면 지워
			}
		}
		System.out.println(list);
		
		
		// 삭제가 끝나면 해당글이 없다고 출력함
		
	}
}
