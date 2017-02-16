package dao;

import java.util.List;

import domain.ArticleBean;

public interface BoardDAO {
	// c
	public int insert(ArticleBean param)throws Exception; // Article 글하나를 의미

	// r
	public ArticleBean selectBySeq(ArticleBean param)throws Exception;

	public List<ArticleBean> selectByWord(String[] param)throws Exception;

	public List<ArticleBean> selectAll()throws Exception;

	// u
	public int update(ArticleBean param)throws Exception;

	// d
	public int delete(ArticleBean param)throws Exception;
}
