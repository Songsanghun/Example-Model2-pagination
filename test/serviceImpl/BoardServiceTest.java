package serviceImpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import domain.ArticleBean;

public class BoardServiceTest {

	BoardServiceImpl service = new BoardServiceImpl();

	@Test
	@Ignore
	public void testAddArticle() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setId("song");
		bean.setContent("안녕하세요");
		bean.setTitle("인사말");
		bean.setReadCount("50");
		bean.setRegdate("2017-02-01");
		assertTrue(service.addArticle(bean).equals("게시물이 등록되었습니다."));
	}

	@Test

	public void testFindOne() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setArt_seq("27");
		assertTrue(service.findOne(bean).getId().equals("송상"));
	}

	@Test
	@Ignore
	public void testFindSome() throws Exception {
		String[] arr =new String[2];
		arr[0] = "title";
		arr[1] = "후기";
		List<ArticleBean> list = new ArrayList<>();
		list = service.findSome(arr);
		assertTrue(list.get(0).getId().equals("가렌"));
	}
	@Test
	@Ignore
	public void testList(int[] pageArr) throws Exception {
		List<ArticleBean> list = new ArrayList<>();
		list = service.list(pageArr);
		assertTrue(list.get(0).getId().equals("송상"));
	}

	@Test
	@Ignore
	public void testUpdate() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setTitle("노답 골드");
		bean.setContent("랭겜 15연패");
		bean.setRegdate("2017-01-01");
		bean.setArt_seq("36");
		assertTrue(service.update(bean).equals("게시물이 수정되었습니다."));
	}

	@Test
	@Ignore
	public void testDelete() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setArt_seq("40");
		assertTrue(service.delete(bean).equals("게시물은 삭제되었습니다."));
	}
}
