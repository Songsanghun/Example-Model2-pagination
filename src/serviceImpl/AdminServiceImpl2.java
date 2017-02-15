package serviceImpl;

import domain.MemberBean;
import service.AdminService2;

public class AdminServiceImpl2 implements AdminService2{
	private MemberBean member; // 집합 하나는 하나의 요소를 여러번 넣어서 만들어 진다. 자료구조 컬렉션이다.
	private MemberBean[] arr;
	private int count;
	public AdminServiceImpl2() {
		member = new MemberBean();
		count = 0;
		arr = new MemberBean[count]; //주소만 있는 상태 NULL 값 처리 상태 담는 공간이 없다. 메모리 상에 주소값은 가진다.
		//arr은 heap에 저장.
	}
	@Override
	public void regist(MemberBean member) {
		// 회원정보를 입력한 후 배열에 저장하기
		if(count == arr.length){
			MemberBean[] temp = new MemberBean[count+10];  //new로 인하여 배열이 생성. 스텍 stack 에 저장.
			System.arraycopy(arr, 0, temp, 0, count);  //count가 10일때 20칸 짜리 배열이 생성되고 기존에 생성되어있었던 10칸을 복사했다.override
			arr=temp;
		}
			arr[count++]=member;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();       //타입이 MemberBean  이기 때문에 리턴타입은 MemberBean 이여야 한다. 무조건 만들어라.
		for(int i=0;i<count;i++){                   //DB를 조회하는데 있어서 횟수는 중요 그래서 arr.length 가 아니라 count 다.
			if(id.equals(arr[i].getId())){         //id가 기준이 되고 arr[i].getId()가 변수가 된다.
				member = arr[i];                    //arr의 i번째의 객체를 member에 넣어준다.
				break;
			}
		}   
		return member;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int nameCount = countByName(name);
		MemberBean[] list = new MemberBean[nameCount];
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
			//	arr = list[i];  에러가 난 이유는 타입이 맞지 않아서 에러가 난것이다.
				arr[i] = list[i]; 
			}
		}
		return arr;
	}
	@Override
	public int countByName(String name) {
		int nameCount = 0;
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
				nameCount++;
			}
		}
		return nameCount;
	}


	@Override
	public MemberBean[] list() {
		// 전체목록 출력
		return arr;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public void changeRank(MemberBean member) {
		for(int i=0;i<count;i++){
			if(member.getId().equals(arr[i].getId())){
				arr[i].setRank(member.getRank());
				break;
			}
		}
	}

	@Override
	public void remove(String id) {
		for(int i=0;i<count;i++){
			if(id.equals(arr[i].getId())){
				//arr[i]=arr[i+1];    //i+1에 a,b,c 에서 b지우면 b자리에 c가 온다. 이렇게 되면 100만개 있을경우 과부화가 걸린다.
				arr[i]=arr[count-1];  // 88번째의 과부하를 해결하기 위해 일일이 다 옮기는것이 아니고  
				arr[count-1]=null;
				count--; 
				break;
			}
		}
	}
	@Override
	public boolean exist(String keyword) {
		boolean check = false;
		for(int i=0;i<count;i++){
			if(keyword.equals(arr[i].getId())){
				check=true;
				break;
			}
		}
		return check;
	}
	
	
	
	
	
}