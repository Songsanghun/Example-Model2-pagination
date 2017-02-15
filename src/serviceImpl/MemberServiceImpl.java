package serviceImpl;

import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
		private MemberBean session;
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	public MemberServiceImpl() {
		session = new MemberBean();
	}

	@Override
	public int join(MemberBean member) throws Exception {
		return MemberDAOImpl.getInstance().insert(member);
	}

	@Override
	public MemberBean findById(String id) throws Exception {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public boolean login(MemberBean member) throws Exception{
		boolean check = false;
		MemberBean temp = this.findById(member.getId());
		if(member.getPassword().equals(temp.getPassword())){
			session=temp;
			check = true;
		}
		return check;
	}

	@Override
	public int change(MemberBean member) throws Exception{
		return MemberDAOImpl.getInstance().update(member);
		
	}

	@Override
	public int remove(MemberBean member) throws Exception {
		return MemberDAOImpl.getInstance().delete(member);
		
	}
	@Override
	public boolean logout(MemberBean member) throws Exception {
		session=null;
		return true;
	}
	
}
