package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardDetailService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		// 1. 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
		int board_no = Integer.parseInt(opt.orElse("0"));
		
		// 2. BoardDAO의 selectBoardByNo 메소드를 호출
		BoardDTO board = BoardDAO.getInstance().selectBoardByNo(board_no);
		
		// 3. 존재하지 않는 게시글인 경우 응답 처리
		if(board == null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('존재하지 않는 게시글입니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.flush();
				out.close();
				return null;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 4. DB에서 가져온 게시글(BoardDTO board)을 request에 저장
		// (상세보기 화면 - board/detail.jsp으로 전달(forward)하기 위해서)
		request.setAttribute("board", board);
		
		// 5. 어디로 어떻게 이동할 것인가
		return new ActionForward("board/detail.jsp", false);
	}

}
