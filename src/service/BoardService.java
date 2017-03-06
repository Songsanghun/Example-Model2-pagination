package service;
import domain.ArticleBean;
import java.util.*;
public interface BoardService {
	//c
	public String addArticle(ArticleBean param)throws Exception; // Article 글하나를 의미
	
	//r
	public ArticleBean findOne(ArticleBean param)throws Exception;
	public List<ArticleBean> findSome(String[] param)throws Exception;
	public List<ArticleBean> list(int[] pageArr)throws Exception;
	
	//u
	public String update(ArticleBean param)throws Exception;
	//d
	public String delete(ArticleBean param)throws Exception;
	public int count()throws Exception;
}
