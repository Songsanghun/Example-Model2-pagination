package serviceImpl;

import java.util.*;

import dao.BoardDAO;
import daoImpl.BoradDAOImpl;
import domain.ArticleBean;
import service.BoardService;

public class BoradServiceImpl implements BoardService{
	private static BoradServiceImpl instance = new BoradServiceImpl();
	public static BoradServiceImpl getBorad() {
		return instance;
	}
	BoardDAO dao; 
	private BoradServiceImpl() {
		dao = BoradDAOImpl.getInstance();
	}
	@Override
	public String addArticle(ArticleBean param)throws Exception{
		String result = "";
		if(dao.insert(param)!=0){
			result = "게시물이 등록되었습니다.";
		}else{
			result = "게시물이 등록되지 않았습니다.";
		}
		return result;
	}
	@Override
	public ArticleBean findOne(ArticleBean param)throws Exception {
		return dao.selectBySeq(param);
	}
	@Override
	public List<ArticleBean> findSome(String[] param)throws Exception {
		
		return dao.selectByWord(param);
	}
	@Override
	public List<ArticleBean> List() throws Exception{
		return dao.selectAll();
	}
	@Override
	public String update(ArticleBean param) throws Exception{
		String result = "";
		if(dao.update(param)!=0){
			result = "게시물이 수정되었습니다.";
		}else{
			result = "수정할 게시물이 없습니다.";
		}
		return result;
	}
	@Override
	public String delete(ArticleBean param) throws Exception{
		String result = "";
		if(dao.delete(param)!=0){
			result = "게시물은 삭제되었습니다.";
		}else{
			result = "삭제할 게시물이 없습니다.";
		}
		return result;
	}
}
