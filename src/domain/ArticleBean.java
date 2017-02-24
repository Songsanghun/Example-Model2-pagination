package domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class ArticleBean {
	@Getter @Setter
	private	String art_seq,id,title,content,regdate,readCount;
	
	@Override
	public String toString() {
		return String.format("[%s | %s | %s | %s | %s]", art_seq,id,title,regdate,"0"); //String.format("%s",""); 일단 이런 틀을 만들고 해라. seq : 일련번호
	}
	
}
