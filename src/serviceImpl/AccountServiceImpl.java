package serviceImpl;

import util.RandomGenerator;
import domain.AccountBean;
import service.AccountService;
import constants.Account;
import java.util.Calendar;
public class AccountServiceImpl implements AccountService{
	AccountBean[] list;     //has a 사용하고 유지되는것 (association : 연관관계)
	//비지니스 로직  = DB 의 데이터와 일치
	public AccountServiceImpl(){  //BankServiceImpl 는 생성자라서 이름을 바꿀수없다.
		list = new AccountBean[10000];  
	}
	@Override
	public AccountBean createAccountBean(String uid, String accountType, int money) {  // 해석좀 크리에이트어카운트빈 메소드를 호출했을때 어카운트 빈을 생성한다.
		AccountBean account = new AccountBean(); //has a 한번만 쓰고 버리고 Dependency(의존관계)
		account.setAccountNo(
				String.valueOf(RandomGenerator.getRandomNum(999999,100000)));
		account.setCreateDate(Calendar.getInstance().get(Calendar.YEAR)+"년 "
				+ Calendar.getInstance().get(Calendar.MONTH)+1+"월 "
				+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+" 일");
		account.setId(uid);
		account.setAccountType(accountType);
		account.setMoney(String.valueOf(money));
		list[0]=account;
		return account; //원래대로 라면 list[0]에 있는거 만 보여줘야 한다. 
	}
	@Override
	public boolean checkMoney(int money) {
		return money>=0;
	}

	@Override
	public String deposit(int money) {
		String result = Account.DEPOSIT_FAIL;
		if(checkMoney(money)){
			list[0].setMoney(
					String.valueOf((Integer.parseInt(list[0].getMoney())+money)));
			result = Account.DEPOSIT_SUCCESS;
		}
		return result;
	}
	@Override
	public String withdraw(int money) {
		String result = Account.WITHDRAW_FAIL;
		if(checkMoney(Integer.parseInt(list[0].getMoney())-money)){
			list[0].setMoney(
					String.valueOf(Integer.parseInt(list[0].getMoney())-money));
			result = Account.WITHDRAW_SUCCESS;
		}
		return result;
	}
	@Override
	public AccountBean findByAccountNo(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AccountBean[] findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public AccountBean[] list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void drop(String accontNo) {
		// TODO Auto-generated method stub
		
	}
}
