package service;
import domain.ArticleBean;
import java.util.*;
public interface BoardService {
	//c
	public void addArticle(ArticleBean param); // Article 글하나를 의미
	
	//r
	public ArticleBean findOne(ArticleBean param);
	public List<ArticleBean> findSome(ArticleBean param);
	public List<ArticleBean> List();
	
	//u
	public void update(ArticleBean param);
	//d
	public void delete(ArticleBean param);
}
