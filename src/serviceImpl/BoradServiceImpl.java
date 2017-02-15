package serviceImpl;

import java.util.*;

import domain.ArticleBean;
import service.BoardService;

public class BoradServiceImpl implements BoardService{
	private List<ArticleBean> list;
	public BoradServiceImpl() {
		list = new ArrayList<ArticleBean>();  //()안에 아무것도 안넣으면 Default 가 된다. 그러면 기본이 10 되고 1씩 증가한다.
	}
	@Override
	public void addArticle(ArticleBean param){
		list.add(param);
	}
	@Override
	public ArticleBean findOne(ArticleBean param) {
		ArticleBean articleOne = new ArticleBean();
		for(ArticleBean bean:list){
			if(param.getSeq().equals(bean.getSeq())){
				articleOne = bean;
				break;
			}
		}
		return articleOne;
	}
	@Override
	public List<ArticleBean> findSome(ArticleBean param) {
		List<ArticleBean> listSome = new ArrayList<ArticleBean>();
		for(ArticleBean bean:list){
			if(param.getId().equals(bean.getId())){
				listSome.add(bean);
			}
		}
		return listSome;
	}
	@Override
	public List<ArticleBean> List() {
		return list;
	}
	@Override
	public void update(ArticleBean param) {
		for(ArticleBean bean:list){
			if(param.getSeq().equals(bean.getSeq())){
				bean.setId((param.getId().equals(""))?bean.getId():param.getId());
				bean.setTitle((param.getTitle().equals(""))?bean.getTitle():param.getTitle());
				}
			}
	}
	@Override
	public void delete(ArticleBean param) {
		Iterator<ArticleBean> it = list.iterator();
		while(it.hasNext()){
			if(it.next().getSeq().equals(param.getSeq())){
				it.remove();
			}
		}
		
	}
}
