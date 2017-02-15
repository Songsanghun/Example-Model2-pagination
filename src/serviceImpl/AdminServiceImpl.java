package serviceImpl;
import domain.MemberBean;
import service.AdminService;
import java.util.*;

public class AdminServiceImpl implements AdminService{
	private Map<String,MemberBean> map;  //주소만 있는 상태 NULL 값 처리 상태 담는 공간이 없다. 메모리 상에 주소값은 가진다.
	public AdminServiceImpl() {
		map = new HashMap<String,MemberBean>();
		//map은 heap에 저장.
	}
	@Override
	public void regist(MemberBean member) {
		map.put(member.getId(), member);
	}
	@Override
	public MemberBean findById(String id) {
		/*
		MemberBean member = new MemberBean();
		List<MemberBean> list =this.list();
		for(MemberBean m:list){  
			if(id.equals(m.getId())){
				member = m;
				break;
			}
		}
		return member;
		*/
		return map.get(id);
		//return (map.containsKey(id))?map.get(id):null;
		
	/*	if(map.containsKey(id)){
			map.get(id);
		}else{
			null;
		}*/
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> some = new ArrayList<MemberBean>();
		for(MemberBean m:memberList()){
			if(name.equals(m.getName())){
				some.add(m);
			}
		}
		return some;
	}
	@Override
	public List<MemberBean> memberList() {
		List<MemberBean> list = new ArrayList<MemberBean>();
		for(Map.Entry<String, MemberBean> e: map.entrySet()){
			list.add(e.getValue());
		}
		return list;
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public void update(MemberBean member) {
		for(MemberBean m:memberList()){
			if(member.getId().equals(m.getId())){
				m.setName((member.getName().equals(""))?m.getName():member.getName());
				m.setPassword((member.getPassword().equals(""))?m.getPassword():member.getPassword());
				m.setProfileImg((member.getProfileImg().equals(""))?m.getProfileImg():member.getProfileImg());
				m.setPhone((member.getPhone().equals(""))?m.getPhone():member.getPhone());
				m.setEmail((member.getEmail().equals(""))?m.getEmail():member.getEmail());
				m.setRank((member.getRank().equals(""))?m.getRank():member.getRank());
				break;
			}
		}
	}
	@Override
	public void remove(String id) {
		map.remove(id);   //reuse 재활용성
	}
	@Override
	public Map<String, MemberBean> mapFindByName(String name) {
		Map<String, MemberBean> temp = new HashMap<String, MemberBean>();
		for(Map.Entry<String, MemberBean> e: map.entrySet()){
			if(name.equals(e.getValue().getName())){
				temp.put(e.getKey(), e.getValue());
			}
		}
		return temp;
	}
	@Override
	public List<String> keyList() {
		List<String> list = new ArrayList<String>();
		for(Map.Entry<String, MemberBean> e: map.entrySet()){
			list.add(e.getKey());
		}
		return list;
	}
}