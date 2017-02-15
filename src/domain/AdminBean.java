package domain;

public class AdminBean extends MemberBean{
	private String permission;
	public void setPermission(String permission){
		this.permission = permission;
	}
	public String getPermission(){
		return permission;
	}
	public String toString() {
		return String.format("%s(%s)[%s | **** | %s | %s | 관리자 ]"
				,name, ssn, id, phone , email);
		}
}
