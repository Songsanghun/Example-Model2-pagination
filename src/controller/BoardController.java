package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serviceImpl.BoardServiceImpl;
import util.DispatcherServlet;
import util.Separator;
import domain.ArticleBean;

@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		ArticleBean bean=new ArticleBean();
		System.out.println("게시판 서블릿");
		java.util.List<ArticleBean> list=new ArrayList<>();
		service.BoardService service=BoardServiceImpl.getInstance();
		switch (Separator.command.getAction()) {
			case "move":DispatcherServlet.send(request, response);break;
			case "list":
			String strPageNO=request.getParameter("pageNO");
			System.out.println("화면에서 넘어온 PAGE_NO :"+strPageNO);
			int rowCount=5;
			int pageNO=Integer.parseInt(strPageNO);
			int pageStart=(pageNO-1)*rowCount+1;
			int pageEnd=pageNO*rowCount;
			int[] pageArr={pageStart,pageEnd};
			int count=0;
			try {
				list=service.list(pageArr);
				count = service.count();
			} catch (Exception e) {
				e.printStackTrace();
			}
			int pageCount=0;
			if(count%rowCount==0){
				pageCount=count/rowCount;
			}else{
				pageCount=count/rowCount+1;
			}
			int blockSize=5;
			int blockCount=pageCount/blockSize;
			
			int blockStart=pageNO-((pageNO-1)%blockSize);
			int prevBlock=blockStart-blockSize;
			int nextBlock=blockStart+blockSize;
			int blockEnd=0;
			blockEnd=blockCount;
			System.out.println("블록이 항상 참이다: "+(blockStart + rowCount-1));
			System.out.println("페이지카운트: "+pageCount);
			if((blockStart+rowCount-1) < pageCount){
				blockEnd=blockStart+blockSize-1;
			}else{
				blockEnd=pageCount;
			}
			request.setAttribute("count", count);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("list", list);
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageEnd);
			request.setAttribute("blockStart", blockStart);
			request.setAttribute("blockEnd", blockEnd);
			request.setAttribute("prevBlock", prevBlock);
			request.setAttribute("nextBlock", nextBlock);
			request.setAttribute("pageNO", pageNO);
			break;
			case "detail":
				String seq=request.getParameter("art_seq");
				bean.setArt_seq(seq);
			try {
				bean=service.findOne(bean);
				request.setAttribute("article", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
		}
		DispatcherServlet.send(request, response);
	}

}