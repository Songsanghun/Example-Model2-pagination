package domain;

public class MemberBean {
		protected String ssn, name, id, password, profileImg, phone , email, rank;

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public String getSsn() {
			return ssn;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getId() {
			return id;
		}
		public void setPassword(String password){
			this.password = password;
		}
		public String getPassword(){
			return password;
		}
		public void setProfileImg(String profileImg){
			this.profileImg = profileImg;
		}
		public String getProfileImg(){
			return profileImg;
		}
		public void setPhone(String phone){
			this.phone = phone;
		}
		public String getPhone(){
			return phone;
		}
		public void setEmail(String email){
			this.email = email;
		}
		public String getEmail(){
			return email;
		}
		
		public String calcGender(String ssn) {
			char ch = ssn.charAt(7);
			String gender = "";
			if (ch == '1' || ch == '3') {
				gender = "남자";
			} else if (ch == '2' || ch == '4') {
				gender = "여자";
			} else if (ch == '5' || ch == '6') {
				gender = "외국인";
			} else {
				gender = "올바른숫자가 아닙니다.";
			}
			return gender;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		@Override
		public String toString() {
		return String.format("%s(%s)[%s | **** | %s | %s | %s]"
				,name, ssn, id, phone , email,profileImg);
		}
}
