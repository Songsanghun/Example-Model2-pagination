package domain;

public class ArticleBean {
	private	String seq,id,title,content,regdate,readCount;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		return String.format("[%s | %s | %s | %s | %s]", seq,id,title,regdate,"0"); //String.format("%s",""); 일단 이런 틀을 만들고 해라. seq : 일련번호
	}
	
}
