package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import constants.Database;
import dao.BoardDAO;
import domain.ArticleBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class BoardDAOImpl implements BoardDAO {
	private static BoardDAOImpl instance = new BoardDAOImpl();
	public static BoardDAOImpl getInstance() {
		return instance;
	}
	private BoardDAOImpl() {}
	@Override
	public int insert(ArticleBean param) throws Exception {
		String sql = String.format("INSERT INTO Article(art_seq,id,title,content,regdate,read_count)"
				+ "VALUES(seq.nextval,'%s','%s','%s','%s','%d')"
				, param.getId(),param.getTitle(),param.getContent(),param.getRegdate(),Integer.parseInt(param.getReadCount()));
		int rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
		return rs;
	}
	@Override
	public ArticleBean selectBySeq(ArticleBean param) throws Exception {
		ArticleBean article = null;    //null체크 
		String sql = String.format("SELECT art_seq,id,title,content,regdate,read_count "
				+ "	FROM Article WHERE seq='%s'", param.getArt_seq());
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
		String sql = "SELECT seq,id,title,content,regdate,read_count FROM Article "
				+ " WHERE "+param[0]+" LIKE '%"+param[1]+"%'";
		System.out.println("DAO에서 실행된 쿼리:"+sql);
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeQuery(sql);
		while(rs.next()){
			article = new ArticleBean();
			article.setArt_seq(rs.getString("art_seq"));
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
	public List<ArticleBean> selectAll(int[] pageArr) throws Exception {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ArticleBean article = null;  //필수
		String sql = 
				String.format("SELECT t2.*"
						   +"\tFROM (SELECT ROWNUM seq,t.*" 
					       +"\tFROM (SELECT * FROM ARTICLE ORDER BY art_seq DESC) t) t2"
					       +"\tWHERE t2.seq BETWEEN %s AND %s", String.valueOf(pageArr[0]),
					       String.valueOf(pageArr[1]));
		Connection connection = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD)
				.getConnection();
		if(connection==null){
			//System.out.println("커넥션이 널이다.");
		}else{
			//System.out.println("널이 아니다.");
		}
		Statement stat = connection.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			article = new ArticleBean();
			article.setArt_seq(rs.getString("art_seq"));
			article.setId(rs.getString("pat_id"));
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
		String sql =String.format("UPDATE Article SET title='%s',content='%s',regdate='%s' WHERE seq='%s'", param.getTitle(),param.getContent(),param.getRegdate(),param.getArt_seq());
		int rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);		
		return rs;
	}
	@Override
	public int delete(ArticleBean param) throws Exception {
		String sql = String.format("DELETE FROM Article WHERE seq='%s'", param.getArt_seq());
		int rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
		return rs;
	}
	@Override
	public int count() throws Exception {
		int count=0;
		String sql = "SELECT COUNT(*) AS count FROM Article";
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME ,Database.PASSWORD)
				.getConnection().createStatement().executeQuery(sql);
		if(rs.next()){
			count=Integer.parseInt(rs.getString("COUNT"));
		}
		return count;
	}
}
