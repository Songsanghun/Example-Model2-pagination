package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import constants.Database;
import dao.BoardDAO;
import domain.ArticleBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class BoradDAOImpl implements BoardDAO {
	private static BoradDAOImpl instance = new BoradDAOImpl();
	public static BoradDAOImpl getInstance() {
		return instance;
	}
	private BoradDAOImpl() {}
	@Override
	public int insert(ArticleBean param) throws Exception {
		String sql = String.format("INSERT INTO Acticle(seq,id,title,content,regdate,read_count)"
				+ "VALUES(seq.nextval,'%s','%s','%s','%s','%d')"
				, param.getId(),param.getTitle(),param.getContent(),param.getRegdate(),Integer.parseInt(param.getReadCount()));
		int rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
		return rs;
	}
	@Override
	public ArticleBean selectBySeq(ArticleBean param) throws Exception {
		ArticleBean article = null;    //null체크 
		String sql = String.format("SELECT seq,id,title,content,regdate,read_count "
				+ "	FROM Acticle WHERE seq='%s'", param.getSeq());
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeQuery(sql);
		if(rs.next()){
			article = new ArticleBean();
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("read_count"));
		}
		return article;
	}
	@Override
	public List<ArticleBean> selectByWord(String[] param) throws Exception {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		//like : '%찾아내고싶은 키워드%'
		ArticleBean article = null; 
		String sql = "SELECT seq,id,title,content,regdate,read_count FROM Acticle "
				+ " WHERE "+param[0]+" LIKE '%"+param[1]+"%'";
		System.out.println("DAO에서 실행된 쿼리:"+sql);
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeQuery(sql);
		while(rs.next()){
			article = new ArticleBean();
			article.setSeq(rs.getString("seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("read_count"));
			list.add(article);
		}
		return list;
	}
	@Override
	public List<ArticleBean> selectAll() throws Exception {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ArticleBean article = null;  //필수
		String sql = "SELECT seq,id,title,content,regdate,read_count FROM Acticle";
		
		Connection connection = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD)
				.getConnection();
		if(connection==null){
			System.out.println("커넥션이 널이다.");
		}else{
			System.out.println("널이 아니다.");
		}
		Statement stat = connection.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			article = new ArticleBean();
			article.setSeq(rs.getString("seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("read_count"));
			list.add(article);
		}
		return list;
	}

	@Override
	public int update(ArticleBean param) throws Exception {
		String sql =String.format("UPDATE Acticle SET title='%s',content='%s',regdate='%s' WHERE seq='%s'", param.getTitle(),param.getContent(),param.getRegdate(),param.getSeq());
		int rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);		
		return rs;
	}
	@Override
	public int delete(ArticleBean param) throws Exception {
		String sql = String.format("DELETE FROM Acticle WHERE seq='%s'", param.getSeq());
		int rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
		return rs;
	}
	@Override
	public int count() throws Exception {
		
		return 0;
	}
}
